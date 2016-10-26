public class Solution {
/*    public List<String> findItinerary(String[][] tickets) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        HashMap<String,String> tmap = new HashMap<String,String>();
        PriorityQueue<String> heap = new PriorityQueue<String>();
        List<String> ret = new ArrayList<String>();
        
        for(String[] ticket : tickets){
            if(!map.keySet().contains(ticket[0]))
                map.put(ticket[0],0);
            if(!map.keySet().contains(ticket[1]))
                map.put(ticket[1],1);
            else
                map.put(ticket[1],map.get(ticket[1])+1);
            
            tmap.put(ticket[0],ticket[1]);
        }
        
        for(String s : map.keySet()){
            System.out.println(s+" "+map.get(s));
            if(map.get(s)==0) heap.offer(s);
        }
        
        while(!heap.isEmpty()){
            String s = heap.poll();
            ret.add(s);
            System.out.println(s);
            String to = tmap.get(s);
            if(to == null) continue;
            int degree = map.get(to);
            if(--degree == 0) heap.offer(to);
            map.put(to,degree);
        }
        return ret;
    }*/
    public List<String> findItinerary(String[][] tickets) {
        Map<String,PriorityQueue<String>> map = new HashMap<String,PriorityQueue<String>>();
        List<String> ret = new ArrayList<String>();
        for(String[] ticket : tickets){
            if(!map.containsKey(ticket[0])){
                PriorityQueue<String> tmp = new PriorityQueue<String>();
                tmp.add(ticket[1]);
                map.put(ticket[0],tmp);
            }else{
                PriorityQueue<String> tmp = map.get(ticket[0]);
                tmp.add(ticket[1]);
            }
        }
        visit("JFK",map,ret);
        return ret;
    }
    
    private void visit(String s,Map<String,PriorityQueue<String>> map,List<String> ret){
        while(map.containsKey(s) && !map.get(s).isEmpty())
            visit(map.get(s).poll(),map,ret);
        ret.add(0,s);
    }
    

}
