class Solution {
    public int firstMissingPositive(int[] nums) {
    int size=nums.length;
    Set<Integer>set=new HashSet<>();
    for(int n:nums)
    {   if(n>0 )
        set.add(n);
    }
    for(int i=1;i<=size;i++)
    {
        if(!set.contains(i))
        return i;
    }
    return nums.length+1;
    }
}