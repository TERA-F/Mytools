public class Solution {
/*    public int longestSubstring(String s, int k) {
        if(s.length()<k)return 0;
        int[] pos = new int[26];
        int[] count = new int[26];
        
        for(int i = 0 ; i < s.length() ; i++){
            count[s.charAt(i) - 'a']++;
            pos[s.charAt(i) - 'a'] = i;
        }
        
        int ret = 0;
        
        boolean flag = false;
        for(int i= 0 ; i < 26 ; i++ ){
            if(count[i] < k && count[i] > 0){
                flag = true;
                ret = Math.max(ret,longestSubstring(s.substring(0,pos[i]),k));
                ret = Math.max(ret,longestSubstring(s.substring(pos[i]+1),k));
            }
        }
        return flag ? ret : s.length();
    }*/
    // similar idea but TLE;
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str,0,s.length(),k);
    }
    private int helper(char[] str, int start, int end,  int k){
        if(end<start) return 0;
        if(end-start<k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for(int i = start;i<end;i++){
            int idx = str[i]-'a';
            count[idx]++;
        }
        for(int i = 0;i<26;i++){
            if(count[i]==0)continue;//i+'a' does not exist in the string, skip it.
            if(count[i]<k){
                for(int j = start;j<end;j++){
                    if(str[j]==i+'a'){
                        int left = helper(str,start,j,k);
                        int right = helper(str,j+1,end,k);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end-start;
    }
    
}
