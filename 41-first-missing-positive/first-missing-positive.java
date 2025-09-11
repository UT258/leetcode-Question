class Solution {
    public int firstMissingPositive(int[] nums) {
        //cyclic sort
        sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=i+1 )
            {
                return i+1;
            }
        }
        return nums.length+1;
      
    }
    private void sort(int arr[])
    {
        int i=0;
        while(i<arr.length  )
        {
            int correct=arr[i]-1;
            if(  arr[i]>0  && arr[i]<=arr.length && arr[i]!=arr[correct])
            {
                //if not at correct post swap with correct
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }
            else{
                i++;
            }
        }
    }
}