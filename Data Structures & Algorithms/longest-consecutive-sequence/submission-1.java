class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        int result = 1;

        for (int num : nums) {
            numSet.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i] - 1)) {
                continue;
            }

            int sequenceLength = 1;
            int nextNum = nums[i] + 1;

            while (numSet.contains(nextNum)) {
                sequenceLength++;
                nextNum++;
            }

            result = Math.max(result, sequenceLength);
        }

        return result;
    }
}
