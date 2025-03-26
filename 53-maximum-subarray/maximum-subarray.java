class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            //only consider that sum that is positive
            sum+=nums[i];
            max=Math.max(max,sum);
            if(sum<0)
            {
                //if sum is less than zero then no point in considering this window it will
                //only decrease 
                sum=0;
            }

        }
        return max;
        
    }
}