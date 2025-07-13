class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                st.push(arr[i]);
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(arr[i])) {
                    st.pop();//equal case both destoyed
                    continue;
                 }
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(arr[i]);//only push -ve when there is no one to destroy 
                    //or you have a negative one
                }

            }

        }
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}