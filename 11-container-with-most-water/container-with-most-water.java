class Solution {
    public int maxArea(int[] height) {
        //use two pointer
        int i = 0;
        int j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
           int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(area, max);
            if (height[i] > height[j]) {
                //since i have to find the greater element
                //i am decreasing width so i have to increase height
                j--;//remove the smaller height
            } else {
                i++;
            }
        }
        return max;

    }
}