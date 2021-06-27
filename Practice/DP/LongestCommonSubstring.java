public class LongestCommonSubstring {
    public static void main(String args[]) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String s1  = 'abcdef';
        String s2 = 'zbcdfe';
        System.out.println('Longest common substring for given two strings is' + lcs.getLongestCommonSubstring(s1,s2));
    }
    int getLongestCommonSubstring(String s1, String s2) {
        int[][] tempArr = new [s1.length+1][s2.length+1];
        int max = 0;
        if (s1.length == 0 || s2.length == 0) {
            return 0;
        }
        for ( int i = 1; i < s1.length+1; i ++) {
            for (int j = 1; j < s2.length+1; j++) {
                if(s1[i=1] == s2[j-1]) {
                    tempArr[i][j] = 1 + tempArr[i-1][j-1];
                    if (max < tempArr[i][j]) 
                        max = tempArr[i][j];
                }
            }
        }
        return max;
    }
}