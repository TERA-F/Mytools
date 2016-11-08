public class Solution {
    public int longestPalindrome(String s) {
        char [] list = new char[26];
        char [] list2 = new char[26];
        for(int i = 0 ; i < s.length(); i++){
            // System.out.println(s.charAt(i) - 'a');
            if((s.charAt(i) - 'a')>=0)
                list[s.charAt(i) - 'a']++;
            else
                list2[s.charAt(i) - 'A']++;
        }
        
        boolean flag = false;
        int ret = 0;
        
        for(int i = 0 ; i < 26 ; i++){
            int n = list[i] /2;
            ret += n*2;
            if(flag == false)
                if(list[i]%2==1)
                    flag = true;
            int m = list2[i] /2;
            ret += m*2;
            if(flag == false)
                if(list2[i]%2==1)
                    flag = true;
            
        }
        return flag ? ret+1:ret;
    }
}
