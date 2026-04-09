class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int f2 = 0;
        int f1 = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 2; i <= n; i++) {
            result = Math.min(f1 + cost[i-1], f2 + cost[i-2]);
            f2 = f1;
            f1 = result;
        }

        return result;
    }
}
