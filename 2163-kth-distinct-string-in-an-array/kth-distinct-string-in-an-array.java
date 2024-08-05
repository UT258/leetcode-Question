class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer>map=new  HashMap<>();
        for(String c: arr)
        {
            map.put(c,map.getOrDefault(c,0)+1);
            
        }
        int count=0;
         for(String c: arr)
        {
            //check for the distint
             if(map.get(c)==1)
             {
      count++;
             }
             if(count==k)
             {
                 return c;
             }
           
        }
        return "";
        
        
    }
}