public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length==0) return 0;
        
        int sum = 0;
        for(int i : A)
            sum += i;
        int f0 = 0;
        for(int i = 0 ; i < A.length ; i++){
            f0 += A[i]*i;
        }
        int ret = f0;
        
        
        for(int j = 0 ; j < A.length ; j++){
            f0 -= sum;
            f0 += A.length * A[j];
            ret = Math.max(ret,f0);
        }
        
        return ret;
    }
}
