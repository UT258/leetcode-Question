class Solution {
    public long coloredCells(int n) {
        long sum=1;
        for(long i=2;i<=n;i++)
        {
            sum+=(i-1)*4;
        }
        return sum;
        
    }
}