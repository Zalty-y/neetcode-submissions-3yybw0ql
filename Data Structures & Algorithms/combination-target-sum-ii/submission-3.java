class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList();
        quickSort(candidates, 0, candidates.length - 1, new Random());
        backtrack(candidates, 0, target, subset, result);
        return result;
    }

    private void backtrack(int[] nums, int index, int target, List<Integer> subset, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList(subset));
            return;
        }
        if (!(0 <= index && index < nums.length) || target < 0) {
            return;
        }

        subset.add(nums[index]);

        backtrack(nums, index + 1, target - nums[index], subset, result);
        subset.remove(subset.size() - 1);

        while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
            index++;
        }

        backtrack(nums, index + 1, target, subset, result);
    }

    private void quickSort(int[] nums, int left, int right, Random rnd) {
        if (left >= right) {
            return;
        }

        int pivot = left + rnd.nextInt(right - left);

        pivot = partition(nums, left, pivot);

        quickSort(nums, left, pivot - 1, rnd);
        quickSort(nums, pivot + 1, right, rnd);
    }

    private int partition(int[] nums, int left, int pivot) {
        int i = left - 1;

        for (int j = left; j < nums.length; j++) {
            if (nums[j] < nums[pivot]) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, pivot);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
