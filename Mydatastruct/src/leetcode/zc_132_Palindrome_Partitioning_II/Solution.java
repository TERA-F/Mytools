public class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int[] cut = new int[n];
        for(int i = 0 ; i < n ; i++){
            int min = i;
            for(int j = 0 ; j <= i ; j++){
                if(c[i]==c[j] && (j + 1 > i - 1 || pal[j+1][i-1])){
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(cut[j-1]+1,min);
                }
            }
            cut[i] = min;
        }
        return cut[n-1];
    }
}
