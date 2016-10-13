public class Solution {
/*    public String removeKdigits(String num, int k) {
        if(num.length() <= k) return "0";
        while(num.charAt(0)=='0') 
            if(num.equals("0"))
                return "0";
            else
                num = num.substring(1);
        if(k == 0) return num;
        for(int i = 0 ; i < num.length(); i++){
            if(num.charAt(i) == '0')
                if(i <= k) return removeKdigits(num.substring(i),k-i);
                else break;
        }
        for(int i = 1;i<num.length();i++){
            if(num.charAt(i-1)>num.charAt(i)){
                num = num.substring(0,i-1)+num.substring(i);
                if(--k==0) return num;
                i--;
            }
        }
        while(k-->0||num.length()<1){
            num = num.substring(0,num.length()-1);
        }
        return num;
        
    }*///same idea but get wrong;
    public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)        
            return "0";
            
        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;            
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
