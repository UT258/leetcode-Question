class Solution {
    public int maximumLength(int[] nums) {
        if(nums.length<=2)return nums.length;
        int evenDp = 0;
        int oddDp = 0;
        int ceven=0;
        int codd=0;
        for(int n:nums)
        {
           if(n%2==0)
           {
            ceven++;
           }
           else{
            codd++;
           }
        }
        for (int num : nums) {
            if (num % 2 == 0) {
                evenDp = Math.max(evenDp, oddDp + 1);
            } else {
                oddDp = Math.max(oddDp, evenDp + 1);
            }
        }
        return  Math.max( ceven,Math.max(codd,Math.max(evenDp, oddDp)));
    }
}
