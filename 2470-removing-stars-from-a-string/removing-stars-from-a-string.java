class Solution {
    public String removeStars(String s) {
      Stack<Character> st=new Stack<>();
     for(int i=0;i<s.length();i++)
     {
        if (!st.empty() && s.charAt(i)=='*')
        {
            st.pop();

        }
        else
        {
            //just push into the stack
            st.push(s.charAt(i));
        }
     }
            StringBuilder result = new StringBuilder();
        for (char c : st) {
            result.append(c);
        }
        
        // Return the final string
        return result.toString();
   
    }
}