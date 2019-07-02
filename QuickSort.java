public class QuickSort {
    
    public void quickSort(int[] n, int left, int right) {
        if (left < right) {
            int pivot = partition(n, left, right);
            quickSort(n, left, pivot - 1);
            quickSort(n, pivot + 1, right);
        }
    }

    private int partition(int[] n, int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot) {
                right--;
            }
            n[left] = n[right];
            while (left < right && n[left] <= pivot) {
                left++;
            }
            n[right] = n[left];
        }
        n[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 8, 2, 1, 0, 7, 3, 4, 5, 9, 6, 3 };
        QuickSort s = new QuickSort();
        s.quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }
}

/*
 * 将数组分成比中位数小和比中位数大的两部分，各部分不要求有序，再对每部分重复应用上述过程。
 * 将数组根据中位数大小比较结果分为两组，再对这两组进行分别排序。
 * 对单链表进行快排存在两个问题，partition时需有两个指针，一个从前往后扫一个从后往前扫，单链表实现后者比较麻烦。
 *
 * 时间复杂度：当选取的中位数是最大或者最小值的时候，O(n^2)。当选到中位数的时候就是O(nlogn)。
 * 
 * 稳定性：不稳定
 * 和归并排序同属于分治算法
 *
