class Solution {
    public int findMin(int[] nums) {
        int result = nums[0];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if(nums[left]<nums[right])
            {
                result = Math.min(result, nums[left]);
                break;
            }

            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[right]) {
                result = Math.min(result, nums[mid]);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
