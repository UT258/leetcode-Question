class Solution {
    public boolean canConstruct(String s, int k) {
        
        if(s.length()<k)
        {
            return false;
        }
        if(s.length()==k)
        {
            return true;
        }
        int arr[] = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int c = 0;
        for (int n : arr) {
            if (n % 2 != 0) {
                c++;
            }
        }
        return c <= k;
    }
}