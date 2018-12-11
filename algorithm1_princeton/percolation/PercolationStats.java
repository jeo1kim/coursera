import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {

    private static final double confidence = 1.96;
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("size or trials must be positive integer");
        }

        double[] runs = new double[trials];
        int totalSites = n*n;

        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                }
            }
            runs[i] = ((double) perc.numberOfOpenSites())/totalSites;

        }
        this.mean = StdStats.mean(runs);
        this.stddev = StdStats.stddev(runs);
        this.confidenceLo = this.mean - ((confidence * this.stddev)/Math.sqrt(trials));
        this.confidenceHi = this.mean + ((confidence * this.stddev)/Math.sqrt(trials));
    }    // perform trials independent experiments on an n-by-n

    public double mean() {
        return this.mean;
    }                    // sample mean of percolation threshold
    public double stddev() {
        return this.stddev;
    }                       // sample standard deviation of percolation threshold
    public double confidenceLo() {
        return this.confidenceLo;
    }                  // low  endpoint of 95% confidence interval
    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return this.confidenceHi;
    }
    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        // int t = Integer.parseInt(args[1]);

//        Stopwatch stopwatch = new Stopwatch();
//         PercolationStats percStats = new PercolationStats(n, t);
//        // double elapsedTime = stopwatch.elapsedTime();
//        for(int i = 0; i < 10; i++){
//            System.out.println(percStats.confidenceHi());
//        }
        // System.out.println("mean                    = " + percStats.mean());
        // System.out.println("stddev                  = " + percStats.stddev());
        // System.out.println("95% confidence interval = [" + percStats.confidenceLo()+", "+percStats.confidenceHi()+"]");
        // System.out.println("elapsed time            = "+ elapsedTime);
    }
}
