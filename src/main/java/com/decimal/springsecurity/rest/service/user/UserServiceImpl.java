package com.decimal.springsecurity.rest.service.user;

import com.decimal.springsecurity.rest.api.UserApi;
import com.decimal.springsecurity.rest.model.request.AddUserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final UserApi userApi;

    @Override
    public Map<String, Object> addUser(AddUserRequest request) {
        try {
            return userApi.addUser(MAPPER.writeValueAsString(request)).map(
                    response -> {
                        try {
                            return MAPPER.readValue(response, new TypeReference<Map<String, Object>>(){});
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException("Error while parsing add user response");
                        }
                    }
            ).toBlocking().value();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while parsing object payload for user creation.");
        }
    }
}
