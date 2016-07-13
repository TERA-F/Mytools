public class Solution {
    public int trap(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length-1;
        int minhei = 0;
        while(i<j){
            minhei = Math.min(height[i],height[j]);
            if(height[i]<=height[j]){
                while(height[++i] < minhei && i<j)
                    res += minhei - height[i];
            }else{
                while(height[--j] < minhei && i<j)
                    res += minhei - height[j];
            }
        }
        return res;
    }
}