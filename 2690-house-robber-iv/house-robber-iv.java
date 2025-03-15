class Solution {
    public boolean ispossible(int arr[],int k,int mid)
    {   int c=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=mid)
            {
                c++;
                i++;//skip the house
            }
        }
        return c>=k;
    }
    public int minCapability(int[] nums, int k) {
        int start=0;
        int end=0;
        int res=0;
        for(int n:nums)
        {
            start=Math.min(start,n);
            end=Math.max(end,n);
        }
        while(start<=end)
        {
            int mid =start+(end-start)/2;
            if(ispossible(nums,k,mid))
            {
                //i have to look for the answer that is lesser
                res=mid;//this can be my answer look for more smaller
                end=mid-1;//reduce the rigt half

            }
            else{
                 start=mid+1;
            }
        }
        return res;
        
    }
}