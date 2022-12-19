
public class PercolationUF implements IPercolate{
    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    public PercolationUF (IUnionFind finder, int size){
        myGrid = new boolean [size][size];

        finder.initialize(size * size + 2);
        myFinder = finder;

        VTOP = size*size;
        VBOTTOM = size*size+1;
        myOpenCount = 0;
    }

    /**
     * Returns true if and only if site (row, col) is OPEN
     *
     * @param row row index in range [0,N-1]
     * @param col column index in range [0,N-1]
     */
    @Override
    public  boolean isOpen(int row, int col){
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
        }
        return myGrid[row][col];
    }

    protected boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }

    @Override
    public boolean isFull(int row, int col) {

        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        int index = row*myGrid.length + col;
        return myFinder.connected(index, VTOP);
    }

    @Override
    public boolean percolates() {
            return myFinder.connected(VTOP, VBOTTOM);

    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }

    @Override
    public void open(int row, int col){
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }

        if (myGrid[row][col]){
            return;
        }
        myGrid[row][col] = true;
        myOpenCount+=1;

        if (row == 0) {
            myFinder.union(index(row, col), VTOP);
        }
        if (inBounds(row-1,col) && isOpen(row-1, col)) {
            myFinder.union(index(row,col), index(row-1,col));
        }
        if (inBounds(row+1,col) && isOpen(row+1, col)) {
            myFinder.union(index(row,col), index(row+1,col));
        }
        if (inBounds(row,col - 1) && isOpen(row, col-1)) {
            myFinder.union(index(row,col), index(row,col-1));
        }
        if (inBounds(row,col+ 1) && isOpen(row, col+1)) {
            myFinder.union(index(row,col), index(row,col+1));
        }
        if (row==myGrid.length-1){
            myFinder.union(index(row,col), VBOTTOM);
        }
    }

    public int index (int row, int col){
        return (row*myGrid.length) + col;

}

}
