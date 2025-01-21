class Solution {
    public long gridGame(int[][] grid) {
        //find the total sum of the row 1
        long rsum=0;
        long srsum=0;
        for(int i=0;i<grid[0].length;i++)
        {
         rsum+=grid[0][i];
        }
        long min=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++)
        {
            rsum-=grid[0][i];
            //robot two will take the max
            long robo2max=Math.max(rsum,srsum);

              srsum+=grid[1][i];
              min=Math.min(min,robo2max);
        }
        return min;
        
        
    }
}