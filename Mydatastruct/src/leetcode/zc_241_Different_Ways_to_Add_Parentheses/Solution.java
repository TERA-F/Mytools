public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<Integer>();
        if(input==null || input.length()==0)
            return ret;
        if(!input.contains("+")&&!input.contains("-")&&!input.contains("*")) {
            ret.add(Integer.valueOf(input));
            return ret;
        }
        for(int i = 0 ; i<input.length();i++){
            char p = input.charAt(i);
            if(p=='+'||p=='-'||p=='*'){
                List<Integer> leftlist = diffWaysToCompute(input.substring(0,i));
                List<Integer> rightlist = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int left : leftlist)
                    for(int right : rightlist){
                        switch(p){
                            case '+' : ret.add(left+right); break;
                            case '-' : ret.add(left-right); break;
                            case '*' : ret.add(left*right); break;
                        }
                    }
            }
        }
        return ret;
    }
}
