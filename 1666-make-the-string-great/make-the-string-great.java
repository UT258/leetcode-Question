class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
      //to do this first check if the given character is either upper case or lower case
        //how to there will be a difference of 32 between the upper case and lower case
        for (char c:s.toCharArray())
        {
            if (!st.isEmpty() && Math.abs(st.peek()-c)==32)
            {
                st.pop();
            }
            else
            {
                st.push(c);
            }

        }
        String ans="";
        while (!st.isEmpty())
        {
            ans=st.pop()+ans;
        }
        return ans;
    }
}