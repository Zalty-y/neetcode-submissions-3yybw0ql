class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        int n = nums.length;
        Boolean[][] cache = new Boolean[n][target + 1];

        return dfs(0, target, cache, nums);
    }

    private boolean dfs(int i, int target, Boolean[][] cache, int[] nums) {
        if (i >= nums.length) {
            return target == 0;
        }
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        if (cache[i][target] != null) {
            return cache[i][target];
        }

        return cache[i][target] = dfs(i + 1, target, cache, nums) || dfs(i + 1, target - nums[i], cache, nums);
    }
}
