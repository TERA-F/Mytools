public class Solution {
    
    
    public int lengthLongestPath(String input) {
        // System.out.println(input);
        String[] sl = input.split("\n");
        List<Integer> list = new ArrayList<Integer>();
        
        int ret = 0;
        for(int i = 0; i < sl.length ; i++){
            int pos = 0;
            // System.out.println("2:"+sl[i].substring(0,2));
            while(sl[i].substring(0,1).equals("\t")){
                sl[i] = sl[i].substring(1);
                pos++;
            }
            // System.out.print(sl[i]+""+pos);
            if(pos == list.size())
                list.add(sl[i].length());
            else{
                list.set(pos,sl[i].length());
            }
            // System.out.print(sl[i]+" "+sl[i].length());
            /*for(int j : list)
                System.out.print(j+" ");
            System.out.println();*/
            
            int len = 0;
            for(int j = 0 ; j <= pos ;j++)
                len += list.get(j)+1;
            len--;
            // System.out.println(sl[i]);
            if(sl[i].contains(".")){
                // System.out.println("pass");
                ret = Math.max(len,ret);
            }
        }
        return ret;
    }
}
