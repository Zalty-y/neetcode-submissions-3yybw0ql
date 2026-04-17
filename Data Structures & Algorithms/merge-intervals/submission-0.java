class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        
        result.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int prevEnd = result.get(result.size() - 1)[1];

            if (start <= prevEnd) {
                result.get(result.size() - 1)[1] = Math.max(end, prevEnd);
            } else {
                result.add(interval);
            }
        }
        
        return result.toArray(new int[0][]);
    }
}
