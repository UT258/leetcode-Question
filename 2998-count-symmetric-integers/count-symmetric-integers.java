class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++)
        {
            String s=Integer.toString(i);
            if(s.length()%2!=0)
            {
                continue;
            }
            int lsum=0;
            int rsum=0;
            for(int k=0;k<s.length()/2;k++)
            {
                lsum+=s.charAt(k)-'0';//convert it to int
            }
            for(int j=s.length()/2;j<s.length();j++)
            {
                rsum+=s.charAt(j)-'0';//convert it to int
            }
            if(lsum==rsum)count++;
        }
        return count;
        
    }
}