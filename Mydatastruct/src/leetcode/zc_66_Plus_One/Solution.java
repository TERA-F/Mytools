public class Solution {
    public int[] plusOne(int[] digits) {
        int n;
        if((n=digits.length)==0) return digits;
        for(int i = n-1; i >= 0 ; --i){
            if(digits[i]==9){
                digits[i]=0;
                if(i==0){
                    int[] ret = new int[n+1];
                    ret[0] =1;
                    for(int j = 0;j<n;++j){
                        ret[j+1] = digits[j];
                    }
                    return ret;
                }
            }else{
                digits[i] = digits[i]+1;
                break;
            }
        }
        return digits;
    }
}