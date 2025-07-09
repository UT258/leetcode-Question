class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[]=new Boolean [nums.length+1];
      
        return solve(nums,0,dp);
    }
    private boolean solve(int arr[],int i,Boolean dp[])
    {
        if(i==arr.length-1)
        {
            return true; //able to reach the last index

        }
          if (i >= arr.length) {
            return false;
        }
        if(dp[i]!=null)return dp[i];
        // 3) Try every possible jump length from 1 up to arr[i]
        for (int step = 1; step <= arr[i]; step++) {
            if (solve(arr, i + step,dp)) {
                return dp[i]= true;
            }
        }

        //i represent if i start from ind can i reach the last 
        return dp[i]=false;

    }
    
}