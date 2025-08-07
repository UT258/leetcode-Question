class Solution {
    public String convert(String s, int numRows) {
     List<StringBuilder>list=new ArrayList<>();
     if(numRows==1 || s.length()==1)
     {
        return s;
     }
     int row=0;
     boolean down=false;
     for(int i=0;i<numRows;i++)
     {
        list.add(new StringBuilder());
     }
     for(char ch:s.toCharArray())
     {
        list.get(row).append(ch);
        if(row== 0 || row == numRows-1)
        {
            down=!down;//change the direction
        }
        row+=down?1:-1;

     }
     StringBuilder ans=new StringBuilder();  
     for(int i=0;i<numRows;i++)
     {
      ans.append(list.get(i));
     } 
     return ans.toString();
    }
}