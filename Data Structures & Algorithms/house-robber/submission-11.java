class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int max2 = nums[0];
        int max1 = Math.max(nums[0], nums[1]);
        int result = max1;

        for (int i = 2; i < n; i++) {
            result = Math.max(max1, max2 + nums[i]);
            max2 = max1;
            max1 = result;
        }

        return result;
    }
}
