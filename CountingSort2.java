import java.util.Arrays;

public class CountingSort2 {

    static int[] sort(int[] a) {
        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];

        for (int i = 0; i < a.length; ++i) {
            count[a[i] - min]++;
        }

        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1]; //***
        }

        int[] result = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            result[count[a[i] - min] - 1] = a[i]; //***
            count[a[i] - min]--;
        }

        return result;
    }
    
    public static void main(String[] args) {
        int[] a = {-5, -10, 0, -3, 8, 5, -1, 10}; 
        int[] b = sort(a);
        System.out.println(Arrays.toString(b));
    }
}

/*
 * 时间复杂度O(n+k)，n是排序数量，k是范围
 * 空间复杂度O(n+k)，n是排序数量，k是范围
 * 是否稳定，不稳定
 * 使用场景：整数，范围不要太大
 */
