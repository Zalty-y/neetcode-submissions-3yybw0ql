class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList();
        traverse(nums, 0, subset, target, result);

        return result;
    }

    private void traverse(int[] nums, int index, List<Integer> subset, int target, List<List<Integer>> result) {
        if (0 == target) {
            result.add(new ArrayList(subset));
            return;
        }
        if (!(0 <= index && index < nums.length) || target < 0) {
            return;
        }

        subset.add(nums[index]);
        traverse(nums, index, subset, target - nums[index], result);
        subset.remove(subset.size() - 1);
        traverse(nums, index + 1, subset, target, result);
    }
}
