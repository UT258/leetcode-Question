import java.util.*;

class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> validStrings(int n) {
        solve("", n);
        return ans;
    }

    public void solve(String s, int n) {
        if (s.length() == n) {
            ans.add(s);
            return;
        }

       
       solve(s+'1',n);
       if(s.isEmpty() || s.charAt(s.length()-1)!='0')
       {
        
        solve(s+'0',n);
       }
    }

    
}
