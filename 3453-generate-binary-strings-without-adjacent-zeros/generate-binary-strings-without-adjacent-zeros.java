class Solution {
    List<String>ans=new ArrayList<>();
    public List<String> validStrings(int n) {
         solve("",n);
         return ans;
        
    }
    public boolean isvalid(String s)
    {    
        for(int i=0;i<s.length()-1;i++)
        {
            char ch=s.charAt(i);
            if(ch=='0')
            {
                if(s.charAt(i+1)=='0')
                {
                    return false;
                }
            }
        }
        return true;
    }
    public void solve(String s,int n)
    {
     if(s.length()==n){
        if(isvalid(s))
        ans.add(s);
        return ;
     }
     s+='1';
     solve(s,n);
     s=s.substring(0,s.length()-1);
     s+='0';
     solve(s,n);
    }
}