import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private final int CLOSED_SITE = 0;
    private final int OPEN_SITE = 1;
    private final int FULL_SITE = 2;

    private boolean[][] sites;
    private final int open;
    private final int n;
    private final WeightedQuickUnionUF wquf;
    private int count;
    private final int virtualBot;
    private int[][] site2;

    public Percolation(int n) {                // create n-by-n grid, with all sites blocked
        if (n <= 0) {
            throw new IllegalArgumentException("cant be less than 0");
        }
        sites = new boolean[n][n];
        site2 = new int[n][n];
        wquf = new WeightedQuickUnionUF(n*n + 2);
        open = n*n;
        virtualBot = n*n+1;
        this.n = n;
        count = 0;
    }

    public void open(int row, int col) {
        checkException(row, col);
        if (isOpen(row, col)) {
            return;
        }
        int site = convertPosition(row, col);
        sites[row - 1][col - 1] = true;
        site2[row-1][col-1] = OPEN_SITE;
        if (row == n){
            wquf.union(virtualBot, site);
        }
        if (row == 1) {
            site2[row-1][col-1] = FULL_SITE;
            wquf.union(open, site);
        }

        checkBound(row, col);
        count++;
    }   // open site (row, col) if it is not open already

    private int convertPosition(int row, int col) {
        int site = n*(row-1) + (col-1);
        return site;
    }

    public boolean isOpen(int row, int col) {
        checkException(row, col);
        return sites[row-1][col-1];
    }  // is site (row, col) open?

    public boolean isFull(int row, int col) {
        checkException(row, col);
        int site = convertPosition(row, col);
        return  wquf.connected(open, site); //sites[row-1][col-1] == FULL_SITE;
    } // is site (row, col) full?

    private void checkException(int row, int col) {
        if (row < 1 || col < 1 || row > sites[0].length || col > sites.length) {
            throw new IllegalArgumentException("index out of bound");
        }
    }

    private boolean checkSite(int row, int col) {

        if (site2[row][col] == FULL_SITE) {
            return true;
        }
        return false;
    }

    private void checkBound(int row, int col) {
        int p = convertPosition(row, col);

        if (col-1 >= 1) {     // check left
            int q = convertPosition(row, col-1);
            if (sites[row-1][col-2]  || wquf.connected(q, open)) {
                wquf.union(p, q);
            }
        }
        if (row-1 >= 1) {   // check top
            int q = convertPosition(row-1, col);
            if (sites[row-2][col-1]  || wquf.connected(q, open)) {
                wquf.union(p, q);
            }
        }
        if (col < n) { // check right
            int q = convertPosition(row, col+1);
            if (sites[row-1][col] || wquf.connected(q, open)) {
                wquf.union(p, q);
            }
        }
        if (row < n) { // check bottom
            int q = convertPosition(row+1, col);
            if (sites[row][col-1]  || wquf.connected(q, open)) {
                wquf.union(p, q);
            }
        }
    }

    public int numberOfOpenSites() {
        return count;
    }       // number of open sites


    public boolean percolates() {
        return wquf.connected(open, virtualBot); //false;
    }              // does the system percolate?

    public static void main(String[] args) {

        System.out.println("Starting Percolation");
    }   // test client (optional)
}
