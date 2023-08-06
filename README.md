# Spring Security

Spring provides a comprehensive set of tools customizable to fulfill almost every need of applications.
To provide you with an overview of what spring security provides, have a look at below list.

## What Spring security can do?
- Application Security
- Provide login and logout functionality
- SSO / Okta / LDAP
- App Level Authorization
- Intra App authorization using OAuth.
- Microservices Security (using tokens, JWT ...)
- Method level security
- Allow/block access URLs to logged-in users (and with certain roles)
- Handle common vulnerabilities
    - Session fixation
    - Clickjacking
    - Click site request forgery

Before diving deep into the world of security it is most important to learn about the basic security concepts.
Please go through the document: [Basic Security Concepts.md](docs%2FBasic%20Security%20Concepts.md) to learn more about
these concepts.

## Default Spring security behavior
Right after adding the spring security dependency in the project. Spring does below things:
- Adds mandatory authentication for URLs. (Not for errors)
- Adds login form
- Handles login error
- Creates a user and sets a default password

This repository contains a dummy project to showcase the working of spring security.
