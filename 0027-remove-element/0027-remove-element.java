class Solution {
    public int removeElement(int[] nums, int val) {
    int filler = 51;
    int k = nums.length;
    for(int i=0;i<nums.length;i++) {
        if(nums[i]==val) {
            k--;
            nums[i]=filler;
            }    
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
        return k;
    }
}