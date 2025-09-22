class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);

        }
        int max=0;
        int element=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            max=Math.max(max,entry.getValue());
        }
        
       int count=0;
       for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==max)
            {
                count+=entry.getValue();
            }
        }
        return count;
        

        
    }
}