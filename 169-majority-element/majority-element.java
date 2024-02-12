class Solution {
    public int majorityElement(int[] nums) {
      //when array is sorted the middle element will be the element
      //that appeared more than n/2 times
      Arrays.sort(nums);
      return nums[nums.length/2];
        
    }
}