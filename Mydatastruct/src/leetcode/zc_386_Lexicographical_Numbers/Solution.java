public class Solution {
    public List<Integer> lexicalOrder(int n) {
/*        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1 ; i <= n ;i++){
            list.add(i);
        }
        
        Collections.sort(list,new Comparator<Integer>(){
          @Override
          public int compare(Integer n1, Integer n2){
                String s1 = String.valueOf(n1);
                String s2 = String.valueOf(n2);
                int min = Math.min(s1.length(),s2.length());
                for(int i = 0 ; i < min ; i++)
                    if(s1.charAt(i)<s2.charAt(i)){
                        return -1;
                    }else if(s1.charAt(i)>s2.charAt(i)){
                        return 1;
                    }
                return s1.length()<s2.length() ? -1:1;
          }
        });
        return list;*/
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 1; i < 10 ; i++){
            dfs(i,n,ret);
        }
        return ret;
    }
    
    private void dfs(int i , int n, List<Integer> ret){
        if(i > n) return ;
        ret.add(i);
        for(int j = 0 ; j < 10 ; j++){
            dfs(10*i+j,n,ret);
        }
    }
}
