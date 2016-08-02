public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        if(s==null || words.length<1 || words[0].length()<1) return ret;
        int len = words[0].length();
        
        HashMap<String,Integer> word = new HashMap<String,Integer>();
        for(String w:words)
            word.put(w,(word.containsKey(w)?word.get(w)+1:1));
            
        for(int i = 0 ; i <= s.length()-len*words.length;++i){
            HashMap<String,Integer> find = new HashMap<String,Integer>(word);
            for(int j = 0 ; j <words.length ; ++j){
                String tmp = s.substring(i+j*len,i+(j+1)*len);
                if(find.containsKey(tmp)){
                    int count = find.get(tmp);
                    if(count==1) find.remove(tmp);
                    else find.put(tmp,find.get(tmp)-1);
                    if(find.isEmpty()){
                        ret.add(i);
                        break;
                    }
                }else break;
            }
        }
        return ret;
    }
}
