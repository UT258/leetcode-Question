class Solution {
    public boolean valid (char ch)
    {
        return ch=='a' || ch=='b' || ch=='c';
    }
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int  i=0;
        int j=0;
        int c=0;
        int n=s.length();
        while(j<s.length())
        {
          char ch=s.charAt(j);
          if(ch=='a' || ch== 'b' || ch=='c')
          {
            map.put(ch,map.getOrDefault(ch,0)+1);

          }
          
          while(map.size()==3)
          {
            //remove the entry of it in the map 
            char rm=s.charAt(i);
            c+=n-j;
            map.put(rm,map.get(rm)-1);
            if(map.get(rm)==0)
            {
                map.remove(rm);//if the frq is zero remove it 

            }
            i++;
          }
          //now shrink the window 
    
          j++;
           

          
        }
        return c;
        
        
    }

    
}