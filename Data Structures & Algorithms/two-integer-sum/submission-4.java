class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numIndicies = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int counterPart = target - nums[i];
            Integer counterPartIndex = numIndicies.get(counterPart);

            if (counterPartIndex != null && counterPartIndex != i) {
                int[] answer = new int[2];
                boolean iSmaller = i < counterPartIndex;
                answer[0] = iSmaller ? i : counterPartIndex;
                answer[1] = iSmaller ? counterPartIndex : i;
                return answer;
            }

            numIndicies.putIfAbsent(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
