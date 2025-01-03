class Solution {
    public int fib(int n) {
        //bottom up 
        if(n<=1)
        {
            return n;//for this there is no need for the previous answer
        }
        int arr[]=new int [n+1];
        arr[0]=0;
        arr[1]=1;
        //start building sol from the base case
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
        
    }
}