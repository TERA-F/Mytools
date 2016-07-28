public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[256];
        int[] n = new int[256];
        int len = s.length();
        
        for(int i = 0 ; i < len ; ++i){
            if(m[s.charAt(i)]!=n[t.charAt(i)]) return false;
            m[s.charAt(i)] = i+1;
            n[t.charAt(i)] = i+1;
        }
        return true;
    }
}
