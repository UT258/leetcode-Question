class Solution {
    public int lengthOfLongestSubstring(String s) {
  int max=0;
        int i=0;
        int j=0;
       HashMap<Character,Integer>map=new HashMap<>();
       
        while(j<s.length())
        {  
        char ch=s.charAt(j);
        //if i already seen earlier
        //then remove it from window by moving forward
        if(map.containsKey(ch))
        {
         i=Math.max(i, map.get(ch)+1);

        } 
        map.put(ch,j);
        max=Math.max(max,j-i+1);
        j++;
        }
        return max;
        
    }
}