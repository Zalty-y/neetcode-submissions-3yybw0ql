class Solution {
    public int maxArea(int[] heights) {
        int answer = 0;
        int n = heights.length;

        int left = 0, right = n - 1;
        while (left < right) {
            int area = 0;
            int width = right - left;
            if (heights[left] < heights[right]) {
                area = heights[left++] * width;
            } else {
                area = heights[right--] * width;
            }
            answer = Math.max(answer, area);
        }

        return answer;
    }
}
