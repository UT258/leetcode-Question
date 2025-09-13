class Solution {
    boolean  isvowel(char ch)
    {
       return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    public int maxFreqSum(String s) {
        int arr[]=new int [26];
        for(char ch:s.toCharArray())
        {
             arr[ch-'a']++;

        }
        int maxv=0;
        int maxc=0;
        for(char ch:s.toCharArray())
        {
             if(isvowel(ch))
             {
                maxv=Math.max(maxv,arr[ch-'a']);
             }
             else{
             maxc=Math.max(maxc,arr[ch-'a']);
             }

        }
        return maxc+maxv;


       
        
    }
}