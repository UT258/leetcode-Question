class Solution {
    public boolean checkString(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(!st.isEmpty() && st.peek()=='b' && s.charAt(i)=='a')
            {   //check if b comes before a then its false;
                return false;
            }
            else{
                //just normaly put it in the stack
                st.push(s.charAt(i));
            }
        }
        return true;
        
    }
}