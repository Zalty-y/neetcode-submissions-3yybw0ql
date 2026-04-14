class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visitedPacific = new boolean[n][m];
        boolean[][] visitedAtlantic = new boolean[n][m];

        List<List<Integer>> result = new ArrayList<>();

        for (int y = 0; y < n; y++) {
            markReachableCell(y, 0, visitedPacific, heights);
            markReachableCell(y, m-1, visitedAtlantic, heights);
        }
        for (int x = 0; x < m; x++) {
            markReachableCell(0, x, visitedPacific, heights);
            markReachableCell(n-1, x, visitedAtlantic, heights);
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (visitedPacific[y][x] && visitedAtlantic[y][x]) {
                    result.add(Arrays.asList(y, x));
                }
            }
        }

        return result;
    }

    private void markReachableCell(int y, int x, boolean[][] visited, int[][] heights) {
        visited[y][x] = true;

        for(int[] dir : directions) {
            int newY = y + dir[0];
            int newX = x + dir[1];

            boolean isOutOfBounds = !(0 <= newY && newY < heights.length && 0 <= newX && newX < heights[0].length);
            if (isOutOfBounds || heights[y][x] > heights[newY][newX] || visited[newY][newX]) {
                continue;
            }
            
            markReachableCell(newY, newX, visited, heights);
        }
    }
}
