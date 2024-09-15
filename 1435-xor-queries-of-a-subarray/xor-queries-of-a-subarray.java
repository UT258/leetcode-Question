class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        //using prefix array
        
        int []pre=new int [arr.length];
        pre[0]=arr[0];
        int ans[]=new int [queries.length];
        //  if(arr.length<=1)
        // {
        //     Arrays.fill(ans,arr[0]);
        //     return ans;
        // }
        for(int i=1;i<arr.length;i++)
        {
            pre[i]=pre[i-1] ^ arr[i];
        }
        int k=0;
        for(int temp[]:queries)
        {
            if(temp[0]==0)
            {
                ans[k]=pre[temp[1]];
                
            }
            else{
                ans[k]=pre[temp[1]]^pre[temp[0]-1];
            }
            k++;
        }
        return ans;
        
    }
}