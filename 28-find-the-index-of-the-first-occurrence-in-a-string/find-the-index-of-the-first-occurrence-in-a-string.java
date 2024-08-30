class Solution {
    public int strStr(String haystack, String needle) {
        return helper(haystack,needle,0);
        
    }
    private int helper(String h,String n,int i)
    {
        if(i>h.length()-n.length())
        {
            return -1;
        }
        //the now check if the string is present or not
        if(h.substring(i,i+n.length()).equals(n))
        {
            return i; //we got the index
        }
        return helper(h,n,i+1);//call for the next one 
    }
}