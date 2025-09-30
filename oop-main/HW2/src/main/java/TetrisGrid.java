//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class TetrisGrid {

    private boolean[][] grid;
    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid copy
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int x = grid.length;
        int y = grid[0].length;
        System.out.println(x + " " + y);
        Boolean check = false;


        for (int j = y - 1; j >= 0; j--) {
            int flag = 0;
            for (int i = 0; i < x; i++) {
                if (!grid[i][j]) {
                    break;
                } else if (i == x - 1 && grid[i][j]){
                    check = true;
                    flag = j;
                }
            }
            if (check) {
                if (flag == y - 1) {
                    System.out.println("Vao y - 1");
                    for (int i = 0; i < x; i++) {
                        grid[i][flag] = false;
                    }
                } else {
                    System.out.println("Vao else");
                    for (int k = flag; k < y - 1; k++) {
                        for (int i = 0; i < x; i++) {
                            grid[i][k] = grid[i][k + 1];
                        }
                    }
                    for (int i = 0; i < x; i++) {
                        grid[i][y - 1] = false;
                    }
                }
                check = false;
                j++;
            }
        }

    }

    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    public boolean[][] getGrid() {
        return this.grid ; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        boolean[][] grid = new boolean[][]{
                {true, true, false, },
                {false, true, true, }



        };
        TetrisGrid tetrisGrid = new TetrisGrid(grid);
        tetrisGrid.clearRows();
        System.out.println(tetrisGrid.getGrid());

    }
}
