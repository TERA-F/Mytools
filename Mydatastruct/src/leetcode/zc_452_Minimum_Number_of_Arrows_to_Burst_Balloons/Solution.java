public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length<1)return 0;
        Arrays.sort(points,new Comparator<int[]>(){
           @Override
           public int compare(int[] T1,int[] T2){
               if(T1[0]!=T2[0])
                    return T1[0] - T2[0];
                return T1[1] - T2[1];
                
           }
        });
        
/*        for(int[] is : points){
            for(int i : is)
                System.out.print(i+" ");
            System.out.println();
        }*/
        
        List<int[]> ret = new ArrayList();
        ret.add(points[0]);
        for(int i = 1 ; i <points.length ; i++){
            int [] tmp = ret.get(ret.size()-1);
            if(points[i][0] <= tmp[1]){
                tmp[0] = Math.max(tmp[0],points[i][0]);
                tmp[1] = Math.min(tmp[1],points[i][1]);
            }else{
                ret.add(points[i]);
            }
        }
        
        
        return ret.size();
    }
}
