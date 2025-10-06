# JWT (JSON Web Token) Implementation

<img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' />

## Problem Description

Implement a JSON Web Token (JWT) encoder and decoder with HMAC-SHA256 signature verification.

## What is JWT?

JWT (JSON Web Token) is a compact, URL-safe means of representing claims to be transferred between two parties. It's commonly used for authentication and information exchange in web applications.

A JWT consists of three parts separated by dots (`.`):

```
header.payload.signature
```

### Structure

1. **Header**: Contains the token type and hashing algorithm
   ```json
   {
     "alg": "HS256",
     "typ": "JWT"
   }
   ```

2. **Payload**: Contains the claims (data you want to transmit)
   ```json
   {
     "userId": 123,
     "username": "john_doe",
     "role": "admin"
   }
   ```

3. **Signature**: Used to verify the token hasn't been tampered with
   ```
   HMACSHA256(
     base64UrlEncode(header) + "." + base64UrlEncode(payload),
     secret
   )
   ```

## Implementation Details

### Core Methods

1. **`encode(String payload, String secret)`**
   - Creates a JWT token from a JSON payload
   - Signs the token using HMAC-SHA256 with the provided secret
   - Returns the complete JWT token (header.payload.signature)

2. **`decode(String token, String secret)`**
   - Decodes a JWT token
   - Verifies the signature matches the expected value
   - Returns the payload if valid
   - Throws exception if signature is invalid

3. **`verify(String token, String secret)`**
   - Verifies if a JWT token is valid
   - Returns true/false without throwing exceptions

4. **`getPayload(String token)`**
   - Extracts payload without verification (use with caution)
   - Useful for inspecting tokens

5. **`getHeader(String token)`**
   - Extracts header information
   - Returns the algorithm and type

### Algorithm: HMAC-SHA256

The implementation uses HMAC-SHA256 (Hash-based Message Authentication Code with SHA-256) for signing:
- Provides cryptographic security
- Ensures data integrity
- Prevents tampering

### Base64URL Encoding

Uses Base64URL encoding (RFC 4648) which is URL-safe:
- Replaces `+` with `-`
- Replaces `/` with `_`
- Removes padding `=` characters

## Example Usage

```java
// Create a JWT token
String secret = "my-secret-key";
String payload = "{\"userId\":123,\"username\":\"john_doe\",\"role\":\"admin\"}";

// Encode
String token = JWT.encode(payload, secret);
System.out.println("Token: " + token);

// Decode and verify
String decodedPayload = JWT.decode(token, secret);
System.out.println("Payload: " + decodedPayload);

// Verify only
boolean isValid = JWT.verify(token, secret);
System.out.println("Valid: " + isValid);

// Extract without verification
String header = JWT.getHeader(token);
String payloadOnly = JWT.getPayload(token);
```

## Security Considerations

1. **Keep the secret key secure**: Never expose it in client-side code
2. **Use strong secrets**: Long, random strings are best
3. **Token expiration**: Include `exp` claim in payload for time-based validation
4. **HTTPS only**: Always transmit JWTs over HTTPS
5. **Signature verification**: Always verify signatures before trusting token data

## Common JWT Claims

Standard JWT claims (optional but recommended):

- `iss` (issuer): Who issued the token
- `sub` (subject): Who the token is about
- `aud` (audience): Who the token is intended for
- `exp` (expiration): When the token expires (Unix timestamp)
- `nbf` (not before): When the token becomes valid
- `iat` (issued at): When the token was created
- `jti` (JWT ID): Unique identifier for the token

## Time Complexity

- **Encoding**: O(n) where n is the payload length
- **Decoding**: O(n) where n is the token length
- **Verification**: O(n) where n is the token length

## Space Complexity

- O(n) for storing the encoded token

## Example Output

```
=== JWT Implementation Demo ===

1. Encoding JWT
Payload: {"userId":123,"username":"john_doe","role":"admin"}
Token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEyMywidXNlcm5hbWUiOiJqb2huX2RvZSIsInJvbGUiOiJhZG1pbiJ9.signature

2. Decoding JWT
Decoded Payload: {"userId":123,"username":"john_doe","role":"admin"}

3. Verifying JWT
Token is valid: true

4. Testing with wrong secret
Token is valid with wrong secret: false
```

## Running the Code

```bash
# Compile
javac JWT.java

# Run
java JWT
```

## Related Concepts

- **Authentication**: Verifying user identity
- **Authorization**: Determining user permissions
- **Cryptography**: HMAC, SHA-256 hashing
- **Base64 Encoding**: Data encoding scheme
- **Session Management**: Stateless authentication

## Advantages of JWT

1. **Stateless**: No need to store sessions on the server
2. **Scalable**: Works well with distributed systems
3. **Compact**: Small size, easy to transmit
4. **Self-contained**: All info is in the token
5. **Cross-domain**: Can be used across different domains

## Disadvantages of JWT

1. **Size**: Larger than session IDs
2. **Security**: If secret is compromised, all tokens are invalid
3. **Revocation**: Hard to revoke before expiration
4. **Storage**: Need to store tokens on client-side

## Real-world Applications

- User authentication in web apps
- API authentication
- Single Sign-On (SSO) systems
- Microservices authentication
- Mobile app authentication
