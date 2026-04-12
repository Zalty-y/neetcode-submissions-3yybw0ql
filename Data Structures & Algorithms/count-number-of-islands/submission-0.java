class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] != '1') {
                    continue;
                }
                dfs(grid, y, x);
                result++;
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int y, int x) {
        boolean isOutOfBounds = !(y >= 0 && y < grid.length && x >= 0 && x < grid[0].length);
        if (isOutOfBounds || grid[y][x] != '1') {
            return;
        }
        
        grid[y][x] = '0';
        dfs(grid, y-1, x);
        dfs(grid, y+1, x);
        dfs(grid, y, x-1);
        dfs(grid, y, x+1);
    }
}
