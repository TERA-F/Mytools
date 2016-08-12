public class Solution {
    public String multiply(String num1, String num2) {
        
        int [] n = new int[num1.length()+num2.length()];
        
        for(int i = num1.length()-1 ; i >= 0 ; i--){
            for(int j = num2.length()-1 ;j >= 0 ; j--){
                int num = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = num+n[p2];
                
                n[p1] += sum / 10;
                n[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : n) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
