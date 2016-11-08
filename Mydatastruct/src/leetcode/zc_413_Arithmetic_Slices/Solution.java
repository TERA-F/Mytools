public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        List<Integer> len = new ArrayList<Integer>();
        int diff = A[1] - A[0];
        int count = 2;
        for(int i = 2; i < A.length ; i++){
            if(A[i]-A[i-1]==diff){
                count++;
            }else{
                if(count>2)
                    len.add(count);
                count = 2;
                diff = A[i]-A[i-1];
            }
        }
        if(count>2)
            len.add(count);
        int ret = 0;
        for(int i : len)
            ret += (i-1)*(i-2)/2;
        return ret;
    }
}
