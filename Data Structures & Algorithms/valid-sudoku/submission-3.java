class Solution {
    private static final char EMPTY = '.';

    public boolean isValidSudoku(char[][] board) {
        int n = board[0].length;
        int nSqrt = (int)Math.sqrt((double)n);

        Set<Character>[] columns = new HashSet[n];
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            columns[i] = new HashSet<Character>();
            rows[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                char field = board[y][x];
                if (field == EMPTY) {
                    continue;
                }
                int boxIndex = x / nSqrt + (y / nSqrt) * nSqrt;

                if (columns[y].add(field) &&
                    rows[x].add(field) &&
                    boxes[boxIndex].add(field)) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
