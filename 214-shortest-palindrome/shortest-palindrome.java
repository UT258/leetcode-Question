class Solution {
    public String shortestPalindrome(String s) {
      //find the longest substring that is palindrome and then add the reverse of 
      //remaining to the answer to make the shortest pallindrome
         String reverse=new StringBuilder(s).reverse().toString();
      //to calulate the pallindrome
      for(int i=0;i<s.length();i++)
      {
        if(s.substring(0,s.length()-i).equals(reverse.substring(i)))
        {
return  new StringBuilder(reverse.substring(0,i)).append(s).toString();
        }
      }
   return "";
    }
}