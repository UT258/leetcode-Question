class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder st=new StringBuilder();
        for (int k = 0; k < s.length(); k++)
        {
            char c = s.charAt(k);

            if (Character.isLetterOrDigit(c)) 
            {
                st.append(Character.toLowerCase(c));
            }
        }
        s=st.toString();//reassign
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {   
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;

        
    }
}