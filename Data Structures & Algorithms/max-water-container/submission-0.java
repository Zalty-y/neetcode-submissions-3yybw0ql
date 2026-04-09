class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int smallerWall = Math.min(heights[left], heights[right]);
            int area = (right - left) * smallerWall;
            result = Math.max(result, area);

            if (heights[left] == smallerWall) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
