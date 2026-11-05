class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> counterparts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer counterpart = counterparts.get(target - num);

            if (counterpart != null && i != counterpart) {
                boolean iSmaller = i < counterpart;
                int l = iSmaller ? i : counterpart;
                int r = iSmaller ? counterpart : i;
                return new int[] { l, r };
            }

            counterparts.put(num, i);
        }

        return new int[] { 0, 0};
    }
}
