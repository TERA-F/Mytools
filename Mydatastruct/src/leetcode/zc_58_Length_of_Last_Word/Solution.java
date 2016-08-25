public class Solution {
    public int lengthOfLastWord(String s) {
        int left = 0;
        int right = 0;
        if(s.length()==0) return 0;
        for(int i = s.length()-1; i >= 0;i--)
            if(s.charAt(i)!=' '){
                right = i;
                break;
            }
        for(int i = right; i >= 0;i--)
            if(s.charAt(i)==' '){
                left = i;
                return right-left;
            }
        return right-left+1;
    }
}
