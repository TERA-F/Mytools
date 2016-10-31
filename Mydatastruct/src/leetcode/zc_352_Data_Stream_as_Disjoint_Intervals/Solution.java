/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    private TreeSet<Interval> set = new TreeSet<Interval>(new Comparator<Interval>(){
        @Override
        public int compare(Interval I1, Interval I2){
            return I1.start - I2.start;
        }
    });
    private HashSet<Integer> hash = new HashSet<Integer>();
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        if(hash.contains(val))return ;
        hash.add(val);
        
        Interval tmp = new Interval(val,val);
        
        Interval greater = set.ceiling(tmp);
        Interval smaller = set.floor(tmp);

        
        if(greater!= null){
            // System.out.println("greater:"+greater.start+" "+greater.end+" val:"+val);
            if(greater.start == val+1){
                greater.start = val;
                merge(smaller,greater);
                
                return;
            }
        }
        if(smaller != null){
            // System.out.println("smaller:"+smaller.start+" "+smaller.end+" val:"+val);
            if(smaller.end == val-1){
                smaller.end = val;
                merge(smaller,greater);
                return;
            }
        }
        set.add(tmp);
        // for(Interval I : set){
        //     System.out.print(I.start+" "+I.end+" ");
        // }
        // System.out.println();
    }
    
    public List<Interval> getIntervals() {
        List<Interval> ret = new ArrayList<Interval>();
        for(Interval I : set){
            ret.add(I);
        }
        return ret;
    }
    private void merge(Interval p , Interval n){
        if(p != null && n != null && (p.end == n.start ||p.end+1 == n.start) ){
            p.end = n.end;
            set.remove(n);
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
