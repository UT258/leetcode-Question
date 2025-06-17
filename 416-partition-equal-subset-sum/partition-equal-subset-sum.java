class Solution {
     static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j)
                {   //here is j is represeting the sum
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
        
    }
    public boolean canPartition(int[] nums) {
    //if the sum of all the element is even then only we can divide the array 
    int sum=0;
    for(int n:nums)sum+=n;
    if(sum%2!=0)
    {
        return false;
    }
    else{
        //check if there is subset can be made that has sum 
        return isSubsetSum(nums,sum/2);
    }
        
    }
}