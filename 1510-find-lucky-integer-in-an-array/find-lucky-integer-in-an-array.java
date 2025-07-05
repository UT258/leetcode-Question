class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int n:arr)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int max=-1;
      for(Map.Entry<Integer,Integer>e:map.entrySet())
      {
        if(e.getKey()==e.getValue())
        {
            max=Math.max(e.getValue(),max);
        }

      }
        return max;
    }
}