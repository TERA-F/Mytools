public class NumArray {

    private int[] num;
    private int[] sum;

    public NumArray(int[] nums) {
        num = nums;
        sum = new int[num.length+1];
        for(int i = 0; i <num.length ; i++){
            sum[i+1] = sum[i] + num[i];
        }
    }

    public void update(int i, int val) {
        int diff = val - num[i];
        for( int j = i + 1; j < sum.length ; j++){
            sum[j] += diff;
        }
        num[i] = val;
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
