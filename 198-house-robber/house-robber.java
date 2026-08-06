class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
       int dp[] =new int [n+1];
       dp[0]=0;
       dp[1]=nums[0];
       for(int i=2;i<=n;i++)
       {
       dp[i]=Math.max(nums[i-1]+dp[i-2],dp[i-1]);
       }
       return dp[n];
    }
    public int solve(int arr[],int i)
    {
        if(i>=arr.length)
        {
            return 0;//no max profit 
        }
        return Math.max(
            arr[i]+solve(arr,i+2) , solve(arr,i+1)
        );
    }
}