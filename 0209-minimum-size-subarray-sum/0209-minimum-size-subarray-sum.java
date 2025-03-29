class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd]; // Add the next element

            // Shrink the window as small as possible until the window's sum is smaller than K
            while (windowSum >= target) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart]; // Subtract the element going out
                windowStart++; // Slide the window ahead
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }  
}