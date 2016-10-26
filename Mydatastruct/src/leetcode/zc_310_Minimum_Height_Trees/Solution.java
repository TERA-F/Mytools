public class Solution {
/*    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap();
        TreeMap<Integer,List<Integer>> height = new TreeMap();
        List<Integer> ret = new ArrayList();
        if(n==0) return ret;
        if(n==1){
          ret.add(0);
          return ret;
        } 
        for(int[] edge :edges){
            if(!map.containsKey(edge[0])){
                List<Integer> tmplist = new ArrayList<Integer>();
                tmplist.add(edge[1]);
                map.put(edge[0],tmplist);
            }else{
                map.get(edge[0]).add(edge[1]);
            }
            if(!map.containsKey(edge[1])){
                List<Integer> tmplist = new ArrayList<Integer>();
                tmplist.add(edge[0]);
                map.put(edge[1],tmplist);
            }else{
                map.get(edge[1]).add(edge[0]);
            }
        }
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> tmpset = new HashSet<Integer>();
            int tmpdep = finddep(map,tmpset,i,0);
            if(!height.containsKey(tmpdep)){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                height.put(tmpdep,tmp);
            }else{
                height.get(tmpdep).add(i);
            }
        }
        return height.firstEntry().getValue();
    }
    
    private int finddep(HashMap<Integer,List<Integer>> map,HashSet<Integer> tmp,int i,int dep){
        if(tmp.contains(i)) return dep;
        tmp.add(i);
        dep++;
        int max = dep;
        for(int subdep : map.get(i)){
            max =Math.max(finddep(map,tmp,subdep,dep),max);
        }
        return max;
    }*///TLE
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
    
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);
    
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
