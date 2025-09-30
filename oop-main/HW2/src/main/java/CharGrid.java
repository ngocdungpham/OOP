// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import java.sql.SQLOutput;
import java.util.ArrayList;

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid huhu
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int area;
        int minRow = 100;
        int maxRow = 0;
        int minCol = 100;
        int maxCol = 0;
        Boolean checked = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ch) {
                    checked = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        if (!checked) {
            return 0;
        }
        area = (maxRow - minRow + 1) * (maxCol - minCol + 1);
        return area;
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    public int countPlus() {
        int m = grid.length;
        int n = grid[0].length;
        int[][] left =  new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];

        // left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    left[i][j] = left[i][ j - 1] + 1;
                } else {
                    left[i][j] = 0;
                }
            }
        }

        // right
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j < n - 1 && grid[i][j] == grid[i][j + 1]) {
                    right[i][j] = right[i][j + 1] + 1;
                } else {
                    right[i][j] = 0;
                }
            }
        }

        // up
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                    up[i][j] = up[i - 1][j] + 1;
                } else {
                    up[i][j] = 0;
                }
            }
        }

        // down
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (i < m - 1 && grid[i][j] == grid[i + 1][j]) {
                    down[i][j] = down[i + 1][j] + 1;
                } else {
                    down[i][j] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (left[i][j] == up[i][j] && right[i][j] == down[i][j] && left[i][j] == down[i][j] && left[i][j] >= 1) {
                    count++;
                }
            }
        }
        return count; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                "  p      ".toCharArray(),
                "  p    x ".toCharArray(),
                "ppppp xxx".toCharArray(),
                "  p  y x ".toCharArray(),
                "  p yyy  ".toCharArray(),
                "zzzzzyzzz".toCharArray(),
                "  xx y   ".toCharArray()
        };
        CharGrid charGrid = new CharGrid(grid);
        System.out.println(charGrid.countPlus());

    }
}
