import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        Collections.rotate(Arrays.asList(nums), k);
        System.out.println(Arrays.toString(nums));
    }
}
