class Solution {

    public int romanToInt(String s) {
        //just use the hashmap to store the values
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int prevValue = 0;
        for (char c : s.toCharArray()) {
            int currentValue = map.get(c);
            if (currentValue > prevValue) { // Subtract twice the previous value because it was added once
                ans += currentValue - 2 * prevValue;
            } else {
                ans += currentValue;
            }
            prevValue = currentValue;
        }
        return ans;
    }
}