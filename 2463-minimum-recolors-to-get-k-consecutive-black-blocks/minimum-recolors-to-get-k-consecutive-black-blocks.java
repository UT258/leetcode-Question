class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans=Integer.MAX_VALUE;
        //take all the substring and  the
        
        for(int i=0;i<=blocks.length()-k;i++)
              //n-k cuz does not go out of bound 
        {   int white=0; //no of white for each k len substring
            for(int j=i;j-i+1<=k;j++)
            {
               if(blocks.charAt(j)=='W')
               {
                white++;
               }
            }
            ans=Math.min(ans,white);
        }
        return ans;
    }
}