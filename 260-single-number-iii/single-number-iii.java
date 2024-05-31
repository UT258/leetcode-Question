import java.util.Map.Entry;
class Solution {
    
    public int[] singleNumber(int[] nums) {
        int ans[]=new int [2];
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int n: nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);


        }
        int k=0;
         for(int n:nums)
        {
            if(map.get(n)==1 ){
                ans[k]=n;
                k++;
            }
        }
        return ans;
    }
    
}