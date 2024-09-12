class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        for(String s:words)
        {   boolean flag=true;
            for(char c:s.toCharArray())
            {
                if(!allowed.contains(Character.toString(c)) )
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                count++;
            }
        }
        

        return count;

    }
}