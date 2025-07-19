class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        Set<Integer>set=new HashSet<>();
        while(j<nums.length)
        {
            while(set.contains(nums[j]))
            {
                //as long as there are duplicate shrink the window
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            sum+=nums[j];
            set.add(nums[j]);
            maxsum=Math.max(maxsum,sum);
            j++;
            //now here duplicate removed

        }
        return maxsum;
        
    }
}