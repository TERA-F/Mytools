public class Solution {
    public boolean isValidSerialization(String preorder) {
        String [] str = preorder.split(",");
        int diff = 1;
        for(String s :str){
            if(--diff<0) return false;
            if(!s.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
