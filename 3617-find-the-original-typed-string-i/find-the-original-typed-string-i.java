class Solution {
    public int possibleStringCount(String word) {
        int i=0;
        int ans=1; //whole word may be the intended word
        while(i<word.length())
        {
            int j=i;
            //find the repeated one
            while(j<word.length() && word.charAt(i)==word.charAt(j))
            {
                j++;
                //count the continous repeated character
            }
           if(j-i>1)
           {
            ans+=j-i-1;//total count -1  if there are 4 char then 3 are the repeating   (j-i) is the count not j will point at the char that is not equal acc to while loop 
           }
           //move forward 
           i=j;// j is at the character that is not equal  
        }
        return ans;

        
    }
}