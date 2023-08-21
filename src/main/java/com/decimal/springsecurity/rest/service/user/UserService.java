package com.decimal.springsecurity.rest.service.user;

import com.decimal.springsecurity.rest.model.request.AddUserRequest;

import java.util.Map;

public interface UserService {
    Map<String, Object> addUser(AddUserRequest request);
}
