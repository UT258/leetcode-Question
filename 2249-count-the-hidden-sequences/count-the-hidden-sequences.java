class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        //enter the number of the element
        int max = 0;
        int min = 0;
        int curr = 0;
        for (int n : differences) {
            curr = curr + n;//hidden numner
            min = Math.min(min, curr);
            max = Math.max(max, curr);
            if ((upper - max) - (lower - min) +1<= 0) {
                return 0;
            }

        }
        return (upper - max) - (lower - min)+1;

    }
}