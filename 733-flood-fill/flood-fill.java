class Solution {
    public static void dfs(int [][]image,int[][]ans,int initcolor,int color,int sr,int sc ,int []delrow ,int []delcol)
    {
        //vist the node
        ans[sr][sc]=color;//color the starting node
        //now go to neighbour
        for(int i=0;i<4;i++)
        {
            int nrow =sr+delrow[i];
            int ncol=sc+delcol[i];
            if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length && ans[nrow][ncol]!=color  && image[nrow][ncol]==initcolor )
            {
                //color it
                ans[nrow][ncol]=color;
                dfs(image,ans ,initcolor,color,nrow,ncol,delrow ,delcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //using dfs
        int ans[][]=image;
        int inticolor=image[sr][sc];
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        dfs(image,ans,inticolor,color,sr,sc,delrow,delcol);
          return ans;
        
    }
}