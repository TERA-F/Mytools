public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0 ,maxcount = 0, maxlen = 0;
        for(int end = 0 ; end < s.length() ; end++){
            maxcount = Math.max(maxcount, ++count[s.charAt(end)-'A']);
            while(end - start + 1 > maxcount + k){
                count[s.charAt(start)-'A']--;
                start++;
            }
            maxlen = Math.max(maxlen,end - start +1);
        }
        return maxlen;
    }
}
