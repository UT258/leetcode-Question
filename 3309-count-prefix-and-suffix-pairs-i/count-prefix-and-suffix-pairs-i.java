class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                //i< j
                String w1=words[i];
                String w2=words[j];
                if(w1.length()>w2.length())
                {
                    //if the length of the word 1 >w2 it cannot be prefix or suffix
                    continue;
                }
                if(w2.startsWith(w1)&& w2.endsWith(w1))
                {
                    //it is common prefix and suffix
                    count++;
                }
            }
        }
        return count;
        
    }
}