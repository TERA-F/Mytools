public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int i = 0;
        Stack<String> sta = new Stack<String>();
        
        while( i < s.length() && !wordDict.isEmpty()){
            int lasti = i;
            for(String ss: wordDict){
                if(ss.charAt(0)==s.charAt(i)){
                    int tmp = i+1;
                    int j = 1;
                    while(tmp < s.length() && j < ss.length() && s.charAt(tmp)==ss.charAt(j)){
                        tmp++;
                        j++;
                    };
                    if(j == ss.length()){
                        if(tmp==s.length())
                            return true;
                        else{
                            i = tmp;
                            sta.add(ss);
                            continue;
                        }
                    }
                }
            }
            if(lasti == i){
                if(sta.isEmpty()) return false;
                String ss = sta.pop();
                i -= ss.length();
                wordDict.remove(ss);
            }
        }
        return false;
    }
    /*public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i=1; i<len+1; i++)
            for (int j=0; j<i; j++)
                if (f[j] && wordDict.contains(s.substring(j,i)))
                {
                    f[i] = true;
                    break;
                }
        return f[len];
    }*/
}
