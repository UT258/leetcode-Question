class Solution {
    public boolean isIsomorphic(String s, String t) {
        //just count the frq
        int[] frq1=new int [200];
        int []frq2=new int [200];
         if(s.length()!=t.length())
         {
            //if the string length are not same they cannot be isomorphic
            return false;
         }
         int i=0;
         while(i<s.length())
         {
            char a=s.charAt(i);
            char b=t.charAt(i);
            if (frq1[a]!=frq2[b])
            {
                //at this point both frequencies should be equal
                return false;
            }
            //put the frq in the array
            frq1[a]=i+1;//store the position of the element
            frq2[b]=i+1;
            i++;
         }
         return true;
    }
}