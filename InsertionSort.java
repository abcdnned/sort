import java.util.Arrays;

public class InsertionSort {
    
    public void sort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            int k = a[i]; //将带排序元素记录下来，腾出空位供前面的元素向后挪动
            int j = i - 1;
            while (j >= 0 && a[j] < k) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;
        }
    }


    public static void main(String[] args) {
        int[] a = { 1, 5, 9, 22, 7, 3, 8, 6, 7, 21, 19};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

/*
 * 适用于基本有序的数组。主要性能消耗在移动元素上，比较消耗的时间相对很小，所以适合对长度一定且基本有序的数组排序。
 */
