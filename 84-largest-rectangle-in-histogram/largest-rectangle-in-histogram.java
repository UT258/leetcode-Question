class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // We append a 0 height at the end to make sure all bars are processed
            int currHeight = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && currHeight < heights[st.peek()]) {
                int element = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                int width = nse - pse - 1;
                maxArea = Math.max(maxArea, element * width);
            }

            st.push(i);
        }

        return maxArea;
        
    }
}