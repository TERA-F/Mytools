public class Solution {
    public int firstUniqChar(String s) {
        if(s.length()==0)return -1;
        int[] p = new int[26];
        int[] n = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            n[s.charAt(i)-'a']++;
            if( n[s.charAt(i)-'a'] == 1 )
                p[s.charAt(i)-'a'] = i;
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0 ; i < 26 ; i++){
            if( n[i]==1)
                ret = Math.min(ret,p[i]);
        }
        return ret == Integer.MAX_VALUE ? -1:ret;
    }
}
