class Solution {
    public int minimizeXor(int num1, int num2) {
        // Count the number of set bits in num1 and num2
        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);

        // If both numbers already have the same number of set bits, return num1
        if (c1 == c2) {
            return num1;
        }

        // Convert num1 to an array of bits for easier manipulation
        boolean[] bits = new boolean[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = (num1 & (1 << i)) != 0;
        }

        if (c1 < c2) {
            // Increase the number of set bits in num1
            int diff = c2 - c1;
            for (int i = 0; i < 32 && diff > 0; i++) {
                if (!bits[i]) {
                    num1 |= (1 << i); // Set the bit
                    diff--;
                }
            }
        } else {
            // Decrease the number of set bits in num1
            int diff = c1 - c2;
            for (int i = 0; i < 32 && diff > 0; i++) {
                if (bits[i]) {
                    num1 &= ~(1 << i); // Unset the bit
                    diff--;
                }
            }
        }

        return num1;
    }
}
