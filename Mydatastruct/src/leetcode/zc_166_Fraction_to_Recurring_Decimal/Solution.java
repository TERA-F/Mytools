public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ret = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0)? "":"-";
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        ret.append(sign);
        ret.append(num / den);
        long rem = num % den;
        if(rem==0) return ret.toString();
        ret.append(".");
        Map<Long,Integer> map = new HashMap<Long,Integer>();
        while(!map.containsKey(rem)){
            map.put(rem,ret.length());
            ret.append(10 * rem / den);
            rem = 10 * rem % den;
        }
        int index = map.get(rem);
        ret.insert(index,"(");
        ret.append(")");
        return ret.toString().replace("(0)","");
        
    }
}
