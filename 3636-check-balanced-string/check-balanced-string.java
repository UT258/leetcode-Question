class Solution {
    public boolean isBalanced(String num) {
        int e=0;
        int o=0;
        for(int i=0;i<num.length();i++)
        {
            if(i%2==0)
            {
                e+=num.charAt(i)-'0';
            }
            else{
                o+=num.charAt(i)-'0';
            }
        }
        return o==e;
        
    }
}