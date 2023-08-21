package com.decimal.springsecurity.rest.filter;

import com.decimal.springsecurity.rest.model.security.User;
import com.decimal.springsecurity.rest.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        final String authorization = request.getHeader(AUTHORIZATION_HEADER);
        String username = null;
        Claims claims = null;
        String jwt;
        if (null != authorization && authorization.startsWith("Bearer ")) {
            jwt = authorization.substring(7);
            claims = JwtUtil.extractAllClaims(jwt);
            username = claims.getSubject();
        }
        if (null != username && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = new User(username, claims.get("userId").toString());
            List<GrantedAuthority> authorities = JwtUtil.generateAuthoritiesFromClaims(claims);
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
                    authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
