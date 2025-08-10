class Solution {
    public int findJudge(int n, int[][] trust) {
        int indg[]=new int [n+1];
        int outdg[]=new int [n+1];
        for(int []temp: trust)
        {
            int a=temp[0];
            int b=temp[1];
            indg[b]++;
            outdg[a]++;

        }
        for(int i=1;i<=n;i++){
            if(indg[i]==n-1 && outdg[i]==0)
            {
                return i;
            }
        }
        return -1;
        
    }
}