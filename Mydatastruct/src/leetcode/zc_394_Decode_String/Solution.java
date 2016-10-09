public class Solution {
    public String decodeString(String s) {
        String ret = "";
        Stack<Integer> rep = new Stack<Integer>();
        Stack<String> res = new Stack<String>();
        
        int p = 0;
        while(p<s.length()){
            if(Character.isDigit(s.charAt(p))){
                int start = p;
                while(Character.isDigit(s.charAt(p++)));
                rep.push(Integer.parseInt(s.substring(start,--p)));
            }else if(s.charAt(p)=='['){
                res.push(ret);
                ret = "";
                p++;
            }else if(s.charAt(p)==']'){
                StringBuilder sb = new StringBuilder(res.pop());
                int times = rep.pop();
                while(times-- != 0){
                    sb.append(ret);
                }
                ret = sb.toString();
                p++;
            }else{
                ret += s.charAt(p++);
            }
        }
        return ret;
    }
}
