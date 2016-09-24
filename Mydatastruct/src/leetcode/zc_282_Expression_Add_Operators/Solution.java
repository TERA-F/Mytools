/*public class Solution {
    public List<String> addOperators(String num, int target) {
          List<String> ret = new ArrayList<String>();
          if(num==null || num.length()==0) return ret;
          helper(ret,"",num,target,0,0,0);
          return ret;
    }
    
    private void helper(List<String> ret,String path,String num,int pos,int target,long val,long multed){
        if(pos==num.length()){
            if(target ==val)
                ret.add(path);
            return ;
        }
        for(int i = pos;i<num.length();i++){
            if(i != pos && num.charAt(pos)=='0') break;
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos==0){
                helper(ret,path+cur,num,i+1,target,cur,cur);
            }else{
                helper(ret,path+"+"+cur,num,1+i,target,val + cur,cur);
                helper(ret,path+"-"+cur,num,1+i,target,val - cur,-cur);
                helper(ret,path+"*"+cur,num,1+i,target,val - multed + cur * multed,cur * multed);
            }
        }
    }
}*/
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}
    
