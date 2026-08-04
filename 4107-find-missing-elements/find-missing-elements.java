class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return list;

        Arrays.sort(nums);

        int current = nums[0];

        for (int i = 0; i < nums.length; i++) {

            while (current < nums[i]) {
                list.add(current);
                current++;
            }

            current = nums[i] + 1;
        }

        return list;
    }
}