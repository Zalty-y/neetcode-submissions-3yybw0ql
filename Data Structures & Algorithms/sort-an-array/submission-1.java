class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1, new Random());
        return nums;
    }

    private void quickSort(int[] nums, int left, int right, Random rnd) {
        if (right < left) {
            return;
        }
        
        int pivot = left + rnd.nextInt(right - left + 1);

        pivot = partition(nums, left, right);

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

        swap(nums, pivot, i + 1);
        return i + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}