class Solution {
    public int climbStairs(int n) {
        
        //using memoization
        int arr[]=new int [n+1];
        Arrays.fill(arr,-1);//to turn all the element to -1
       return solve(arr,n);
    }
    private int solve(int arr[ ],int n)

    {
        if (n<0)
        {
            return 0;
        }
        if(n==0)
        {
            return 1;//found a way
        }
        if(arr[n]!=-1)
        {
            return arr[n]; //if it is not -1 then it means it already calulated so just return it
        }
        arr[n]=solve(arr,n-1)+solve(arr,n-2);
        return arr[n];
    }
}