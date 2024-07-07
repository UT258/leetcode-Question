class Solution {
    public int lengthOfLongestSubstring(String s) {
          int i=0;
          int j=0;
          int max=0;;
          HashMap<Character,Integer> map =new HashMap<>();
          while(j<s.length())
          {
            //if the character is present then you need to shrink the substring
            if(map.containsKey(s.charAt(j)))
            {
                //if the character is present then you need to shrink the substring
                //remove the chracter form the window 
                if(map.get(s.charAt(j))>=i)
                {
                    i=map.get(s.charAt(j))+1;
                }

            }
            int length=j-i+1;
            max=Math.max(max, length);
            //put the character in the map
            map.put(s.charAt(j),j);
            j++;
          }
          return max;

        
    }
}