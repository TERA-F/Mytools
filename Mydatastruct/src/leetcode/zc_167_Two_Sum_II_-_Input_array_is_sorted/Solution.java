public class Solution {
    public int[] twoSum(int[] numbers, int target) {
         int i = 0 , j = 1;
         int[] ret = new int[2];
         while(j<numbers.length && numbers[i]+numbers[j] < target) j++;
         if(j == numbers.length)j--;
         while(i<j && j <numbers.length){
             if(numbers[i]+numbers[j] == target){
                 ret[0] = i+1;
                 ret[1] = j+1;
                 return ret;
             }else if(numbers[i]+numbers[j] > target)j--;
             else i++;
         }
         return null;
         
    }
}
