import java.util.Arrays;

public class HeapSort 
{ 
    static void heapify(int[] a, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && a[left] < a[largest])
            largest = left;
        if (right < n && a[right] < a[largest])
            largest = right;
        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;
            heapify(a, largest, n);
        }
    }

    static void sort(int[] a) {
        int i = a.length - 1;
        while (i >= 0) {
            int swap = a[0];
            a[0] = a[i];
            a[i] = swap;
            heapify(a, 0, i);
            i--;
        }
    }
  
    // Driver program 
    public static void main(String args[]) 
    { 
        //int[] arr = new int[] { 3, 1, 8, 9, 5, 4, 7, 6 };
        int[] arr = new int[] { 1, 3, 6, 9, 12, 30, 43, 7, 22 };

        //构建堆
        int i = arr.length/2 - 1; //最后一个非叶子节点
        while (i >= 0) {
            heapify(arr, i, arr.length);
            i--;
        }
        System.out.println("heap built: " + Arrays.toString(arr));

        sort(arr);
        System.out.println("sort result: " + Arrays.toString(arr));

  
    } 
} 

/*
 * 将数组构建成堆，具体方法是对每个节点，如果它比孩子小，那么将它和孩子中的最大值互换，然后继续向下调整
 *
 * heapify的过程：求出父节点和孩子节点中的最大值的index记录在largest指针中。如果largest不是root节点，则将largest和root节点互换。继续以largest节点为根节点进行heapify操作。
 *
 * 时间复杂度：O(nlogn),heapify方法的时间复杂度是O(logn)
 * 空间复杂度是O(1)，原地排序
 * 不稳定的排序
 *
 * 对于新值能够增量的进行排序
 * 如果数据是源源不断地产生，可以用对排序
 *
 */
