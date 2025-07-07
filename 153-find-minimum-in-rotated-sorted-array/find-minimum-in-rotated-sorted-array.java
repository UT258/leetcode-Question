class Solution {
    public int findMin(int[] nums) {
        int bpoint=pivot(nums);
        if(bpoint==nums.length-1)
        {
            //its already rotated n times
            //so the array is plane sorted 
            return nums[0];
        }
        return nums[bpoint+1];
        
    }
    public int pivot(int nums[])
    {

        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {    int mid=start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1])
            {
                return mid; //pivot found
            }
            if(mid >start && nums[mid]<nums[mid-1])
            {
                return mid-1;
            }
            if(nums[start]>=nums[mid])
            {
                end=mid-1;
            }
            if(nums[start]<=nums[mid])
            {
                start=mid+1;
            }

        }
        return -1;
    }
}