public class Solution {
/*    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer,List<int[]>>[] maps = new HashMap[points.length];
        for(int i = 0 ; i < points.length ; i++){
            maps[i] = new HashMap();
            for(int j = 0 ; j < points.length ; j++){
                if(i == j) continue;
                int x = points[i][0]>points[j][0] ? points[i][0]-points[j][0]:points[j][0]-points[i][0];
                int y = points[i][1]>points[j][1] ? points[i][1]-points[j][1]:points[j][1]-points[i][1];
                int len = x*x + y*y;
                if(maps[i].get(len) == null)
                    maps[i].put(len,new ArrayList<int[]>());
                // System.out.println(i+" "+j+" "+len);
                maps[i].get(len).add(points[j]);
            }
        }
        int ret = 0;
        for(HashMap<Integer,List<int[]>> map :maps)
            for(int i : map.keySet()){
                int number = map.get(i).size();
                if(number < 2) continue;
                ret += number*(number-1);
            }
        return ret;
    }*/
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int j = 0; j < n; j++){
                if(i!=j){
                    int key = getDis(points[i],points[j]);
                    map.putIfAbsent(key,0);
                    int val = map.get(key);
                    map.put(key,val+1);
                }
            }
            for(Integer k:map.keySet()){
                int tmp = map.get(k);
                if(tmp > 1){
                    res += (tmp * (tmp-1));
                }
            }
        }
        return res;
    }
    public int getDis(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}
