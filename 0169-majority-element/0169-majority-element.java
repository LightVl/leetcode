class Solution {
    public int majorityElement(int[] nums) {
        int maj = 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[maj]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maj = i;
                count = 1;
            }
        }
        System.out.println(nums[maj]);
        return nums[maj];   
    }
}