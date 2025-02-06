class Solution {
    public int tupleSameProduct(int[] nums) {
        // one tupple will have 8 permutations
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                // add the frequency of product
                map.put(product, map.getOrDefault(product, 0) + 1);

            }
        }
        int t = 0;
        // the product that have come more that 2 contribute to tupple
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int f = e.getValue();
            // use combination problem
            t += f * (f - 1) / 2;

        }
        return t * 8;
    }
}