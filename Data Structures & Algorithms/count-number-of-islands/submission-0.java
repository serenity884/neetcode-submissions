class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    exploreIsland(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void exploreIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        exploreIsland(grid, i + 1, j);
        exploreIsland(grid, i - 1, j);
        exploreIsland(grid, i, j + 1);
        exploreIsland(grid, i, j - 1);
        return;
    }
}
