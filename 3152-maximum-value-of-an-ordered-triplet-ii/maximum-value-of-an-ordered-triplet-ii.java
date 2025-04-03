class Solution {
    public long maximumTripletValue(int[] nums) {
        long res=0;
        long maxdiff=0;
        long max=0;
        for(int i=0;i<nums.length;i++)
        {
            res=Math.max(res,maxdiff*nums[i]);
            maxdiff=Math.max(maxdiff,max-nums[i]); //maxium  i got so far - the current 
            max=Math.max(max,nums[i]);
        
        }
        return res;
        
    }
}