class Solution {
    public int longestOnes(int[] nums, int k) {
        //we need to find the window that contain atmost k zeoes
        int zeroes=0;
        int i=0;
        int j=0;
        int maxlength=Integer.MIN_VALUE;
        while(j<nums.length)
        {
            if(nums[j]==0)
            {
                zeroes++;
            }
            while(zeroes>k)
            {
                if(nums[i]==0)
                {
                    zeroes--;
                }
                i++;

            }
            maxlength=Math.max(maxlength,j-i+1);
            j++;
        }
        return maxlength;
        
    }
}