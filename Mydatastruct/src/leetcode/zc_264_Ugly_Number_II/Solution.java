public class Solution {
    public int nthUglyNumber(int n) {
        int [] primes = new int [3];
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        int [] ret = new int [n];
        int [] tmpind = new int [primes.length];
        int [] tmpval = new int [primes.length];
        Arrays.fill(tmpval,1);
        
        int next = 1;
        for(int i = 0; i < n ; i++){
            ret[i] = next;
            
            next = Integer.MAX_VALUE;
            for(int j = 0 ; j < primes.length ; j++){
                if(tmpval[j]==ret[i]) tmpval[j] = ret[tmpind[j]++]*primes[j];
                next = Math.min(next,tmpval[j]);
            }
        }
        return ret[n-1];
    }
}
