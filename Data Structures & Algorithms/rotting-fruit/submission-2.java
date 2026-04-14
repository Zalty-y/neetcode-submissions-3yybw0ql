class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int freshFruit = 0;

    public int orangesRotting(int[][] grid) {
        List<int[]> rottenCoords = new ArrayList<>();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 0) {
                    continue;
                }
                if (grid[y][x] == 2) {
                    rottenCoords.add(new int[] {y, x});
                    grid[y][x] = 1;
                }
                freshFruit++;
            }
        }

        int result = bfs(rottenCoords, grid);

        return freshFruit == 0 ? result : -1;
    }

    private int bfs(List<int[]> rottenCoords, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>(rottenCoords);

        int minutes = 0;
        while (!queue.isEmpty()) {
            int waveSize = queue.size();

            for (int i = 0; i < waveSize; i++) {
                int[] current = queue.poll();
                int y = current[0];
                int x = current[1];

                if (grid[y][x] != 1) {
                    continue;
                }

                grid[y][x] = 2;
                freshFruit--;

                for (int[] dir : directions) {
                    int newY = y + dir[0];
                    int newX = x + dir[1];
                    
                    boolean isOutOfBounds = !(0 <= newY && newY < grid.length && 0 <= newX && newX < grid[0].length);
                    if (isOutOfBounds) {
                        continue;
                    }
                    
                    queue.offer(new int[] {newY, newX});
                }
            }

            if (freshFruit > 0) {
                minutes++;
            }
        }

        return minutes;
    }
}
