class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            cache[i] = Math.max(cache[i-1], cache[i-2] + nums[i-1]);
        }

        return cache[n];
    }
}
