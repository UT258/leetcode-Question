class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);//sort the array so we can avoid taking duplicate
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i-1]==nums[i])continue;//they must point to unique ones 
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                //as long as this is valid window we will fix i and
                //check for j and k
                int sum=nums[i]+nums[j]+nums[k];
                if(sum > 0)
                {
                    //decrease the  sum
                    k--;
                }
                else if( sum<0){
                    //increas the sum
                    j++;
                }
                else{
                    //sum==0; valid triplet
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    //now find other valid one
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1])k--;
                }
            }
          
        }
        return ans;
        
    }
}