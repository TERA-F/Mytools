public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<Integer>();
        if(s.length()<p.length()) return ret;
        int n = p.length();
        int [] list = new int[26];
        
        for(int i = 0 ; i < p.length(); i++){
            list[p.charAt(i)-'a']++;
        }
/*        for(int i : list)
            System.out.print(i+" ");
        System.out.println();  */      
        int start = 0,end = 0;
        for( ;end<p.length();end++){
            list[s.charAt(end)-'a']--;
        }
/*        for(int i : list)
            System.out.print(i+" ");
        System.out.println();
        */
        for(;end<=s.length();start++,end++){
            boolean flag = true;
            for(int i : list)
                if(i!=0) flag = false;
            if(flag){
                ret.add(start);
            }
/*            System.out.println(start+" "+end+" "+flag+" ");
            for(int i : list)
                System.out.print(i+" ");
            System.out.println();*/
            if(end==s.length()) break;

            list[s.charAt(start)-'a']++;
            list[s.charAt(end)-'a']--;
        }
        return ret;
    }
}
