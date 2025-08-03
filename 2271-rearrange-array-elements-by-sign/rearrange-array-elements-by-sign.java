class Solution {
    public int[] rearrangeArray(int[] nums) {
        int ans[]=new int[nums.length];
        int i=0;//even indx for pos
        int j=1;//odd inde for neg
        for(int n:nums)
        {
            if(n<0)
            {
                //if its a negativ put it in odd index
                ans[j]=n;
                j+=2;
            }
            else{
                ans[i]=n;
                i+=2;
            }
        }
        return ans;
        
    }
}