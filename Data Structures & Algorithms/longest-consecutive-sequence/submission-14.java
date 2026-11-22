class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> numSet = new HashSet<>();
        int answer = 0;

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            boolean containsPrevious = numSet.contains(num - 1);

            if (num != Integer.MIN_VALUE && containsPrevious || containsPrevious) {
                continue;
            }
            
            int next = num + 1;
            while (numSet.contains(next)) {
                next++;
            }

            answer = Math.max(answer, next - num);
        }

        return answer;
    }
}
