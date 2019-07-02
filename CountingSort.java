import java.util.Arrays;

public class CountingSort {

    static int[] sort(int[] a) {
        int[] count = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            count[a[i]]++;
        }
        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }
        int [] result = new int[a.length];
        for (int i = a.length - 1; i >= 0; --i) {
            result[count[a[i]] - 1] = a[i];
            count[a[i]]--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {8, 2, 3, 5, 3, 7, 1, 7, 9, 6, 4, 2};
        int[] result = sort(a);
        System.out.println(Arrays.toString(result));
    }
}
