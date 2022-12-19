import java.util.Arrays;

public class PercolationDFSFast extends PercolationDFS {
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n
     *            is the size of the simulated (square) grid
     */
    public PercolationDFSFast(int n) {
        super(n);
    }

    @Override
    protected void updateOnOpen(int row, int col) {
        if (row == 0){
            myGrid[row][col] = FULL;
        }
        if (row>0 && isFull(row - 1,col)){
            myGrid[row][col] = FULL;
        }
        if (col>0 && isFull(row,col-1)){
            myGrid[row][col]=FULL;
        }
        if (col<myGrid[0].length-1 && isFull(row,col+1)){
            myGrid[row][col]=FULL;
        }
        if (row<myGrid.length-1 && isFull(row + 1,col)){
            myGrid[row][col]=FULL;
        }
        if (myGrid[row][col]==FULL){
            myGrid[row][col] = OPEN;
            dfs(row, col);
        }
    }
}
