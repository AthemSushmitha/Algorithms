public class LongestCommonSubsequence {
    public static void main( String args[]) {
        String s1 = 'ACBAE'
        String s2 = 'BE'
        s1Char[] = s1.toCharArray(); 
        s2Char[] = s2.toCharArray();
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("Lenght of longest common subsequence is" + lcs.lcs(s1Char, s2Char));
    }
    
    int lcs(char[] s1, char[] s2) {
        int m = s1.length;
        int n = s2.length;
        int lcs[][] = new int[m+1][n+1];
        for (int i =0 ; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if ( i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (s1[i-1] == s2[j-1]) 
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                else 
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
           }
       }
       return lcs[m][n];
    }