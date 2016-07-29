public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
/*        List<List<String>> ret = new ArrayList<>();
        if(strs.length<1) return ret;
        
        HashMap<char[],Integer> hash = new HashMap<char[],Integer>();
        int group = 0;
        boolean flag = false;
        
        for(int i = 0 ; i < strs.length;++i){
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            flag = true;
            for(char[] x : hash.keySet()){
                if( x == tmp ){
                    ArrayList ref = ret.get(hash.get(x));//can't make this line.
                    ret.add(strs[i]);
                    flag = false;
                    break;
                }
            }
            if(flag){
                ArrayList<String> addition = new ArrayList<String>(strs[i]);
                ret.add(addition);
                hash.put(tmp,group++);
            }
        }
        return ret;
*/
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
