public class Solution {
    public String getHint(String secret, String guess) {
        char[] sechar = secret.toCharArray();
        char[] guchar = guess.toCharArray();
        
        int a = 0;
        int b = 0;
        
        for(int i = 0 ; i < sechar.length ; ++i)
            if(sechar[i]==guchar[i]){
                a++;
                guchar[i]= 'a';
                sechar[i]= 'b';
            }
        
       for(int i = 0 ; i < sechar.length ; ++i)
            for(int j = 0 ; j < guchar.length ; ++j)
                if(i!=j && sechar[i]==guchar[j]){
                    ++b;
                    guchar[j] = 'c';
                    break;
                }
        
        return Integer.toString(a)+"A"+Integer.toString(b)+"B";
    }
}
