class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
    List<String>board=new ArrayList<>();
    //fill the string with empty string 
    for(int i=0;i<n;i++)
    {
        StringBuilder row=new StringBuilder();
        for(int j=0;j<n ;j++)
        {
            row.append(".");
        }
        board.add(row.toString());//convert it into row
    }
    solve(board,0,n);
    return ans;
    
        
    }
    public boolean isValid(List<String>board,int row ,int col)
    {
        //check for the upper section
        for(int i=row;i>=0;i--)
        {
            //col remain the same row will decrease we will move foward
            if(board.get(i).charAt(col)=='Q')
            {
                return false;
            }
        }
        //for left diagonal
        for(int i=row , j=col ;j>=0 && i>=0 ; j--,i--)
        {
            if(board.get(i).charAt(j)=='Q')
            {
                return false;
            }
        }
        //for right
       for(int i=row , j=col ;j<board.size() && i>=0 ; j++,i--)
        {
            if(board.get(i).charAt(j)=='Q')
            {
                return false;
            }
        }
        return true;//none of this happen we can place the queen

        
    }
    public void solve(List<String>board,int row,int n)
    {
        //i will start from row 0
        // i try putting queen in every col of the row
        if(row==n)
        {
            // i put all the queen
            ans.add(new ArrayList<>(board));//add the current ans
            return ;
        }
        for(int col=0;col<n;col++)
        {
            //put the queen
            if(isValid(board,row,col))
           { 
            StringBuilder nrow=new StringBuilder(board.get(row));
            nrow.setCharAt(col,'Q');//put the queen
            board.set(row,nrow.toString());
            //backtrack what you did
            solve(board,row+1,n);
            nrow.setCharAt(col,'.');//put the queen
            board.set(row,nrow.toString());
        }

        }
        
    }
}