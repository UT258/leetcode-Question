class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans=new int[queries.length];
        int k=0;
        if(arr.length<=1)
        {
            Arrays.fill(ans,arr[0]);
            return ans;
        }
        for(int [] nums:queries)
        {   int xor=0;
            for(int i=nums[0];i<=nums[1];i++)
            {
              xor=xor^arr[i];
            }
            //now put it in the ans array
            ans[k]=xor;
            k++;

        }
        return ans;
        
    }
}