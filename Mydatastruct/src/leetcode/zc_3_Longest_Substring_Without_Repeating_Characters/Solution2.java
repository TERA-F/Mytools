public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        char[] sc = s.toCharArray();
        int len = 0;
        for(int i = 0 ; i < sc.length ; ++i){
            int tmp = i;
            HashSet<Character> set = new HashSet<Character>();
            int tmplen = 0;
            while(tmp<sc.length){
                if(set.add(sc[tmp++])) ++tmplen;
                else break;
            }
            len = Math.max(len,tmplen);
        }
        return len;
    }
}
