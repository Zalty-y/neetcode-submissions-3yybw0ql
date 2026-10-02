class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndicies = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int counterPart = target - nums[i];
            Integer counterPartIndex = numIndicies.get(counterPart);

            if (counterPartIndex != null) {
                boolean iSmaller = i < counterPartIndex;
                return iSmaller
                    ? new int[] { i, counterPartIndex }
                    : new int[] { counterPartIndex, i};
            }

            numIndicies.putIfAbsent(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
