class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int n:nums)
        {
              map.put(n,map.getOrDefault(n,0)+1);
        }
        int ans=0;
        for(int n:nums)
        {
         int min=n;
         int max=n+1;
         if(map.containsKey(max))
         {  int len=map.get(min)+map.get(max);
            ans=Math.max(ans,len);
         }    
        }
        return ans;
        
    }
}