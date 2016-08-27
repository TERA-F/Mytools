public class Solution {
public int minDistance(String word1, String word2) {
    if(word1==null || word1.length()==0)
        return word2.length();
    char []w1=word1.toCharArray();
    char []w2=word2.toCharArray();
    int dp[][]=new int [word1.length()+1][word2.length()+1];
    return minDist(w1,w2,dp,word1.length(),word2.length());
}

public int minDist(char []w1,char []w2,int [][]dp,int m,int n){
    if(m==0)
        return n;
    if(n==0)
        return m;
    if(dp[m][n]!=0)
        return dp[m][n];
    if(w1[m-1]==w2[n-1])
        return dp[m][n]=minDist(w1,w2,dp,m-1,n-1);
    return dp[m][n]=1+Math.min(minDist(w1,w2,dp,m,n-1), Math.min(minDist(w1,w2,dp,m-1,n),minDist(w1,w2,dp,m-1,n-1)));
}
}
