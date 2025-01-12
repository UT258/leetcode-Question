class Solution {
    public boolean canBeValid(String s, String locked) {
        //if it is a odd length then it cannnot be balaned
        if(s.length()%2!=0)
        {
            return false;//it and odd length
        }
        int open =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || locked.charAt(i)=='0')
            {
                //we have to make open bracket maximum so 
                //0 will be treated as open
                open++;
            }
            else{
                open--;

            }
            if(open<0)
            {
                return false;
            }

        }
        int  close =0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')' || locked.charAt(i)=='0')
            {
                //we have to make open bracket maximum so 
                //0 will be treated as open
                close++;
            }
            else{
                close--;

            }
            if(close<0)
            {
                return false;
            }

        }
        return true;
    }
}