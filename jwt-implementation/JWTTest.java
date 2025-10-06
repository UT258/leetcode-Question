/**
 * Test cases for JWT implementation
 * Demonstrates various scenarios and edge cases
 */
public class JWTTest {
    
    private static int testsPassed = 0;
    private static int testsFailed = 0;
    
    public static void main(String[] args) {
        System.out.println("=== JWT Test Suite ===\n");
        
        testBasicEncodeAndDecode();
        testSignatureVerification();
        testInvalidTokenFormat();
        testEmptyPayload();
        testSpecialCharacters();
        testLargePayload();
        testMultipleTokens();
        testHeaderExtraction();
        
        System.out.println("\n=== Test Results ===");
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + testsFailed);
        System.out.println("Total Tests: " + (testsPassed + testsFailed));
    }
    
    private static void testBasicEncodeAndDecode() {
        System.out.println("Test 1: Basic encode and decode");
        try {
            String secret = "test-secret";
            String payload = "{\"user\":\"alice\",\"id\":100}";
            
            String token = JWT.encode(payload, secret);
            String decoded = JWT.decode(token, secret);
            
            if (payload.equals(decoded)) {
                pass("Basic encode/decode works correctly");
            } else {
                fail("Decoded payload doesn't match original");
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testSignatureVerification() {
        System.out.println("Test 2: Signature verification");
        try {
            String secret = "secure-key";
            String wrongSecret = "wrong-key";
            String payload = "{\"action\":\"login\"}";
            
            String token = JWT.encode(payload, secret);
            
            // Test with correct secret
            if (JWT.verify(token, secret)) {
                pass("Verification with correct secret succeeded");
            } else {
                fail("Verification with correct secret failed");
            }
            
            // Test with wrong secret
            if (!JWT.verify(token, wrongSecret)) {
                pass("Verification with wrong secret correctly failed");
            } else {
                fail("Verification with wrong secret incorrectly succeeded");
            }
            
            // Test decode with wrong secret
            try {
                JWT.decode(token, wrongSecret);
                fail("Decode with wrong secret should have thrown exception");
            } catch (Exception e) {
                pass("Decode with wrong secret correctly threw exception");
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testInvalidTokenFormat() {
        System.out.println("Test 3: Invalid token format");
        try {
            String[] invalidTokens = {
                "invalid",
                "only.two",
                "one.two.three.four",
                "",
                "...",
                "a.b."
            };
            
            for (String invalidToken : invalidTokens) {
                try {
                    JWT.decode(invalidToken, "secret");
                    fail("Should have thrown exception for: " + invalidToken);
                } catch (Exception e) {
                    // Expected
                }
            }
            pass("All invalid token formats correctly rejected");
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testEmptyPayload() {
        System.out.println("Test 4: Empty payload");
        try {
            String secret = "secret";
            String emptyPayload = "{}";
            
            String token = JWT.encode(emptyPayload, secret);
            String decoded = JWT.decode(token, secret);
            
            if (emptyPayload.equals(decoded)) {
                pass("Empty payload handled correctly");
            } else {
                fail("Empty payload not handled correctly");
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testSpecialCharacters() {
        System.out.println("Test 5: Special characters in payload");
        try {
            String secret = "secret";
            String payload = "{\"message\":\"Hello, World! @#$%^&*()\",\"emoji\":\"😀\"}";
            
            String token = JWT.encode(payload, secret);
            String decoded = JWT.decode(token, secret);
            
            if (payload.equals(decoded)) {
                pass("Special characters handled correctly");
            } else {
                fail("Special characters not handled correctly");
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testLargePayload() {
        System.out.println("Test 6: Large payload");
        try {
            String secret = "secret";
            StringBuilder largePayload = new StringBuilder("{\"data\":\"");
            for (int i = 0; i < 1000; i++) {
                largePayload.append("A");
            }
            largePayload.append("\"}");
            
            String token = JWT.encode(largePayload.toString(), secret);
            String decoded = JWT.decode(token, secret);
            
            if (largePayload.toString().equals(decoded)) {
                pass("Large payload handled correctly");
            } else {
                fail("Large payload not handled correctly");
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testMultipleTokens() {
        System.out.println("Test 7: Multiple tokens with same secret");
        try {
            String secret = "shared-secret";
            String[] payloads = {
                "{\"id\":1}",
                "{\"id\":2}",
                "{\"id\":3}"
            };
            
            String[] tokens = new String[payloads.length];
            for (int i = 0; i < payloads.length; i++) {
                tokens[i] = JWT.encode(payloads[i], secret);
            }
            
            // Verify all tokens are different
            boolean allDifferent = true;
            for (int i = 0; i < tokens.length; i++) {
                for (int j = i + 1; j < tokens.length; j++) {
                    if (tokens[i].equals(tokens[j])) {
                        allDifferent = false;
                        break;
                    }
                }
            }
            
            if (allDifferent) {
                pass("Multiple tokens are unique");
            } else {
                fail("Multiple tokens are not unique");
            }
            
            // Verify all tokens can be decoded
            boolean allValid = true;
            for (int i = 0; i < payloads.length; i++) {
                String decoded = JWT.decode(tokens[i], secret);
                if (!payloads[i].equals(decoded)) {
                    allValid = false;
                    break;
                }
            }
            
            if (allValid) {
                pass("All tokens decode correctly");
            } else {
                fail("Not all tokens decode correctly");
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void testHeaderExtraction() {
        System.out.println("Test 8: Header and payload extraction");
        try {
            String secret = "secret";
            String payload = "{\"test\":\"data\"}";
            
            String token = JWT.encode(payload, secret);
            String header = JWT.getHeader(token);
            String extractedPayload = JWT.getPayload(token);
            
            boolean headerCorrect = header.contains("HS256") && header.contains("JWT");
            boolean payloadCorrect = payload.equals(extractedPayload);
            
            if (headerCorrect && payloadCorrect) {
                pass("Header and payload extraction works correctly");
            } else {
                fail("Header or payload extraction failed");
            }
        } catch (Exception e) {
            fail("Exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void pass(String message) {
        System.out.println("  ✓ PASS: " + message);
        testsPassed++;
    }
    
    private static void fail(String message) {
        System.out.println("  ✗ FAIL: " + message);
        testsFailed++;
    }
}
