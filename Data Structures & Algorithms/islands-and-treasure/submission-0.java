class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        List<int[]> treasures = new ArrayList<>();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 0) {
                    treasures.add(new int[] {y, x});
                }
            }
        }
        
        bfs(treasures, grid);
    }

    private void bfs(List<int[]> treasures, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int[] t : treasures) {
            queue.offer(t);
            grid[t[0]][t[1]] = Integer.MAX_VALUE;
        }
        
        int distance = 0;

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();

            for (int i = 0; i < nodeCount; i++) {
                int[] curr = queue.poll();
                int y = curr[0];
                int x = curr[1];

                if (grid[y][x] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[y][x] = distance;

                for (int[] dir : directions) {
                    int newY = y + dir[0];
                    int newX = x + dir[1];
                    
                    if (!(0 <= newY && newY < grid.length
                        && 0 <= newX && newX < grid[0].length)) {
                        continue;
                    }

                    queue.offer(new int[] {newY, newX});
                }
            }

            distance++;
        }
    }
}
