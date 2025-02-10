class Solution {
    public String clearDigits(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(!st.isEmpty() && Character.isDigit(s.charAt(i) ))
            {
                  st.pop();

            } 
            else{
                st.push(s.charAt(i));
            }
            
        }
    String ans="";
        while(!st.isEmpty())
        {
            ans=st.pop()+ans;
        }
        return ans;
    }
}