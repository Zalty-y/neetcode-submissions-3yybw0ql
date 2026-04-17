class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = -1;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = timeToEat(mid, piles);
            if (time <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int timeToEat(int speed, int[] piles) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / speed);
        }

        return time;
    }
}
