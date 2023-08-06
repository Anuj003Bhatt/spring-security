# Configuring Spring Security

This file contains details on how to configure spring security for your project.

## Initial Setup
- We will use some database to authenticate user's (H2 embedded database in this case)
- We already have a spring boot project with spring security added in dependency at this stage.
  - Adding the dependency adds default authentication to the project.
  - The default username and password can be added in the application properties using below properties:
    - ```
      spring.security.user.name=root
      spring.security.user.password=root
      ```
## How this works?
In Spring boot its the `AuthenticationManager` that does the authentication which either allows the request or 
throws an exception that the request cannot be authenticated.

In order to create customer authentication for the app, the functionality of this `AuthenticationManager` is overridden.
Although developers do not work directly with the `AuthenticationManager` but they can create custom authentication
mechanism using the builder pattern that the class provides.

### Steps
- Get the `AuthenticationManagerBuilder` from Spring.
- Set the configuration on this builder.

### Examples and Use cases

To enable security for the project create a security configuration like `WebSecurityConfig` in this project that must
have these annotations
```
@EnableWebSecurity
@EnableMethodSecurity
@Configuration
```
- `@EnableWebSecurity` - This enables web security for the project.
- `@EnableMethodSecurity` - Since REST endpoints are basically methods, method level security needs to be explicitly enabled.
- `@Configuration` - To acknowledge that this contains configuration for project

Taking a step forward this can further be extended in 2 ways:
- Providing a custom `SecurityFilterChain` bean.
- Defining a `UserDetailsManager` or `UserDetailsService`

In this project we have used, in memory authentication using the `SecurityFilterChain` approach but a sample bean of the other is below:
```
@Bean
public UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("root")
      .password(bCryptPasswordEncoder.encode("root"))
      .roles("ADMIN")
      .build());
    return manager;
}
```
**Note:** Multiple users can also be added by calling the same function i.e., `createUser` multiple times.