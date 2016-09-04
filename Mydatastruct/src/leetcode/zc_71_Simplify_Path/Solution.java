public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length()==0) return null;
        while(path.length()>1 && path.charAt(path.length()-1)=='/') path = path.substring(0,path.length()-1);
        if(path.equals("/")) return "/";
        ArrayList split = new ArrayList<Integer>();
        for(int i = 0; i < path.length() ; i++){
            if(path.charAt(i) == '/')
                split.add(i);
        }
        split.add(path.length());
        Stack sta = new Stack<String>();
        for(int i = 0; i < split.size()-1 ; i++){
            String tmp = path.substring((int)split.get(i)+1,(int)split.get(i+1));

            if(tmp.equals(".") || tmp.equals(""))
                continue;
            if(tmp.equals("..")){
                if(!sta.empty())
                    sta.pop();
                continue;
            }
            sta.push(tmp);
        }

        String ret= new String();
        while(!sta.empty()){
            ret = "/" + sta.pop() + ret;
        }
        /*
        while(!sta.empty()){
            String tmp = sta.peek();//obejct can't convert to String.even adding casting 
            ret = "/" + tmp + ret;
            sta.pop();
        }       
        */
        return ret.equals("")? "/":ret;
    }
}
