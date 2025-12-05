class Solution {
    public int countPartitions(int[] nums) {
        int lsum=0;
        int rsum=0;
        int sum=0;
        //if we sum the whole array 
        //[10 ,10 ,3,7,6] total 36 
        //if took 10 and remove from total i will left with remaing part
        //[10 ,(36-10)] [10,26]
        int count=0;
        for(int n:nums)
        {
         sum+=n;
        }
        //loop is going till n-1 beacause we cannot take whole array 
        //maximum element we can take in lsum is n-1 
        //[ [1 3 4 ] ,10 ] maximum partition is 3 element in case of  array of size 4
        for(int i=0;i<nums.length-1;i++)
        {
            lsum+=nums[i];
            rsum=sum-lsum;
            int diff=Math.abs(lsum-rsum);
            if((diff & 1 )==0)
            {
                count++;
            }
        }
        return count;
    }
}