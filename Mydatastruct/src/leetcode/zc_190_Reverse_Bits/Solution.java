public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
/*        if(n == 0) return 0;
        String s = Integer.toBinaryString(n);
        int ret = 0;
        for(int i = s.length()-1 ;i >= 0 ; i--){
            if(s.charAt(i)=='1'){
                ret = (ret<<1) | 1;
            }else{
                ret = (ret<<1) | 0;
            }
        }
        return ret;*/
        if (n == 0) return 0;
    
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
