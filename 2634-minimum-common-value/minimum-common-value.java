class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
       //second method using two pointer
       int i=0;
       int j=0;
       while(i<nums1.length && j<nums2.length)
       {
           if (nums1[i]==nums2[j])
           {
               return nums1[i];
           }
           else if (nums1[i]<nums2[j])
           {
               //if it is smaller then increase its value
               i++;
           }
           else{
               j++;//its means second array value need to be increased
           }
       }
       return -1;
     
        
    }
}