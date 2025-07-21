class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int total = n*(n+1)/2;
        int i = 0;
        int j = 0;
        int prod = 1;
        int count = 0;
        while(j<n){
            prod *= nums[j];
            while (i<=j &&prod >= k){
                count += n-j;
                prod = prod/nums[i];
                i++;
            }
            j++;
        }
        return total - count;
    }
}