class Solution {
    public void rotate(int[] nums, int k) {
        int [] rotatedNumbers = new int [k];
        int j = 0;
        //O(N)
        if (nums.length == 1) {
            return;
        }
        while (k > nums.length) {
            k=k-nums.length;
        }
        for (int i=nums.length-k;i<nums.length;i++) {
            rotatedNumbers[j]=nums[i];
            j++;    
        }
        j = nums.length-1;
        for (int i=nums.length-k-1;i>=0;i--) {
            nums[j]=nums[i];
            j--;    
        }
        for (int i=0;i<k;i++) {
            nums[i]=rotatedNumbers[i];
        }   
    }
}