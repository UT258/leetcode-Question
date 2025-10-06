import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * A simple JWT (JSON Web Token) implementation supporting encoding and decoding
 * with HMAC-SHA256 signature verification.
 * 
 * JWT consists of three parts separated by dots:
 * 1. Header (algorithm and token type)
 * 2. Payload (claims/data)
 * 3. Signature (verification)
 */
public class JWT {
    
    private static final String HMAC_SHA256 = "HmacSHA256";
    
    /**
     * Encodes a JWT token with the given payload and secret key.
     * 
     * @param payload The payload/claims to encode (JSON string)
     * @param secret The secret key for signing
     * @return The encoded JWT token
     */
    public static String encode(String payload, String secret) {
        try {
            // Create header
            String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
            
            // Base64URL encode header and payload
            String encodedHeader = base64UrlEncode(header);
            String encodedPayload = base64UrlEncode(payload);
            
            // Create signature
            String data = encodedHeader + "." + encodedPayload;
            String signature = createSignature(data, secret);
            
            // Combine all parts
            return data + "." + signature;
        } catch (Exception e) {
            throw new RuntimeException("Error encoding JWT: " + e.getMessage(), e);
        }
    }
    
    /**
     * Decodes and verifies a JWT token.
     * 
     * @param token The JWT token to decode
     * @param secret The secret key for verification
     * @return The decoded payload if signature is valid
     * @throws RuntimeException if token is invalid or signature doesn't match
     */
    public static String decode(String token, String secret) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid JWT token format");
            }
            
            String encodedHeader = parts[0];
            String encodedPayload = parts[1];
            String signature = parts[2];
            
            // Verify signature
            String data = encodedHeader + "." + encodedPayload;
            String expectedSignature = createSignature(data, secret);
            
            if (!signature.equals(expectedSignature)) {
                throw new SecurityException("Invalid JWT signature");
            }
            
            // Decode payload
            return base64UrlDecode(encodedPayload);
        } catch (Exception e) {
            throw new RuntimeException("Error decoding JWT: " + e.getMessage(), e);
        }
    }
    
    /**
     * Verifies if a JWT token is valid.
     * 
     * @param token The JWT token to verify
     * @param secret The secret key for verification
     * @return true if token is valid, false otherwise
     */
    public static boolean verify(String token, String secret) {
        try {
            decode(token, secret);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Extracts the payload from a JWT token without verification.
     * Use with caution - this does NOT verify the signature.
     * 
     * @param token The JWT token
     * @return The payload as a string
     */
    public static String getPayload(String token) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid JWT token format");
        }
        return base64UrlDecode(parts[1]);
    }
    
    /**
     * Extracts the header from a JWT token.
     * 
     * @param token The JWT token
     * @return The header as a string
     */
    public static String getHeader(String token) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid JWT token format");
        }
        return base64UrlDecode(parts[0]);
    }
    
    /**
     * Creates HMAC-SHA256 signature.
     */
    private static String createSignature(String data, String secret) throws Exception {
        Mac mac = Mac.getInstance(HMAC_SHA256);
        SecretKeySpec secretKeySpec = new SecretKeySpec(
            secret.getBytes(StandardCharsets.UTF_8), 
            HMAC_SHA256
        );
        mac.init(secretKeySpec);
        byte[] signatureBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return base64UrlEncode(signatureBytes);
    }
    
    /**
     * Base64URL encodes a string.
     */
    private static String base64UrlEncode(String input) {
        return base64UrlEncode(input.getBytes(StandardCharsets.UTF_8));
    }
    
    /**
     * Base64URL encodes a byte array.
     */
    private static String base64UrlEncode(byte[] input) {
        return Base64.getUrlEncoder()
            .withoutPadding()
            .encodeToString(input);
    }
    
    /**
     * Base64URL decodes a string.
     */
    private static String base64UrlDecode(String input) {
        byte[] decodedBytes = Base64.getUrlDecoder().decode(input);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
    
    /**
     * Main method with examples demonstrating JWT usage.
     */
    public static void main(String[] args) {
        System.out.println("=== JWT Implementation Demo ===\n");
        
        // Example 1: Basic encoding and decoding
        String secret = "my-secret-key";
        String payload = "{\"userId\":123,\"username\":\"john_doe\",\"role\":\"admin\"}";
        
        System.out.println("1. Encoding JWT");
        System.out.println("Payload: " + payload);
        String token = encode(payload, secret);
        System.out.println("Token: " + token);
        System.out.println();
        
        // Example 2: Decoding and verification
        System.out.println("2. Decoding JWT");
        String decodedPayload = decode(token, secret);
        System.out.println("Decoded Payload: " + decodedPayload);
        System.out.println();
        
        // Example 3: Verification
        System.out.println("3. Verifying JWT");
        boolean isValid = verify(token, secret);
        System.out.println("Token is valid: " + isValid);
        System.out.println();
        
        // Example 4: Invalid signature
        System.out.println("4. Testing with wrong secret");
        boolean isValidWithWrongSecret = verify(token, "wrong-secret");
        System.out.println("Token is valid with wrong secret: " + isValidWithWrongSecret);
        System.out.println();
        
        // Example 5: Getting header and payload without verification
        System.out.println("5. Extracting parts without verification");
        System.out.println("Header: " + getHeader(token));
        System.out.println("Payload: " + getPayload(token));
        System.out.println();
        
        // Example 6: Multiple payloads
        System.out.println("6. Different payload examples");
        String[] testPayloads = {
            "{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"iat\":1516239022}",
            "{\"email\":\"user@example.com\",\"exp\":1735689600}",
            "{\"data\":\"test\",\"timestamp\":1234567890}"
        };
        
        for (String testPayload : testPayloads) {
            String testToken = encode(testPayload, secret);
            System.out.println("Payload: " + testPayload);
            System.out.println("Token: " + testToken);
            System.out.println("Verified: " + verify(testToken, secret));
            System.out.println();
        }
    }
}
