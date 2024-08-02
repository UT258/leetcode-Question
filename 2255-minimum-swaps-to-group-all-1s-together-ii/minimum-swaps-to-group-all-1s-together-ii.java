class Solution {
    public int minSwaps(int[] nums) {
        //normal sliding window
        int i=0;
        int j=0;
        int count=0;
        int total=0;
        int max=Integer.MIN_VALUE;
        for(int n:nums)
        {
            total+=n;
        }


        while(j<2*nums.length)
        {
          if(nums[j%nums.length]==1)
          {
           count++;
          }    
          if(j-i+1>total)
          {
            //means it going outsize the window size
            //shrink the window size
            count-=nums[i%nums.length];
            i++;//move the window forward
          }
          max=Math.max(max,count);
          j++;
        }
        return total-max;//total number of ones - the maximum number of ones the window has
    }
}