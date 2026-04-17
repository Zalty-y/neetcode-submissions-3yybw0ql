class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bot = n - 1;
        int row = -1;
        while (top <= bot) {
            int mid = top + (bot - top + 1) / 2;
            if (matrix[mid][m-1] < target) {
                top = mid + 1;
            } else if (matrix[mid][0] > target) {
                bot = mid - 1;
            } else {
                row = mid;
                break;
            }
        }

        int left = 0;
        int right = m - 1;
        while (row != -1 && left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (matrix[row][mid] < target) {
                left = mid + 1;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
