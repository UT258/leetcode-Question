class Solution {
    public int rob(int[] nums) {
        int memo[]=new int [nums.length];
        Arrays.fill(memo,-1);
        return solve(nums,0,memo);

        
    }
    private int solve(int arr[],int i,int memo[])
    {
        if (i>=arr.length)
        {
            return 0;
        }
        if(memo[i]!=-1)
        {
            return memo[i];
        }
        int steal=arr[i]+solve(arr,i+2,memo);
        int skip=solve(arr,i+1,memo);
        memo[i]=Math.max(skip,steal);
        return memo[i];
    }

}