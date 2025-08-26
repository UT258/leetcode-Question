class Solution {
    public int countPrimes(int n) {
        boolean []sieve=new boolean[n];
        solve(sieve,n);
        int c=0;
        if(n<=2)return 0;
        for(int i=2;i<n;i++)
        {
            if(!sieve[i])
            {
                c++;
            }
        }
        return c;
    }
    private void solve(boolean  arr[],int n)
    {
        for(int i=2;i*i<n;i++)
        {
            if(!arr[i])
            {
                //if this multiple is not prime also  not prime
                for(int j=i*2;j<n;j+=i)
                {
                    arr[j]=true;
                }
            }
        }
    }
}