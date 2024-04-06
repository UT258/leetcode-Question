class Solution {
    public String minRemoveToMakeValid(String s) {
         Stack<Integer>st=new Stack<>();
        for(int i=0;i<s.length();i++)

        {
            if (Character.isLowerCase(s.charAt(i)))
                continue;
         if(s.charAt(i)=='(')
         {
             st.push(i);
         }
         else if(s.charAt(i)==')')
         {
             if (!st.isEmpty() && s.charAt(st.peek())=='(')
             {
                 st.pop();
             }
             else
             {
                 st.push(i);
             }
         }

        }
         StringBuilder ans=new StringBuilder(s);
        if (st.isEmpty())
        {
            return s;
        }
        else{

            while(!st.isEmpty())
            {
                ans.deleteCharAt(st.pop());
            }
        }
        return ans.toString();
        
    }
}