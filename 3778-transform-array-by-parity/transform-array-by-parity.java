class Solution {
    public int[] transformArray(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if( (nums[i] & 1)==1)
            {
              nums[i]=1;
            }
            else{
                nums[i]=0;
            }
        }
        Arrays.sort(nums);
        return nums;
        
    }
}