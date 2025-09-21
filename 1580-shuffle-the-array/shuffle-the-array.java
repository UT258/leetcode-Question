class Solution {
    public int[] shuffle(int[] nums, int n) {
       int i=0;
       int j=n;
      int ans[]=new int [2*n];
      int k=0;//serve as the index of the ans array
       while(i<n)
       {
         ans[k]=nums[i];
         ans[k+1]=nums[j];
         i++;
         j++;
         k+=2;
       }
   
        return ans;
    }
}