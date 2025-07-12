class NumArray {
     ArrayList<Integer>list;
    public NumArray(int[] nums) {
        list=new ArrayList<>();
        for(int n:nums)
        {
            list.add(n);
        }
    }
    
    public int sumRange(int left, int right) {
        int sum=0;
        for(int i=left;i<=right;i++)
        {
            sum+=list.get(i);
        }
        return sum;

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */