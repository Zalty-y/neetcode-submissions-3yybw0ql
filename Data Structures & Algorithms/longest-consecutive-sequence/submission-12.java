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

            if (len > 1) {
                continue;
            }

            while (seqLengths.containsKey(next)) {
                int nextLen = seqLengths.get(next);
                len += nextLen;

                if (nextLen > 1) {
                    break;
                }
                
                next++;
            }

            answer = Math.max(answer, len);

            while (len > 1) {
                seqLengths.replace(num, len);
                num++;
                len--;
            }
        }

        return answer;
    }
}
