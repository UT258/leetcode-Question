class Solution {
     private static boolean valid(String temp) {
        String rev=new StringBuilder(temp).reverse().toString();
        return rev.equals(temp);

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