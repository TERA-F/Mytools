public class Solution {
    public int[] singleNumber(int[] nums) {
        int xorre = 0;
        for(int num:nums)
            xorre ^= num;
        int lastonebit = xorre & -xorre;
        System.out.println(xorre);
        System.out.println(lastonebit);
        int [] result= new int[2];
        for(int num:nums)
        {
            if((num & lastonebit)==0)
                result[0] ^=num;
            else
                result[1] ^=num;
        }
        return result;
    }
}