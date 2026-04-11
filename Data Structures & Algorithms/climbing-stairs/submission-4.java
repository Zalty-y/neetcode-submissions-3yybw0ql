class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return climbStairsRecursive(n, cache);
    }

    private int climbStairsRecursive(int i, int[] cache) {
        if (i <= 2) {
            return i;
        }
        if (cache[i] != -1) {
            return cache[i];
        }

        return cache[i] = climbStairsRecursive(i-1, cache) + climbStairsRecursive(i-2, cache);
    }
}
