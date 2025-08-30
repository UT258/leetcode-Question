class Solution {
    private boolean valid(int sr,int er, int sc, int ec,char[][] board)
    {
     Set<Character>set=new HashSet<>();
     for(int i=sr;i<=er;i++)
     {
        for(int j=sc;j<=ec;j++)
        {  char ch=board[i][j];
            if(ch=='.') 
            {
                continue;
            }
            if(set.contains(ch))
            {
                return false;
            }
            else{
                set.add(ch);
            }
        }
     }
     return true;
    }
    public boolean isValidSudoku(char[][] board) {
        //check the row 
         int m=board.length;
         int n=board[0].length;
         for(int i=0;i<9;i++)

         {  //now  each col should not contain a duplicate digit
             Set<Character>set=new HashSet<>();
            for(int j=0;j<9;j++)
            {
               char ch=board[j][i];//moving in the col
               if(ch=='.')
               {
                continue;
               }
               if(set.contains(ch))
               {
                return false;
               }
               else{
                set.add(ch);
               }
            }
         }
         //now check if there any duplicate int the row 
         for(int i=0;i<9;i++){
            Set<Character>set=new HashSet<>();
            for(int j=0;j<9;j++)
            {
                char ch=board[i][j];
                if(ch=='.')
                {
                    continue;//if its empty do nothing
                }
                if(set.contains(ch)){
                    return false;
                }
                else{
                    set.add(ch);
                }
            }
         }
         //now check the individul box
         for(int sr=0;sr<9;sr+=3)
         {
            int er=sr+2;
            for(int sc=0;sc<9;sc+=3)
            {
                int ec=sc+2;
                if(!valid(sr,er,sc,ec,board)){
                    return false;
                }
            }
         }
         return true;
    }
}