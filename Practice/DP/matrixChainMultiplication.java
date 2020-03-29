package DP;

public class matrixChainMultiplication {
    static int multiplier(int p[], int n) {
        int m[][] = new int[n][n];
        int i, j, k, L, q;
        for (i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (L = 2; L < n; L++) { // length of matrices multiplying at a point
            for (i = 1; i < n-L+1; i++) { // iteration on rows
                j = i+L-1;
                if(j == n ) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j-1; k++) { // breaking up at a point
                    q = m[i][k] + m[k+1][j] + (p[i-1] * p[j] * p[k]);
                    if ( q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
        return m[1][n-1];
    }
    public static void main(String args[]) {
        int[] p = {10, 20, 30, 40, 50};
        int size = p.length;
        System.out.println("Minimum number of multiplications required to multiply for given matrices is " + multiplier(p, size));
    }
}
