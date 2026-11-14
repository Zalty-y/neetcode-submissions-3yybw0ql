class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Map<Integer, Integer> seqLengths = new HashMap<>();

        for (int num : nums) {
            seqLengths.putIfAbsent(num, 1);
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int next = num + 1;
            int len = seqLengths.get(num);

            if (len > 1 || seqLengths.containsKey(num - 1)) {
                continue;
            }

            while (seqLengths.containsKey(next)) {
                len++;
                next++;
            }

            answer = Math.max(answer, len);
            seqLengths.replace(num, len);
        }

        return answer;
    }
}
