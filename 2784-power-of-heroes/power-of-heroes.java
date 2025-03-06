import java.util.Arrays;

class Solution {
    public int sumOfPower(int[] nums) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        
        long res = 0, prefixSum = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            long minStrength = nums[i];  // The current element acts as min in some subsets
            long maxContribution = (long) nums[i] * nums[i] % mod; 
            
            // Compute the total power using previously seen elements
            long currentPower = maxContribution * (minStrength + prefixSum) % mod;
            
            // Add to result
            res = (res + currentPower) % mod;
            
            // Update prefix sum
            prefixSum = (prefixSum * 2 + nums[i]) % mod;
        }
        
        return (int) res;
    }
}
