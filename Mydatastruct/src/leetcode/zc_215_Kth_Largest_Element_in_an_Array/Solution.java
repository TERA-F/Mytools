/*public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int p = quickselect(nums,0,nums.length-1,nums.length-k+1);
        return nums[p];
    }
    
    private int quickselect(int[] nums, int lo,int hi,int k){
        int i = lo ,j = hi, pivot = nums[hi];
        while(i<j){
            if(nums[i++] > pivot) swap(nums,--i,--j);
        }
        swap(nums,i,hi);
        
        int id = i-lo+1;
        
        if(id==k)
            return id;
        else if(id<k)
            return quickselect(nums,i+1,hi,k-id);
        else
            return quickselect(nums,lo,i-1,k);
    }
    
    private void swap(int[] nums, int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }
}*/
public class Solution {
  
  public int findKthLargest(int[] a, int k) {
    int n = a.length;
    int p = quickSelect(a, 0, n - 1, n - k + 1);
    return a[p];
  }
  
  // return the index of the kth smallest number
  int quickSelect(int[] a, int lo, int hi, int k) {
    // use quick sort's idea
    // put nums that are <= pivot to the left
    // put nums that are  > pivot to the right
    int i = lo, j = hi, pivot = a[hi];
    while (i < j) {
      if (a[i++] > pivot) swap(a, --i, --j);
    }
    swap(a, i, hi);
    
    // count the nums that are <= pivot from lo
    int m = i - lo + 1;
    
    // pivot is the one!
    if (m == k)     return i;
    // pivot is too big, so it must be on the left
    else if (m > k) return quickSelect(a, lo, i - 1, k);
    // pivot is too small, so it must be on the right
    else            return quickSelect(a, i + 1, hi, k - m);
  }
  
  void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

}
