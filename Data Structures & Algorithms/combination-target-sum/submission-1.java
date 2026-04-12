class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, subset, result, nums, target);
        return result;
    }

    private void dfs(int i, List<Integer> subset, List<List<Integer>> result, int[] nums, int target) {
        if (target < 0 || i >= nums.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (target - nums[i] >= 0) {
            subset.add(nums[i]);
            dfs(i, subset, result, nums, target - nums[i]);
            subset.remove(subset.size() - 1);
        }

        dfs(i+1, subset, result, nums, target);
    }
}
