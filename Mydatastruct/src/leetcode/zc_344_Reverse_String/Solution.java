public class Solution {
    public String reverseString(String s) {
    char[] sarray = s.toCharArray();
    char tmp;
    for(int i =0; i<s.length()/2;i++)
    {
        tmp = sarray[i];
        sarray[i]=sarray[s.length()-i-1];
        sarray[s.length()-i-1]=tmp;
    }
        return new String(sarray);
    }
}