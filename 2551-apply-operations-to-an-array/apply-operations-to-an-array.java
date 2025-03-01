class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        //use two pointer to let the zeroes in the end
        int i=0;
        int j=nums.length-1;
    //i will point at non zero
    int ans[]=new int [nums.length];
     int k=0;
     for(int n:nums)
     {
        if(n!=0)
        {
            ans[k++]=n;
        }
     }
     return ans;
        
    }
}