class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer>set=new HashSet<>();
        for(int n:nums)
        {
             set.add(n);
        }
        while(set.contains(original))
        {
            original=original << 1;
        }
        return original;
        
    }
}