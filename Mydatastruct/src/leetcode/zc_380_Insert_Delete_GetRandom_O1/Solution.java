public class RandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer,Integer> locs;
    java.util.Random rand = new java.util.Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        locs = new HashMap<Integer,Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(locs.containsKey(val))return false;
        locs.put(val,list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!locs.containsKey(val)) return false;
        int local = locs.get(val);
        if( local < list.size() - 1){
            int tmp = list.get(list.size()-1);
            list.set(local,tmp);
            locs.put(tmp,local);
        }
        list.remove(list.size()-1);
        locs.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
