class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
        {
            return nums[0];//only one house steal and move forward
            
        }
        if(n==2)
        {
            return Math.max(nums[0],nums[1]);

        }
        //now since its a cycle we can we take the first house we cannot take the last house
        //first 
        int memo[]=new int [n+1];
        
    Arrays.fill(memo,-1);
        int first=solve(nums,0,n-2,memo);//taking first
        Arrays.fill(memo,-1);
        int second =solve(nums,1,n-1,memo);//not taking first
        return Math.max(first,second);

    
        
    }
     private int solve(int arr[],int i,int n,int memo[])
    {
        if (i>n)
        {
            return 0;
        }
        if(memo[i]!=-1)
        {
            return  memo[i];
        }
        int steal=arr[i]+solve(arr,i+2,n,memo);
        int skip=solve(arr,i+1,n,memo);
        memo[i]=Math.max(skip,steal);
        return memo[i];
    }
}