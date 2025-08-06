class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>st=new Stack<>();
        int sum=0;
        for(String op:operations)
        {
         if(!st.isEmpty() && op.equals("C"))
         {
            st.pop();
         }
         else if (op.equals("D"))
         {
            if(!st.isEmpty())
            {
                st.push(2*st.peek());
            }
         }
         else if(op.equals("+")){
            if(st.size()>=2){
            int prev=st.pop();
            int sec=st.peek();
            st.push(prev);
            st.push(prev+sec);
            }
         }
         else st.push(Integer.parseInt(op));//convert to int
        }
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
        
    }
}