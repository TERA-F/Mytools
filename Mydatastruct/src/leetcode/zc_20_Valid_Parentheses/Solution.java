public class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        if(s.length()<2) return false;
        
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        Stack<Character> stack = new Stack<Character>();
        
        int i = 0;
        while(i<s.length()){
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            if(map.containsValue(s.charAt(i))){
                if(stack.empty()) return false;
                if(s.charAt(i)==map.get(stack.peek())) 
                    stack.pop();
                else
                    return false;
            }
            i++;
        }
        return stack.empty();
        
    }
}
