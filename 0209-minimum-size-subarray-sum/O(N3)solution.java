public class Main {
    public static void main(String[] args) {
        int target = 7;
        int [] nums = {2,3,1,2,4,3};
        int j=0;
        int k=0;
        int summ = 0;
        for(int i=1;i<=nums.length;i++) {
            while (k+i<=nums.length) {
                for(j=k;j<k+i;j++) {
                    summ = summ + nums[j];
                    if (summ>=target) {
                        //return i;
                        System.out.println(i);
                        return;
                    }

                }
                summ = 0;
                k++;
            }
            k=0;
        }
        //return 0;
        System.out.println(0);
    }
}
