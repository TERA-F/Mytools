public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> begin = new HashSet<String>();
        HashSet<String> end = new HashSet<String>();
        HashSet<String> visited = new HashSet<String>();
        
        begin.add(beginWord);
        end.add(endWord);
        int len = 1;
        
        while(!begin.isEmpty() && !end.isEmpty()){
            if(begin.size()>end.size()){
                HashSet<String> set = begin;
                begin = end;
                end = set;
            }
            
            HashSet<String> tmp = new HashSet<String>();
            for(String s : begin){
                char[] chs = s.toCharArray();
                
                for(int i = 0 ; i < chs.length ; i++)
                    for(char c = 'a' ; c <= 'z'; c++){
                        char old = chs[i];
                        chs[i] = c;
                        
                        String teststr = String.valueOf(chs);
                        if(end.contains(teststr)){
                            return len+1;
                        }
                        
                        if( !visited.contains(teststr) && wordList.contains(teststr)){
                            tmp.add(teststr);
                            visited.add(teststr);
                        }
                        chs[i] = old;
                    }
            }
            begin = tmp;
            len++;
        }
        return 0;
    }
}
