class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            // Calculate potential max distance by comparing current max and min with others.
            result = Math.max(result, Math.max(Math.abs(maxValue - currentMin), Math.abs(currentMax - minValue)));

            // Update the min and max values
            minValue = Math.min(minValue, currentMin);
            maxValue = Math.max(maxValue, currentMax);
        }

        return result;
    }
}
