class Solution {
    public int missingNumber(int[] nums) {
        //first method is to use the cycle sort
        //calculate sum 
        int n=nums.length;
        int sum=n*(n+1)/2;
        for(int  num: nums)
        {
            sum-=num;
        }
        return sum;
        

        
    }
}