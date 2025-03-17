class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
    
        for(int i=0;i<nums.length-1;i+=2)
        {    int n=nums[i]^nums[i+1];
            if(n!=0)
            {
              return false;
            }
        }
        return true;
        
    }
}