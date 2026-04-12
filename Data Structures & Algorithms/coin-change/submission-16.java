class Solution {

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        int baseResult = amount == 0 ? 0 : -1;
        cache.put(amount, baseResult);

        for (int i = 1; i <= amount; i++) {
            int numCoins = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }

                int subProblem = cache.containsKey(i-coin) ? cache.get(i-coin) + 1 : Integer.MAX_VALUE;

                numCoins = Math.min(numCoins, subProblem);

                if (numCoins != Integer.MAX_VALUE) {
                    cache.put(i, numCoins);
                }
            }
        }

        int result = cache.get(amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
