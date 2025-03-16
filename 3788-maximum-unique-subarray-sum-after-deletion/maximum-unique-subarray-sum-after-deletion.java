class Solution {
    public int maxSum(int[] nums) {
        Set<Integer>set=new HashSet<>();
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int n:nums)
        {
            if(set.add(n))
            {
             max=Math.max(max,n); //if the maximum element in the array is -ve that means all the element are negative so we can say that to get maximu sum we deleted all the element the maximum is the answer
             if(n>0) sum+=n;
            }
        }
        return  max<=0? max: sum;
        
    }
}