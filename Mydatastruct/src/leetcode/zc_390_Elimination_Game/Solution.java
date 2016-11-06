public class Solution {
    public int lastRemaining(int n) {
        boolean fromleft = true;
        int left = 1;
        int remaining = n;
        int sift = 1;
        while(remaining>1){
            // System.out.println(left+" "+remaining+" "+sift+" "+fromleft);
            if(fromleft || remaining % 2 ==1){
                left += sift;
            }
            remaining = remaining/2;
            sift = sift<<1;
            fromleft = !fromleft;
        }
        
        return left;
    }
}
