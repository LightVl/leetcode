class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        boolean isInterval = false;
        if (nums.length==0)
            return result;
        int startNumber=nums[0];

        for (int i = 0;i<nums.length;i++) {
            if (i==nums.length-1) {
                if (isInterval == false) {
                    result.add(String.valueOf(startNumber));
                } else {
                    result.add(String.valueOf(startNumber+"->"+nums[i]));
                }
                break;
            }
            if(nums[i+1]==nums[i]+1) {
                isInterval=true;
                continue;
            } else {
                if (isInterval == false) {
                    result.add(String.valueOf(startNumber));
                    startNumber=nums[i+1];
                } else {
                    result.add(String.valueOf(startNumber+"->"+nums[i]));
                    startNumber=nums[i+1];
                    isInterval = false;
                }

            }
        }
        return result;
    }
}