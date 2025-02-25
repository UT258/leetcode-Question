class Solution {
    public int removeDuplicates(int[] nums) {
     //to remove the element inplace 
     int i=0;
     int j=0;
     while(j<nums.length)
     {
        //j will point to element that is not equal to the element i cuz array is sorted 
        if(nums[j]!=nums[i])
        {
            nums[i+1]=nums[j];
            i++; //increase the i so it will point at the next unique element 

        }
        j++;
     } 
     return i+1;//indx+1 element 
    }
}