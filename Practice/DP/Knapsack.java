public class Knapsack {
    publc static void main (String args[]) {
        Knapsack k = new Knapsack();
        int weights[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int values[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int W = 30;
        Knapsack.sol(weights,values,W);
    }
    public int sol(int[] wt, int[] values, int W) {
        int k[][] = new int[values.length + 1][W+1];
        for( i = 0; i <= values.length; i++) {
            for( j = 0; j <= W; j++) {
                if(i ==0 || j ==0)
                    k[i][j] = 0;
                    continue;
                if(j - wt[i-1] >= 0 ) 
                    k[i][j] = Math.max(val[i-1] + k[i-1][j-wt[i-1]], k[i-1][j])
                else    
                    k[i][j] = k[i-1][j];
            }
        }
        return k[val.length][W];
    }
} 