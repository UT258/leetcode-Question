class Solution {
    String map[]={"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String>list=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())

        {
            return new ArrayList<>();
        }
        solve("",digits);
        return list;
    }
    public void solve(String up ,String digits)
    {
        if (digits.isEmpty())
        {
            list.add(up);
            return;
        }
        int digit =digits.charAt(0)-'0';
       for(char ch:map[digit-1].toCharArray())
       {
        solve(up+ch,digits.substring(1));
       }
    }
}