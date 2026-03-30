class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int counterPart = target - nums[i];
            
            if (numToIdx.containsKey(counterPart)) {
                return new int[] {numToIdx.get(counterPart), i};
            }

            numToIdx.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
