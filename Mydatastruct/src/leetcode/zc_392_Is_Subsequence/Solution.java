public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null || s.length()<1) return true;
        if(t==null || s.length()>t.length()) return false;
        for(int i = 0,j = 0 ; i<s.length() && j<t.length();){
            if(s.charAt(i) == t.charAt(j)) i++;
            j++;
            // System.out.println(i+"  "+j);
            if(i==s.length()) return true;
        }
        return false;
    }
}
