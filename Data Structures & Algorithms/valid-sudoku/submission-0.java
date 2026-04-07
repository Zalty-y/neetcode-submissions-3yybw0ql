class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<Character>[] rows = new Set[n];
        Set<Character>[] columns = new Set[n];
        Set<Character>[] boxes = new Set[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char cell = board[row][col];
                if (cell == '.') {
                    continue;
                }

                int boxIndex = (row / 3) * 3 + col / 3;

                if (rows[row].contains(cell) || columns[col].contains(cell) || boxes[boxIndex].contains(cell)) {
                    return false;
                }

                rows[row].add(cell);
                columns[col].add(cell);
                boxes[boxIndex].add(cell);
            }
        }

        return true;
    }
}
