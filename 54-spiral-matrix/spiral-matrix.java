class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;
        int idx = 0;
        while (top <= bottom && left <= right)

        {
            // now print the first row
            if (idx == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }

                // since first row done move the bootom
                top++;
            }
            // for top to down
            if (idx == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);// col will be right
                }
                right--;
            }
            // for right to left
            if (idx == 2) {
                // Move left across the bottom row
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (idx == 3) {
                // Move up the left column
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            idx++;
            if (idx == 4)

            {
                idx = 0;
            }

        }
        return list;

    }
}