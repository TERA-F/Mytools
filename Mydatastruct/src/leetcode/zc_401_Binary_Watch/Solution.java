public class Solution {
/*    int[] listh = new int[]{8,4,2,1};
    int[] listm = new int[]{32,16,8,4,2,1};
    
    public List<String> readBinaryWatch(int num) {
        boolean[] bith = new boolean[4];
        boolean[] bitm = new boolean[6];
        HashSet<String> set = new HashSet<String>();
        helper(set,bith,bitm,0,0,num);
        List<String> ret = new ArrayList<String>(set);
        return ret;
    }
    
    private void helper(HashSet<String> ret, boolean[] bith, boolean[] bitm, int h, int m, int num){
        if(h>11 || m >59) return;
        if(num==0){
            ret.add(String.format("%d:%02d", h, m));
            return;
        }
        
        for(int i = 0 ; i < 4 ; i++){
            if(!bith[i]){
                bith[i] = true;
                helper(ret,bith,bitm,h+listh[i],m,num-1);
                bith[i] = false;
            }
        }
        for(int i = 0 ; i < 6 ; i++){
            if(!bitm[i]){
                bitm[i] = true;
                helper(ret,bith,bitm,h,m+listm[i],num-1);
                bitm[i] = false;
            }
        }
    }*///TLE when input is 7;
    public List<String> readBinaryWatch(int num) {
    List<String> times = new ArrayList<>();
    for (int h=0; h<12; h++)
        for (int m=0; m<60; m++)
            if (Integer.bitCount(h * 64 + m) == num)
                times.add(String.format("%d:%02d", h, m));
    return times;        
    }
}

