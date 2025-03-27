class Solution {
    public void rotate(int[] nums, int k) {
        int temp;
        if (nums.length == 1) {
            return;
        }
        while (k > nums.length) {
            k=k-nums.length;
        }
        for(int j=1;j<=k;j++) {
            temp = nums[nums.length-1];
            for(int i=nums.length-1;i>0;i--) {
                nums[i]=nums[i-1];
            }
            nums[0]=temp;
        }
    }
}
