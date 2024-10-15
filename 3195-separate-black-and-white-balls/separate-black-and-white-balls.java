class Solution {
    public long minimumSteps(String s) {
        //normal  solution 
        long b=0;
        long c=0;
        for(int i=0;i<s.length();i++)
        {
           if(s.charAt(i)=='1')
           {
              b++;
           }
           else{
            c+=b;
           }
        }
        return c;
    }
}