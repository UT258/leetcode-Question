class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>max) return false;
            //we will find the maximum we can reach index we can reach every point 
            max=Math.max(max,i+nums[i]);

        }
        return true;
        
    }
}