class Solution {
    public int rob(int[] nums) {
        int max2 = 0;
        int max1 = 0;
        int result = 0;
        
        for (int num : nums) {
            result = Math.max(max1, max2 + num);
            max2 = max1;
            max1 = result;
        }

        return result;
    }
}
