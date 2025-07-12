class Solution {
    public int findMiddleIndex(int[] nums) {
         int n=nums.length;
        int prefix[]=new int [n];
        int suffix[]=new int [n];
        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];//last element 
        for(int i=1;i<nums.length;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
            suffix[nums.length-1-i]=suffix[nums.length-i]+nums[nums.length-i-1];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(suffix[i]==prefix[i])
            {
                return i;
            }
        }
        return -1;
    }
}