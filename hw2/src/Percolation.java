import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private WeightedQuickUnionUF uf;
    private final int N;
    private boolean[][] sites;

    public Percolation(int N) {
        this.uf = new WeightedQuickUnionUF(N * N + 2);
        this.N = N;
        this.sites = new boolean[N][N];
    }

    public void open(int row, int col) {
        if (!sites[row][col]) {
            sites[row][col] =  true;
            if (row == 0) {
                uf.union(0, col + 1);
                if (row == N-1) {
                    uf.union(N * N + 1, col + 1);
                }
                if (col > 0 && col < N - 1) {
                    if (sites[row][col - 1]) {
                        uf.union(col + 1,  col);
                    }
                    if (col + 1 < N && sites[row][col + 1]) {
                        uf.union(col + 1, col + 2);
                    }
                    if (row + 1 < N && sites[row + 1][col]) {
                        uf.union(col + 1, N + col + 1);
                    }
                }
                else if (col == 0) {
                    if (col + 1 < N && sites[row][col + 1]) {
                        uf.union(col + 1,col + 2);
                    }
                    if (row + 1 < N && sites[row + 1][col]) {
                        uf.union(col + 1, N + col + 1);
                    }
                }
                else {
                    if (sites[row][col - 1]) {
                        uf.union(col + 1, col);
                    }
                    if (row + 1 < N && sites[row + 1][col]) {
                        uf.union(col + 1, N + col + 1);
                    }
                }
            }
            else if (row == N - 1) {
                uf.union(N * N + 1, row * N + col + 1);
                if (col > 0 && col < N - 1) {
                    if (sites[row][col - 1]) {
                        uf.union(row * N + col + 1, row * N + col);
                    }
                    if (col + 1 < N && sites[row][col + 1]) {
                        uf.union(row * N + col + 1, row * N + col + 2);
                    }
                    if (sites[row - 1][col]) {
                        uf.union(row * N + col + 1, (row - 1) * N + col + 1);
                    }
                }
                else if (col == 0) {
                    if (col + 1 < N && sites[row][col + 1]) {
                        uf.union(row * N + col + 1, row * N + col + 2);
                    }
                    if (sites[row - 1][col]) {
                        uf.union(row * N + col + 1, (row - 1) * N + col + 1);
                    }
                }
                else {
                    if (sites[row][col - 1]) {
                        uf.union(row * N + col + 1, row * N + col);
                    }
                    if (sites[row - 1][col]) {
                        uf.union(row * N + col + 1, (row - 1) * N + col + 1);
                    }
                }
            }
            else {
                if (col > 0 && col < N - 1) {
                    if (sites[row][col - 1]) {
                        uf.union(row * N + col + 1, row * N + col);
                    }
                    if (col + 1 < N &&sites[row][col + 1]) {
                        uf.union(row * N + col + 1, row * N + col + 2);
                    }
                    if (sites[row - 1][col]) {
                        uf.union(row * N + col + 1, (row - 1) * N + col + 1);
                    }
                    if (row + 1 < N && sites[row + 1][col]) {
                        uf.union(row * N + col + 1, (row + 1) * N + col + 1);
                    }
                }
                else if (col == 0) {
                    if (col + 1 < N && sites[row][col + 1]) {
                        uf.union(row * N + col + 1, row * N + col + 2);
                    }
                    if (sites[row - 1][col]) {
                        uf.union(row * N + col + 1, (row - 1) * N + col + 1);
                    }
                    if (row + 1 < N && sites[row + 1][col]) {
                        uf.union(row * N + col + 1, (row + 1) * N + col + 1);
                    }
                }
                else {
                    if (sites[row][col - 1]) {
                        uf.union(row * N + col + 1, row * N + col);
                    }
                    if (sites[row - 1][col]) {
                        uf.union(row * N + col + 1, (row - 1) * N + col + 1);
                    }
                    if (row + 1 < N && sites[row + 1][col]) {
                        uf.union(row * N + col + 1, (row + 1) * N + col + 1);
                    }
                }
            }
        }
    }

    public boolean isOpen(int row, int col) {
        return sites[row][col];
    }

    public boolean isFull(int row, int col) {
        return uf.connected(row * N + col + 1, 0);
    }

    public int numberOfOpenSites() {
        int cumulation = 0;
        for (boolean[] rowArray : sites) {
            for (boolean value : rowArray) {
                if (value) {
                    cumulation++;
                }
            }
        }
        return cumulation;
    }

    public boolean percolates() {
        return uf.connected(N * N + 1, 0);
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.

}
