/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        
        while(low <= high){
            int mid = low +(high -low)/2;
            boolean ret = isBadVersion(mid);
            if(ret){
                high = mid -1;
            }else{
                if(isBadVersion(mid+1)) return mid+1;
                low = mid +1;
            }
        }
        return 1;
    }
}
