class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet();

        for (int num : nums) {
            set.add(num);
        }

        int result = 1;

        for (int num : nums) {
            if (set.contains(num-1)) {
                continue;
            }

            int count = 1;
            int next = num + 1;

            while (set.contains(next)) {
                next++;
                count++;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
