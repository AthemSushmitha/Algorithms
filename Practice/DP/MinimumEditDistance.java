public class MinimumEditDistance {
    publc static void main(String args[]) {
        String s1 = 'azced';
        String s2 = 'abcdef';
        MinimumEditDistance m = new MinimumEditDistance();
        System.out.println("Minimum edit distance for given two strings is"+ m.getEditDistance());
    }
    int getEditDistance(String s1, String s2) {
        int dp[][] = new int[s1.length+1][s2.length+1];
        for(int i = 0; i <= dp[0].length; i++) {
            dp[0][i] = i;
        }
        for(int j = 0; j <= dp.length; j++) {
            dp[j][0] = j;
        }
        for(int i =0; i < s1.length+1; i++) {
            for(int j = 0; j < s2.length + 1; j++) {
                if(dp[i] == dp[j]) 
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = min(1+dp[i-1][j-1],1+dp[i][j-1], 1+ dp[i-1][j]);
            }
        }
        return dp[s1.length][s2.length];
    }
}