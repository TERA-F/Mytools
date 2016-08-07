public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        int tmp = n-1;
        int count = 9;
        int down = 9;
        while(tmp-- > 0){
            count *= down--;
        }
        return count+  countNumbersWithUniqueDigits(n-1);
    }
}
