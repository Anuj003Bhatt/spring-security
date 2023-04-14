# Security

In the application world the term security is often implies 2 things, 
- Authentication (who)
- Authorization (what)

## Authentication (AuthN)
Authentication refers to the process of identifying/verifying the principle.
A principle can be a human, machine etc.

### Authentication Support from Spring
- HTTP basic and digest, x509 certificate and form based authentication
- LDAP and Active Directory
- OpenID, JasigCAS (Central authentication service) and JAAS
- Kerberos and SAML

## Authorization (AuthZ)
After identifying the principle we can identify what they can do with the system, which is what we term as authorization.
Note: 
- Authorization is based on authentication. In order to identify what can be done, it is essential to identify the principle.
- Authorization is also called as access control

### Authorization Support from Spring
- Web request based authorization
- Method invocation security
- Domain Object instance access control
