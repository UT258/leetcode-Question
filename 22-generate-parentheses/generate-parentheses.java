class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve("",0,0,n);
        return ans;

    
    }
    public  void solve(String  s,int open , int close , int n)
    {
        if(s.length()== 2*n)
        {
            ans.add(s);
            return;
        }
        if(open <n)
        {
            s+='(';
            solve(s,open+1,close,n);
            s=s.substring(0,s.length()-1);//remove the last added bracket 
        }
        if(close<open)
        {
            s+=')';
            solve(s,open,close+1,n);
        }

    }
}