class Solution {
    int count=0;
    public void checkcenter(int i,int j,int n,String s)
    {
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j))
        {
            count++;
            i--;//move the left
            j++;

        }
        
    }
    public int countSubstrings(String s) {
        //even and  odd length logic 
          for(int i=0;i<s.length();i++)
          {
            checkcenter(i,i,s.length(),s);//check for odd len substring
            checkcenter(i,i+1,s.length(),s);//check for even length two center

          }
          return count;
        
    }
}