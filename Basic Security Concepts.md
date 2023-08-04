# Security

There are five basic security terms that every developer should be aware of:

- Authentication
- Authorization
- Principal
- Granted Authority
- Roles

In the application world the term security is often implies 2 things,

- Authentication (who)
- Authorization (what)

## Authentication (AuthN)

Authentication refers to the process of identifying/verifying the principle.
A principle can be a human, machine etc.

### Some types of authentication

- Knowledge based authentication
    - Ex: Password, Pin-code, Secret Question
- Possession based authentication
    - Ex: Phone/Text messages, Key-cards/Badges, Access token device
    - Knowledge based + Possession based authentication = Multi-factor (2 factor) authentication

### Authentication Support from Spring

- HTTP basic and digest, x509 certificate and form based authentication
- LDAP and Active Directory
- OpenID, JasigCAS (Central authentication service) and JAAS
- Kerberos and SAML

## Authorization (AuthZ)

After identifying the principle we can identify what they can do with the system, which is what we term as
authorization.

Note:

- Authorization is based on authentication. In order to identify what can be done, it is essential to identify the
  principle.
- Authorization is also called as access control

### Authorization Support from Spring

- Web request based authorization
- Method invocation security
- Domain Object instance access control

## Principal

Principal is basically the *"who"*. Meaning its the entity trying to access some resource or perform some actions
via the application.

## Granted authority

In order to be able to authorize any function the system must be able to identify the user (which is already explained
above) and also should be able to decide whether the entity is allowed to perform the requested actions.

- Authority: These permissions/authorities granted to the user are called *"Granted Authority"* and refers to the
  actions that a user is allowed to perform.

## Roles
Authorities are fine-grained and specifies each action that a user of system can do.
Consider below example:
In an organization, an HR an perform below actions
- Hire
- Promote
- Transfer

Now everytime a new HR is hired all these authorities must be manually granted which can seem tedious.

This is where the concept of **Roles** comes in.
- Roles: This is a group of authorities
- Roles are more coarse-grained