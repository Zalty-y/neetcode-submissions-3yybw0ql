class Solution {
    private final static char EMPTY = '.';

    public boolean isValidSudoku(char[][] board) {
        int n = board[0].length;
        Set<Character>[] boxes = new HashSet[n];
        Set<Character>[] columns = new HashSet[n];
        Set<Character>[] rows = new HashSet[n];

        for (int i = 0; i < n; i++) {
            boxes[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            rows[i] = new HashSet<>();
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                char field = board[y][x];
                if (field == EMPTY) {
                    continue;
                }
                
                int box = x / 3 + (y / 3) * 3;
                boolean anyDuplicate = boxes[box].contains(field)
                    || columns[x].contains(field)
                    || rows[y].contains(field);

                if (anyDuplicate) {
                    return false;
                }

                boxes[box].add(field);
                columns[x].add(field);
                rows[y].add(field);
            }
        }

        return true;
    }
}
