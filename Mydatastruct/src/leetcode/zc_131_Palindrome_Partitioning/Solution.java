public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret  = new ArrayList<List<String>>();
        if(s == null || s.length() < 1 ) return ret;
        helper(ret,new ArrayList<String>(),s);
        return ret;
    }
    
    private void helper(List<List<String>> ret, ArrayList<String> list, String s){
        if(s.equals("")){
            ret.add(new ArrayList<String>(list));
            return ;
        }
        
        for(int i = 1 ; i <= s.length() ; i++){
            if(isPalindrome(s.substring(0,i))){
                list.add(s.substring(0,i));
                helper(ret,list,s.substring(i));
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        for(int i = 0, j = s.length()-1 ; i < j ; i++,j--)
            if(s.charAt(i)!= s.charAt(j)) return false;
        return true;
    }
}
