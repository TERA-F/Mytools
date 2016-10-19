public class Solution {
    public String toHex(int num) {
        String s = "";
        do{
            int hex = num & 0x0f;
            if(hex<10){
                s = hex+s;
            }else{
                s = (char)((hex-10)+'a')+s;
            }
            num = num>>>4;
        }while(num!=0);
        return s;
    }
}
