class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }

    public void helper(int[] arr, int i, ArrayList<Integer> list) {
        if (i == arr.length) {
            if (!ans.contains(new ArrayList<>(list))) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        // take it
        list.add(arr[i]);
        helper(arr, i + 1, list);

        // not take it
        list.remove(list.size() - 1);
        helper(arr, i + 1, list);
    }
}
