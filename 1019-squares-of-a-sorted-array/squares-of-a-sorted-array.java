class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans []=new int [nums.length];
        int i=0;
        int j=nums.length-1;
        int k=j;
        while(i<=j)
        {
            int a=nums[i]*nums[i];
            int b=nums[j]*nums[j];
            if(a>b)
            {
                ans[k]=a;
                
               i++;
            }
            else{
                ans[k]=b;
                j--;
            }
            k--;
        }
        return ans;
    }
}