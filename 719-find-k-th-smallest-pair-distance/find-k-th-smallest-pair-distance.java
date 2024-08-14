class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        //sliding window +binary search
        Arrays.sort(nums);
        int start=0;
        int result=0;
        int end =nums[nums.length-1]-nums[0];//maxium -minimum
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            int count=slidingwindow(nums,mid);
            if(count<k)
            {
                start=mid+1;
            }
            else{
                result=mid;
                end=mid-1;
            }
        }
        return result;
        
    }
    private int slidingwindow(int []nums,int distance)
    {
        int i=0;
        int j=1;
        int count=0;
        while(j<nums.length)
        {
            while(nums[j]-nums[i]>distance)
            {
                i++;
            }
            //now here the distance is smaller 
            //add it in the count
            count+=j-i;
            j++;
        }
        return count;

    }
}