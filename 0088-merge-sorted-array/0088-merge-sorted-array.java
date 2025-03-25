class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //int[] nums1 = {1,2,3,0,0,0};
        //int m = 3;
        //int[] nums2 = {2,5,6};
        //int n = 3;
        boolean nums2ended = false;
        boolean tempended = false;
        int[] temp = Arrays.copyOf(nums1,m);
        int j = 0;
        int k = 0;
        if (m==0 & n!=0) {
            for (int i=0;i<n;i++) {
                nums1[i]=nums2[i];
            }
            return;
        }
        if (m!=0 & n==0) {
            for (int i=0;i<m;i++) {
                nums1[i]=temp[i];
            }
            return;
        }
        for(int i=0;i<m+n;i++){
            if (nums2ended) {
                nums1[i]=temp[j];
                j++;
                continue;
            }
            if (tempended) {
                nums1[i]=nums2[k];
                k++;
                continue;
            }
            if (temp[j]>=nums2[k]) {
                nums1[i]=nums2[k];
                k++;
                if (k==n) {
                    nums2ended = true;
                }
            }   else {
                nums1[i]=temp[j];
                j++;
                if (j==m) {
                    tempended = true;
                }
            }
        }
        for (int i=0;i<m+n;i++) {
            System.out.println(nums1[i]);
        }
    }
}