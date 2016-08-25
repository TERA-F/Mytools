public class Solution {
    private final String[] key = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        char[] list = digits.toCharArray();
        helper(ret,list,0);
        return ret;
    }
    
    private void helper(List<String> ret, char[] list,int p){
        if(p == list.length) return;
        if(ret.size()==0){
            String tmp = key[list[p]-'0'];
            for(char x: tmp.toCharArray())
                ret.add(""+x);//ret.add(x.toString());//ret.add(new String(x));?
        }else{
            List<String> next = new ArrayList<String>();
            for(int i = 0; i < ret.size();i++){
                for(int j = 0 ; j < key[list[p]-'0'].length();j++){
                    String tmp = ret.get(i);
                    tmp += key[list[p]-'0'].charAt(j);
                    next.add(tmp);
                }
            }
            ret.clear();//ret = next;can't work
            ret.addAll(next);
        }
        helper(ret,list,p+1);
    }
}
