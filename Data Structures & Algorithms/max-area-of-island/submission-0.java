class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] != 1) {
                    continue;
                }

                result = Math.max(result, dfs(y, x, grid));
            }
        }

        return result;
    }

    private int dfs(int y, int x, int[][] grid) {
        boolean isOutOfBounds = !(0 <= y && y < grid.length && 0 <= x && x < grid[0].length);
        if (isOutOfBounds || grid[y][x] != 1) {
            return 0;
        }

        grid[y][x] = 0;
        
        int result = 1;
        result += dfs(y+1, x, grid);
        result += dfs(y-1, x, grid);
        result += dfs(y, x+1, grid);
        result += dfs(y, x-1, grid);
        return result;
    }
}
