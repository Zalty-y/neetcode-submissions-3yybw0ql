class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            char current = s.charAt(i-1);
            char prev = s.charAt(i-2);
            if (current != '0') {
                cache[i] = cache[i-1];
            }

            if (i-2 >= 0 && (prev == '1' || prev == '2' && current <= '6')) {
                cache[i] += cache[i-2];
            }
        }

        return cache[n];
    }
}
