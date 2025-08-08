class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1)return nums.length;
        Arrays.sort(nums);
        int c=1;
        int max=Integer.MIN_VALUE;
        int prev=Integer.MIN_VALUE;
        for(int n:nums){
            if(n-1 ==prev)
            {
             //this can be the part of sequence
             c++;
             prev=n;
            }
            else if(prev !=n)
            {
                //this can be my start of the sequnce
                c=1;
                prev=n;
            }
            max=Math.max(max,c);
        }
        return max;
    }
}