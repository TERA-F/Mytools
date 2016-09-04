public class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> ret1 = new ArrayList<Integer>();
        ArrayList<Integer> ret2 = new ArrayList<Integer>();
        // ArrayList<Integer> p1 = new ArrayList<Integer>();
        // ArrayList<Integer> p2 = new ArrayList<Integer>();
        String[] tmp = version1.split("[.]");

        for(String s:tmp)
            ret1.add(Integer.parseInt(s));
        
        tmp = version2.split("[.]");
        for(String s:tmp)
            ret2.add(Integer.parseInt(s));
        
        int i = 0,j = 0;
        
        System.out.println(ret1);
        System.out.println(ret2);
        
        for(;i<ret1.size() && j < ret2.size();i++,j++){
            if(ret1.get(i)<ret2.get(j))
                return -1;
            if(ret1.get(i)>ret2.get(j))
                return 1;
        }
        
        if(i == ret1.size()){
            while(j < ret2.size()){
                if(ret2.get(j++)!=0) return -1;
            }
        }else if(j == ret2.size()){
            while(i < ret1.size()){
                if(ret1.get(i++)!=0) return 1;
            }
        }
        return 0;
    }
}
