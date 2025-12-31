class Solution {
     private static boolean valid(String temp) {
       for(int i=0;i<temp.length();i++)
       {
         if(temp.charAt(i)!=temp.charAt(temp.length()-1-i))
         {
            return false;
         }
       }
       return true;

    }
    public boolean isPalindrome(String s) {
        String temp="";
        for(char ch:s.toCharArray())
        {
            if(Character.isLetterOrDigit(ch))
            {
             temp+=Character.toLowerCase(ch);
            }
        }
        if(valid(temp))
        {
            return true;
        }

        return  false;
    }
}