class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=1;i<n;i++)

        {
          int row=0;
          int col=i;
          ArrayList<Integer>list=new ArrayList<>();
          while(row<n &&  col<m)
          {
              list.add(grid[row][col]);
              row++;
              col++;
          }
          Collections.sort(list);
          row=0;
          col=i;
          int idx=0;
          while(row<n &&  col<m)
          {
              grid[row][col]=list.get(idx);
              row++;
              col++;
              idx++;
          }

        }
        //for decreasing oreder
        for(int i=0;i<m;i++)

        {
          int row=i;
          int col=0;
          ArrayList<Integer>list=new ArrayList<>();
          while(row<n &&  col<m)
          {
              list.add(grid[row][col]);
              row++;
              col++;
          }
          Collections.sort(list,Collections.reverseOrder());
          row=i;
          col=0;
          while(row<n &&  col<m)
          {
              grid[row][col]=list.get(col);
              row++;
              col++;
          }

        }
        return grid;

    }
}   