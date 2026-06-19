class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char val = board[i][j];
                if (val == '.')
                    continue;
                StringBuilder row = new StringBuilder();
                StringBuilder col = new StringBuilder();
                StringBuilder box = new StringBuilder();

                String rowkey = row.append("row").append(i).append("-").append(val).toString();
                String colkey = col.append("col").append(j).append("-").append(val).toString();
                String boxKey = box.append("box")
                                    .append((i / 3) * 3 + (j / 3))
                                    .append("-")
                                    .append(val)
                                    .toString();
                if (!seen.add(rowkey) || !seen.add(colkey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}
