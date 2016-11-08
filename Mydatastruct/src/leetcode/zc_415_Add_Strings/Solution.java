public class Solution {
    public String addStrings(String num1, String num2) {
        int maxlenp1 = Math.max(num1.length(),num2.length())+1;
        while(num1.length()<maxlenp1) num1="0"+num1;
        while(num2.length()<maxlenp1) num2="0"+num2;
        String ret = "";
        int count = 0;
        for(int i = maxlenp1 - 1 ; i>=0 ;i--){
            int tmp = (num1.charAt(i)-'0') + (num2.charAt(i)-'0')+count;
            if( tmp > 9) count=1;
            else count = 0;
            ret = (tmp%10) + ret;
        }
        if(ret.charAt(0)=='0')
            ret = ret.substring(1);
        return ret;
    }
}
