class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, -1);
        int result = dfs(amount, cache, coins);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int amount, int[] cache, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        if (cache[amount] != -1) {
            return cache[amount];
        }

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            int subProblem = dfs(amount - coin, cache, coins);
            result = Math.min(result, subProblem == Integer.MAX_VALUE ? subProblem : subProblem + 1);
        }

        return cache[amount] = result;
    }
}
