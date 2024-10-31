class Solution {
    public boolean isSubsequence(String s, String t) {
        //check the order
        if(s.isEmpty() )
        {
            return true;
        }
        int i=0;
        int j=0;
        while(j<t.length()&& i<s.length())
        {
            if( s.charAt(i)==t.charAt(j))
            {
                i++;
            }
          j++;
        }
        return i==s.length();
        
    }
}