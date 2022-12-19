import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n
     *            is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }

    @Override
    protected void dfs (int row, int col){

        int[] rowDelta= {-1, 1, 0, 0};
        int[] colDelta= {0, 0, -1, 1};

        // out of bounds?
        if (! inBounds(row,col)) return;

        // full or ! open, don't process
        if (isFull(row, col) || !isOpen(row, col))
            return;

        Queue<int[]> queue = new LinkedList<>();
        myGrid[row][col] = FULL;
        queue.add (new int[] {row, col});

        while (queue.size()!=0){
            int[] current = queue.remove();
            for (int k =0; k< rowDelta.length; k++){
                row = current[0] + rowDelta[k];
                col = current[1] + colDelta[k];

                if (inBounds(row,col) && isOpen (row, col) && !isFull(row, col)){
                    myGrid[row][col] = FULL;
                    queue.add(new int[] {row, col});
                }
            }
        }
    }
}
