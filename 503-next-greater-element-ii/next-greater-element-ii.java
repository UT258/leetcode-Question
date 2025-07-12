class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //imagine it as a 2n array 
        //[1 2 3 1 2 3]
        Stack<Integer>st=new Stack<>();
        int n=nums.length;
        int ans []=new int [n];
        for(int i=2*n;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums[i%n]) st.pop();//keep removing the smaller element until you left with only greater elements
            if(i<n)
            {
                //if i is < n it mean it is on the original part of the array 
                ans[i]=st.isEmpty()?-1:st.peek();
                
            }
            st.push(nums[i%n]);
        }
        return ans;
       
        
    }
}