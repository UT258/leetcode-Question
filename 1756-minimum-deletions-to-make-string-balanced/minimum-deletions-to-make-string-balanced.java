class Solution {
    public int minimumDeletions(String s) {
       Stack<Character>st=new Stack<>();
        int count=0;
        for (int i = 0; i <s.length(); i++) {
           
            if(!st.isEmpty() && st.peek()=='b' && s.charAt(i)=='a')
            {
                //if top is you can place a after it
                st.pop();
                count++;
            }//enter the number of the element in the list 
            else
            {
                //if top is a you can place b after it you can just push it
                st.push(s.charAt(i));
            }
            
        }
        return count;
    }
}