public class Solution {
    public int titleToNumber(String s) {
        if(s==null)
            return 0;
        char [] column = s.toCharArray();
        if(column.length==1)
            return (int)column[0]-64;
        else
            return titleToNumber(s.substring(0,column.length-1))*26+(int)column[column.length-1]-64;
    }
}