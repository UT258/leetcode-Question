class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            sum += num;
            set.add(num);
        }
        
        double avg = (double) sum / n;
        int ans = (int) Math.floor(avg) + 1;
        
        // ensure ans is positive
        if (ans <= 0) ans = 1;
        
        while (set.contains(ans)) {
            ans++;
        }
        
        return ans;
    }
}
