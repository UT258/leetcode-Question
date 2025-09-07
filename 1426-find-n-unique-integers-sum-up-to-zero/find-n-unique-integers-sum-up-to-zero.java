class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        int start = n;
        //create half positives and half negative
        //start from last and till half put all the positive
        //if n is odd then half pos and half negative  and middle 0 
        //5 4 0 -5 -4  odd length 
        // 5 4 -4 -5 for even length mid element will not be zero 
         //that the only way you can form the positive negative easily
        int end = n / 2 + 1;
        for (int i = 0; i < n / 2; i++) {
            arr[i] = start;
            start--;
        }
        start = n; //reset for the negatives
        if (n % 2 == 0) {
            end = n / 2;
            //if is is even start putting from middle 
            //else skip the mid
        }
        for (int i = end; i < n; i++) {
            arr[i] = -1 * start;
            start--;
        }
        return arr;

    }
}