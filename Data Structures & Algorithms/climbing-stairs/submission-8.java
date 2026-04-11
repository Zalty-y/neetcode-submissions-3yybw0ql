class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int steps2 = 1;
        int steps1 = 2;
        int result = 0;

        for (int i = 2; i < n; i++) {
            result = steps1 + steps2;
            steps2 = steps1;
            steps1 = result;
        }

        return result;
    }
}
