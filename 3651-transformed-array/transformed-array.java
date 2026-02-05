class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int res[] = new int[nums.length];
        int k = 0;
        int n = nums.length;

        for (int i=0;i<nums.length;i++) {

            if (nums[i]>0) {
                int pos = (i + nums[i]) % n;
                res[k] = nums[pos];
            }
            else if (nums[i]<0) {
                int pos = (i + nums[i]) % n;
                if (pos < 0) pos += n;   
                res[k] = nums[pos];
            }
            else {
                res[k] = nums[i];
            }

            k++;
        }
        return res;
    }
}
