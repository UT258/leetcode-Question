class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nge = nextSmaller(arr);
        int[] pse = prevSmaller(arr);
        long sum = 0;
        int Mod = (int)1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nge[i] - i;
            long contribution = (left * right) % Mod * arr[i] % Mod;
            sum = (sum + contribution) % Mod;
        }

        return (int) sum;
    }

    private int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    private int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop(); // '>' for strict previous
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}
