class Solution {
    public int removeDuplicates(int[] nums) {
        int filler = 10001;
        int k = nums.length;
        int j;
        boolean firstTimeMet = false;
        boolean metBefore = false;
        for(int i=0;i<nums.length;i++) {
            if (i==nums.length-1) {
                break;
            } else {
                j = i + 1;
            }
            while(nums[i]==nums[j]) {
                if (metBefore == false) 
                {
                    firstTimeMet = true;
                    metBefore = true;
                }
                if (firstTimeMet==false) {   
                nums[j]=filler;
                k--;
                }
                if(firstTimeMet == true & metBefore == true) {
                    firstTimeMet = false;
                }
                if(j==nums.length-1) {
                    break;
                } else {
                    j++;
                }
            }
            i=j-1;
            metBefore=false;
            firstTimeMet = false;
        }
        Arrays.sort(nums);
        return k;        
    }
}