package com.decimal.springsecurity.rest.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public abstract class JwtUtil {
    private static final String SECRET = "Secret";
    private static final String ROLES = "roles";
    private static final String ROLE_GROUPS = "roleGroups";
    private static final String USER_GROUPS = "userGroups";

    private static final Long EXPIRATION = 36000000L;// EXPIRATION IN MILLIS ~ 10 Hours
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    private static <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }
    public static String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private static Boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration)
                .before(new Date());
    }

    public static List<GrantedAuthority> generateAuthoritiesFromClaims(Claims claims) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (claims.get(ROLES) instanceof List<?>){
            authorities.addAll(
                    generateAuthoritiesFromName((List<String>) claims.get(ROLES))
            );
        }

        if (claims.get(ROLE_GROUPS) instanceof List<?>){
            authorities.addAll(
                    generateAuthoritiesFromName(((List<String>)claims.get(ROLE_GROUPS)))
            );
        }

        if (claims.get(USER_GROUPS) instanceof List<?>){
            authorities.addAll(
                    generateAuthoritiesFromName(((List<String>)claims.get(USER_GROUPS)))
            );
        }
        return authorities;
    }

    private static List<GrantedAuthority> generateAuthoritiesFromName(List<String> auth) {
        return auth.stream().map(
                r -> (GrantedAuthority) () -> r
        ).toList();
    }
}
