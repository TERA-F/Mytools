public class Solution {
    public int numDecodings(String s) {
        if( s.length() == 0 ) return 0;
        if( s.charAt(0)=='0') return 0;
        if( s.length() == 1 ) return 1;
        int[] chose = new int[s.length()];
        for(int i = 0 ; i < s.length()-1 ; i++){
            if(s.charAt(i+1) == '0' && (s.charAt(i)=='0' || (s.charAt(i) <= '9' && s.charAt(i) > '2'))){
                // System.out.println("pass 1");
                return 0;
            }else if( (s.charAt(i) == '1' && s.charAt(i+1) > '0' && s.charAt(i+1) <= '9')
                || (s.charAt(i) == '2' && s.charAt(i+1) > '0' && s.charAt(i+1) < '7')){
                chose[i] = 2;
                // System.out.println("pass 2");
            }else{
                chose[i] = 1;
                // System.out.println("pass 3");
            }
        }
        
        // for(int x : chose)
            // System.out.println(x);

        if(s.charAt(s.length()-1) =='0'){
            chose[s.length()-1] = 0;
        }else{
            chose[s.length()-1] = 1;
        }
        
        for(int i = s.length()-3 ; i >= 0 ; i--){
            if(chose[i]==2){
                chose[i] = chose[i+1] + chose[i+2];
            }else{
                chose[i] = chose[i+1];
            }
        }
        return chose[0];
    }
}
