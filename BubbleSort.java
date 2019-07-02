import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = { 1, 3, 23, 9, 8, 45, 7, 2, 6, 23, 17, 13, 88 };
        for (int i = 0; i < a.length - 1; ++i) {
            for (int j = 0; j < a.length - i - 1; ++j) {
                if (a[j] < a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}

/*
 * 稳定排序
 * 平均情况下O(n^2)
 * 最好情况下，数组已经有序，此时时间复杂度为O(n)
 * 空间复杂度为O(1)
 */
