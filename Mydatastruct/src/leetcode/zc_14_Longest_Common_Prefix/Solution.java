public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs[0].length()==0) return "";
        if(strs.length==1) return strs[0];
        
        int p = strs[0].length() - 1;
        
        for(int i = 1; i < strs.length;i++){
            int q = 0;
            while(q < strs[i].length() && q < strs[0].length() && strs[0].charAt(q) == strs[i].charAt(q)) q++;
            p = Math.min(p,q-1);
            if(p==-1) return "";
        }
        
        return strs[0].substring(0,p+1);
    }
}
