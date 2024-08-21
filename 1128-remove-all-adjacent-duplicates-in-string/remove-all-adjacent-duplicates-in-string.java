class Solution {
    public String removeDuplicates(String s) {
     Stack<Character> st=new Stack<>();
     for(int i=0;i<s.length();i++)
     {
        if (!st.empty() && s.charAt(i)==st.peek())
        {
            st.pop();
        }
        else
        {
            //just push into the stack
            st.push(s.charAt(i));
        }
     }
     return st.toString().replace("[","").replace("]","").replace(",","").replace(" ","");
}
}