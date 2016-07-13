public class Solution {
    public int maxArea(int[] height) {
        if(height.length<2)
            return 0;
        int curarea = Math.min(height[0],height[height.length-1])*(height.length-1);
        int i= 0,curi = 0;
        int j= height.length-1,curj = height.length-1;
        
        while(i<j){
            curarea = Math.max(curarea,Math.min(height[curi],height[curj])*(curj-curi));
            if(height[curi]<height[curj]){
                while(height[curi] >= height[i] && i<j){
                    i++;
                }
                curi = i;
                curarea = Math.max(curarea,Math.min(height[curi],height[curj])*(curj-curi));
            }else{
                while(height[j] <= height[curj] && i<j){
                    j--;
                }
                curj = j;
                curarea = Math.max(curarea,Math.min(height[curi],height[curj])*(curj-curi));
            }
        }
        return curarea;
    }
}