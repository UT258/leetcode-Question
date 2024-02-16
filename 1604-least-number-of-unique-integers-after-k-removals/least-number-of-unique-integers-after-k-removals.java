class Solution {
    public int findLeastNumOfUniqueInts(int[] nums, int k) {
        HashMap<Integer,Integer>map =new HashMap<>();
        for(int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);//it will fill the frequency
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int n:map.values())
        {
            list.add(n);
        }
        Collections.sort(list);
      for(int i=0;i<list.size();i++)
        {
            if(k>=list.get(i))
            {
                k-=list.get(i);
                list.remove(i);
                i--;
            }
        }
        return list.size();
        
    }
}