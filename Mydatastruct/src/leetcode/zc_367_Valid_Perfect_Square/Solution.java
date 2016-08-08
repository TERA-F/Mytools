public class Solution {
    public boolean isPerfectSquare(int num) {
/*        for (int i = 1; i <= num / i; ++i) {
            if (i * i == num) return true;
        }
        return false;*/
/*        long r = num;
        while (r > num/r)
            r = (r + num/r) / 2;
        return r*r == num;*/
     if(num == 1)
        return true;

        long low = 1,
            high = num / 2,
            mid = 0;

        long nums = (long)num;

        while(low <= high)
        {
            mid = low + (high - low) / 2;

            if((mid * mid) == nums)
                return true;
            else if( (mid * mid) < nums)
                low = mid + 1;
            else
                high = mid - 1;
        }



        return false;

//a wrong answer
/*        long left = 1;
        long right = num/2;
        long mid;
        long nums = num;
        while( left <= right ){
             mid = left + (right-left)/2;
             if(mid < nums/mid){
                 left = mid + 1;
             }else if(mid > nums/mid){
                 right = mid - 1;
             }else return true;
        }
        return false;*/
    }
}
