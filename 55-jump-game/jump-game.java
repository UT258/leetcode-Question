class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>max)
            {
                return false ; //if you are not able to reach this you cannot reach it

            } 
            max=Math.max(max,i+nums[i]);
        }
        return true;//you can always reach
        
    }
}