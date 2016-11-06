public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length()<3)return false;
        for(int i = 1;i<num.length();i++)
            for(int j = 1; i + j <num.length();j++){
                if(num.charAt(0)=='0' && i != 1) continue;
                long first = Long.parseLong(num.substring(0,i));
                if(num.charAt(i)=='0' && j != 1) continue;
                long second = Long.parseLong(num.substring(i,i+j));
                String sum = String.valueOf(first+second);
                // if(i+j+sum.length()<=num.length())
                //     System.out.println(first+" "+second+" "+sum+" "+num.substring(i+j,i+j+sum.length()));
                if(i+j+sum.length()<=num.length() && num.substring(i+j,i+j+sum.length()).equals(sum)){
                    // System.out.println(first+" "+second+" "+sum+" "+num.substring(i+j,i+j+sum.length()));
                    if(helper(num.substring(i+j+sum.length()),second,first+second))
                        return true;
                }
            }
        return false;
    }
    
    private boolean helper(String num , long first, long second){
        if(num.length()==0) return true;
        long sum = first+second;
        String sumstr = String.valueOf(sum);
        // System.out.println(first+" "+second+" "+sumstr+" "+num.substring(sumstr.length()));
        if(sumstr.length()<= num.length() && num.substring(0,sumstr.length()).equals(sumstr))
            return helper(num.substring(sumstr.length()),second,sum);
        return false;
    }
}
