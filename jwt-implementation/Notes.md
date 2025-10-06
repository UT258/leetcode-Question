<h2>JWT Implementation Notes</h2><hr>

## Key Concepts

### JWT Structure
- **Header**: Contains algorithm and token type
- **Payload**: Contains the claims/data
- **Signature**: Ensures data integrity and authenticity

### Algorithm: HMAC-SHA256
- Symmetric key algorithm
- Same secret used for signing and verification
- Provides cryptographic security

### Base64URL Encoding
- URL-safe variant of Base64
- No padding characters
- Replaces `+` with `-` and `/` with `_`

## Implementation Approach

1. **Encoding**:
   - Create JSON header with algorithm info
   - Base64URL encode header and payload
   - Generate HMAC-SHA256 signature
   - Concatenate all parts with dots

2. **Decoding**:
   - Split token by dots
   - Verify signature matches
   - Decode and return payload

3. **Verification**:
   - Recreate signature from token data
   - Compare with provided signature
   - Return boolean result

## Security Notes

- **Secret Key**: Must be kept confidential
- **Token Storage**: Store securely on client (HttpOnly cookies or secure storage)
- **Expiration**: Add `exp` claim for time-based validation
- **Signature**: Always verify before trusting token data

## Common Use Cases

1. **Authentication**: User login tokens
2. **API Authorization**: Access tokens for APIs
3. **Information Exchange**: Secure data transfer
4. **Single Sign-On**: Cross-domain authentication

## Testing Results

All test cases passed:
- Basic encoding/decoding
- Signature verification
- Invalid token handling
- Special characters support
- Large payload handling
- Multiple token generation
- Header/payload extraction
