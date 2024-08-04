class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
         ArrayList<Integer>list=new ArrayList<>();   
     for (int i = 0; i < nums.length; i++) {
        int sum=0;
        for (int j = i; j < nums.length; j++) {
            sum+=nums[j];
            list.add(sum);
           
        }
        
     }
     Collections.sort(list,(a,b)->a-b);
        int rsum=0;
        for (int i = left-1; i < right; i++) {
            rsum=(rsum+list.get(i))% ((int)Math.pow(10,9)+7);
        }
        return rsum ;
 
    }
}