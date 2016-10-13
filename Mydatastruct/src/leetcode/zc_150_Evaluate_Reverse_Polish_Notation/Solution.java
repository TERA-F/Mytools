public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> sta = new Stack<Integer>();
        for(int k = 0 ; k < tokens.length ; k++){
            if(tokens[k].equals("+")){
                int i = sta.pop();
                int j = sta.pop();
                sta.push(i+j);
            }else if(tokens[k].equals("-")){
                int i = sta.pop();
                int j = sta.pop();
                sta.push(j-i);
            }else if(tokens[k].equals("*")){
                int i = sta.pop();
                int j = sta.pop();
                sta.push(i*j);
            }else if(tokens[k].equals("/")){
                int i = sta.pop();
                int j = sta.pop();
                sta.push(j/i);
            }else{
                sta.push(Integer.parseInt(tokens[k]));
            }
            // System.out.println(sta.peek());
        }
        return sta.pop();
        
    }
}
