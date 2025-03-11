class Solution {
    public int numberOfSubstrings(String s) {
        
        int count = 0;
        int lastseen[] = new int[3];
        Arrays.fill(lastseen,-1);
        for (int i = 0; i < s.length(); i++)

        {
            char ch = s.charAt(i);
            lastseen[ch - 'a']=i;
            
count +=1 + Math.min(Math.min(lastseen[0],lastseen[1]),lastseen[2]);// the minimum will be starting
                                                                                       // of the valid window and the
                                                                                       // sustring that have that i as
                                                                                       // its last character will be i+1
            

        }
        return count;

    }
}