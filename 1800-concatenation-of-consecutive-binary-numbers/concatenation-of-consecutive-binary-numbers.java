class Solution {
    final long MOD = (long) (1e9 + 7);

    public int concatenatedBinary(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            for (char c : binary.toCharArray()) {
                result = (result * 2 + (c - '0')) % MOD; // calculate modulo incrementally
            }
        }
        return (int) result;
    }
}
