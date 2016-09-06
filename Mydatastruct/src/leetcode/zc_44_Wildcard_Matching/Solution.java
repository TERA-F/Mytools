public class Solution {
    public boolean isMatch(String s, String p) {
        int ps = 0,pp = 0,match = 0 , laststar = -1;
        while(ps < s.length()){
            if( pp < p.length() && (p.charAt(pp)==s.charAt(ps) || p.charAt(pp) == '?')){
                ps++;
                pp++;
            }else if(pp < p.length() && p.charAt(pp) =='*'){
                match = ps;
                laststar = pp;
                pp++;
            }else if(laststar != -1){
                pp = laststar+1;
                match++;
                ps = match;
            }else
                return false;
        }
        
        while(pp<p.length() && p.charAt(pp)=='*')
        pp++;
        
        return pp == p.length();
    }
}
