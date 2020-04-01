/******************************************************************************
 *  Author:       Athem Sushmitha
 *  Compilation:  javac MatrixChainMultiplication.java
 *  Execution:    java MatrixChainMultiplication
 *  References:   https://www.youtube.com/watch?v=prx1psByp7U https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 *
 *  Matrix chain algorithm. Find minimum number of multiplications required to get given matrices multiplied using Dynamic programming
 *  (optimal substructure and overlapping sub-problems [bottom up approach])
 *
 *  % i/p:  {10, 20, 30, 40, 50}
 *  o/p:
 *  [[0, 0, 0, 0, 0], [0, 0, 1, 2, 3], [0, 0, 0, 2, 3], [0, 0, 0, 0, 3], [0, 0, 0, 0, 0]]
 *  Minimum number of multiplications required to multiply for given matrices is 38000
 *
 *  % i/p:  {1, 5, 3, 9, 5}
 *  o/p:
 *  [[0, 0, 0, 0, 0], [0, 0, 1, 2, 3], [0, 0, 0, 2, 3], [0, 0, 0, 0, 3], [0, 0, 0, 0, 0]]
 *  Minimum number of multiplications required to multiply for given matrices is 87
 *
 ******************************************************************************/

package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/*
    *  The {@code MatrixChainMultiplication} class provides a client for multiplying
    *  given matrices and displaying the minimum number of multiplications required and best approach to multiply.
    *  Following are few key points:
        * Any two matrices can be multiplied only if number of columns in first matrix is equal to number of rows in second matrix
        * For multiplying any two matrices we have 3 dimensions 1. Rows in first matrix(d0) 2. Columns in first matrix and
            rows in second matrix (d1) and 3. Columns in second matrix(d2).
        * Number of multiplications required for multiplying any 2 matrices is d0 * d1 * d2
            (OR) Number of multiplications required for each element X Number of elements in resultant matrix
        * For given matrices how many parenthesis are possible? (How many Binary trees are possible for given N nodes)
            = 2NCn / N+1
    Time complexity: O(N^3)
        * Total elements we are filling in temporarily stored table = sum of num elements = N(N+1)/2
        * Number of mid points taken to multiply.. let's say N
     O(N(N+1)/2) * N) = O(N^3)
*/

public class MatrixChainMultiplication {
    /* Function to multiply given list of matrices. This function takes two parameters
         1) Array with sizes of matrices
         2) Number of matrices to multiply
     */
    static int multiplier(int p[], int n) {
        int temp[][] = new int[n][n];
        int order[][] = new int[n][n];
        int row, col, mid, len, res;
        for (row = 1; row < n; row++) // fills temp[][] diagonal with zeros from row 1
            temp[row][row] = 0;

        for (len = 2; len < n; len++) { // length of matrices multiplying at a point
            for (row = 1; row < n-len+1; row++) { // iteration on rows
                col = row+len-1;
                if(col == n ) continue;
                temp[row][col] = Integer.MAX_VALUE;
                for (mid = row; mid <= col-1; mid++) { // breaking up at a point
                    res = temp[row][mid] + temp[mid+1][col] + (p[row-1] * p[col] * p[mid]);
                    if ( res < temp[row][col]) // comparing res with prev point and updating with min value
                        temp[row][col] = res;
                        order[row][col] = mid;
                }
            }
        }
        System.out.println(Arrays.deepToString(order));
        System.out.println(Arrays.deepToString(temp));
        return temp[1][n-1];
    }

    private static int[] calculateSizes(int[][][] matrices, int count) {
        int sizes[] = new int[count+1];
        for(int i=0; i <= count; i++) {
            int j = 0;
            if (i == 0)
                sizes[i] = matrices[i].length;
            else if (i == count)
                sizes[i] = matrices[i-1][j].length;
            else if( ( i > 0 && i < count)) {
                if (matrices[i-1][j].length == matrices[i].length)
                    sizes[i] = matrices[i].length;
                else {
                    System.out.println("Given sequence of matrices can't be multiplied as their columns and rows are not matching");
                    return null;
                }
            }
        }
        return sizes;
    }

    public static void main(String args[]) {
        int[][][] matrices = { { {3,5,9,10},
                                 {8,3,2,12},
                                 {4,5,21,9}
                                },
                                { {1},
                                  {2},
                                  {3},
                                  {4}
                                },
                                { {1,2,3}
                                },
                                { {45,67,9},
                                  {6,8,10},
                                  {24,64,90}
                                }
                             };
        int count = matrices.length;

        int sizes[] = calculateSizes(matrices, count);
        if(sizes == null) {
            System.out.println("Can't multiply given matrices as their sizes don't match");
        }
        else{
            System.out.println("Sizes of given sequence of arrays in 2 dimensions is " + Arrays.toString(sizes));
            System.out.println("Minimum number of multiplications required to multiply for given matrices is " + multiplier(sizes, sizes.length));
        }
    }
}
