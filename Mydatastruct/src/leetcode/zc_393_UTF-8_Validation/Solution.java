public class Solution {
    public boolean validUtf8(int[] data) {
        if(data==null || data.length==0) return true;
        for(int i = 0 ; i < data.length ; ){
            if((data[i] &0b10000000) == 0){
                i = i + 1;
                // System.out.println("1");
            }else if(((data[i] & 0b11100000) ==0b11000000)&& i+1<data.length &&((data[i+1] & 0b11000000)==0b10000000)){
                i = i + 2;
                // System.out.println("2");
            }else if(((data[i] & 0b11110000) ==0b11100000)&& i+2<data.length &&((data[i+1] & 0b11000000)==0b10000000) &&((data[i+2] & 0b11000000)==0b10000000)){
                i = i + 3;
                // System.out.println("3");
            }else if(((data[i] & 0b11111000) ==0b11110000)&& i+3<data.length &&((data[i+1] & 0b11000000)==0b10000000) &&((data[i+2] & 0b11000000)==0b10000000) & ((data[i+3] & 0b11000000)==0b10000000)){
                i = i + 4;
                // System.out.println("4");
            }else{
                // System.out.println(data[i] & 0b11100000) == 0b11000000);
                // System.out.println("5");
              return false;
            } 
        }
        return true;
    }
}
