class Solution {
    public String defangIPaddr(String address) {
        StringBuilder s=new StringBuilder();
        for(char ch:address.toCharArray()) 
        {
            if(ch=='.')
            {
                s.append("[.]");
            }
            else{
                s.append(ch); //just add the character itself
            }
        }
        return s.toString();       
    }
}