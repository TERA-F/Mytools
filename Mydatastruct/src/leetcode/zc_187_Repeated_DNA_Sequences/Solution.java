public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> diff = new HashSet<String>();
        HashSet<String> com = new HashSet<String>();
        for(int i = 0; i + 9 < s.length() ; ++i){
            String tmp = s.substring(i,i+10);
            if(!diff.add(tmp))
                com.add(tmp);
        }
        return new ArrayList<String>(com);
    }
}
