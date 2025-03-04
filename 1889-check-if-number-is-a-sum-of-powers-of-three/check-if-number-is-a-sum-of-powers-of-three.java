class Solution {
    public boolean checkPowersOfThree(int n) {
       String s=Integer.toString(n,3);
       for(char ch:s.toCharArray())
       {
        if(ch=='2')
        {
            return false;
        }
       }
       return true;
        
    }
}