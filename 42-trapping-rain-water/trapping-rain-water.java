class Solution {
     public int[] getleftmax(int[] height, int n) {
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        return leftMax;
    }

    public int[] getrightmax(int[] height, int n) {
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        return rightMax;
    }
    
    public int trap(int[] height) {
        int lmax[]=getleftmax(height,height.length);
        int rmax[]=getrightmax(height,height.length);
        int water=0;
        for(int i=1;i<height.length;i++)
        {
            water+=Math.min(lmax[i],rmax[i])-height[i];
        }
        return water;
    }
}