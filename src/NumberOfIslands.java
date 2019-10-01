/**
 * #200 Number of Islands https://leetcode.com/problems/number-of-islands/
 * Basic idea:
 * 1) Find an island
 * 2) Eliminate the island (via expansion)
 * 3) Repeat
 * 1ms/40.8MB (Beats 100.00%/92.56%)
 */

public class NumberOfIslands {
    static int n, m;

    public static int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n < 1) return 0;
        m = grid[0].length;
        if (m < 1) return 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    eliminateIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void eliminateIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;

        grid[i][j] = '0';

        eliminateIsland(grid, i + 1, j);
        eliminateIsland(grid, i - 1, j);
        eliminateIsland(grid, i, j + 1);
        eliminateIsland(grid, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] island1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] island2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(island1));
        System.out.println(numIslands(island2));
    }
}
