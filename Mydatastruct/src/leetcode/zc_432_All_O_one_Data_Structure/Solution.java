public class AllOne {
    class Node {
        String key;
        int val;
        public Node(String k, int v){
            this.key = k;
            this.val = v;
        }
    }
    
    private HashMap<String,Node> map = new HashMap<String,Node>();
    private PriorityQueue<Node> minQ = new PriorityQueue<Node>(new Comparator<Node>(){
        @Override
        public int compare(Node a, Node b){
            return a.val- b.val;
        }
    });
    private PriorityQueue<Node> maxQ = new PriorityQueue<Node>(new Comparator<Node>(){
        @Override
        public int compare(Node a, Node b){
            return b.val- a.val;
        }
    });

    /** Initialize your data structure here. */
    public AllOne() {
        
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            minQ.remove(node);
            maxQ.remove(node);
            node.val++;
            // System.out.println(map.get(key).val);
            minQ.add(node);
            maxQ.add(node);
        }else{
            Node node = new Node(key,1);
            map.put(key,node);
            minQ.add(node);
            maxQ.add(node);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.val == 1) {
                map.remove(key);
                minQ.remove(node);
                maxQ.remove(node);
            } else {
                minQ.remove(node);
                maxQ.remove(node);
                node.val--;
                map.put(key, node);
                minQ.add(node);
                maxQ.add(node);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(maxQ.isEmpty())
            return "";
        // System.out.println(maxQ.peek().val);
        return maxQ.peek().key;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(minQ.isEmpty())
            return "";
        // System.out.println(minQ.peek().val);
        return minQ.peek().key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
