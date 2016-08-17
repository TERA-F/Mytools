public class Solution {
    public int strStr(String haystack, String needle) {
        int m = 0;
        int n = 0;
        if( (n = needle.length())==0 ) return 0;
        if( (m = haystack.length())==0) return -1; 
        char [] h = haystack.toCharArray();
        char [] d = needle.toCharArray();
        for(int i = 0; i <= m-n ; i++){
            if( h[i] == d[0]){
                int j = 1, k = 1;
                System.out.println("i:"+i+"j:"+j+"k:"+k);
                for(; ((i+j)<m) &&(k<n) ; ++j,++k){
                    if(h[i+j]!=d[k]) break;
                }
                if(k == n) return i;
            }
        }
        return -1;
    }
}
