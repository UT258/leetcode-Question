class Solution {
    public int minOperations(int[] nums, int k) {
        //we are only decrease we can never increase
        HashSet<Integer>set=new HashSet<>();
        for(int n:nums)
        {
            if(n<k)
            {
                return -1; //we can never make it equal 

            }
            if(n>k)
            {
                set.add(n);//add all the distinct element greater than k
            }
        }
        return set.size();
    }
}