class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int sum=0;
       int maxsum=Integer.MIN_VALUE;
       int i=0;
       int j=0;
       while(j<nums.length)
       {
        sum+=nums[j];
        //if we reached window size calucalte the sum
         if(j-i+1==k){
            maxsum=Math.max(maxsum,sum);
            sum-=nums[i];
            i++;
         }
         j++;
       }
       return (double)maxsum/k;
    }
}