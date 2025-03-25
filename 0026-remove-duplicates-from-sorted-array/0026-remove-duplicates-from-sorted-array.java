class Solution {
    public int removeDuplicates(int[] nums) {
        int filler = 101;
        int k = nums.length;
        int j;
        for(int i=0;i<nums.length;i++) {
            if (i==nums.length-1) {
                break;
            } else {
                j = i + 1;
            }
            while(nums[i]==nums[j]) {
                nums[j]=filler;
                k--;
                if(j==nums.length-1) {
                    break;
                } else {
                    j++;
                }
            }
            i=j-1;
        }
        Arrays.sort(nums);
        return k;    
    }
}