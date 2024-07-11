class Solution {
    public int maxConsecutiveAnswers(String answerkey, int k) {
        //simple two pointer problem
        int length=Math.max(maxlen(answerkey,k,'T'),maxlen(answerkey,k,'F'));
        return length;
        
        
    }
    private int maxlen(String answerkey, int k,char ch)
    {

     int i=0;
        int j=0;
        int c=0;
        int maxlength=0;
        while(j<answerkey.length())
        {
            if(answerkey.charAt(j)==ch)
            {
             c++;
            }
            if(c>k)
            {
                //then shrink the window
                while(c>k)
                {   
                    if(answerkey.charAt(i)==ch)
                    {
                        c--;

                    }
                    i++;
                }
            }
            if(c<=k)
            {
                maxlength=Math.max(maxlength,j-i+1);
            }
            j++;
        }
        return maxlength;
    }
}