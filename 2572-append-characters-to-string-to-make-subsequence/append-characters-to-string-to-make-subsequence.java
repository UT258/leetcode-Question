class Solution {
    public int appendCharacters(String s, String t) {
        //two pointer 
        int i=0;//for the s 
        int j=0;
        //find the starting index where they are not equal in the string t 
        
        while(i<s.length() && j<t.length())
        

        {
            if (s.charAt(i)== t.charAt(j))
            {
                j++;
            }
            i++;
        }
        return t.length()-j;


    }
}