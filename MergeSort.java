import java.util.Arrays;

public class MergeSort {

    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; //***
        int n2 = r - m; //***
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) //***
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) //***
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 

    public static void main(String[] args) {
        int[] a = { 1, 45, 23, 17, 8, 9, 10, 89, 40, 32, 22, 8, 23, 5, 31 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}

/*
 * 将一个数组的排序问题分解成两个数组的排序问题加上这两个数组的合并
 * 将数组分成两部分，对这两部分分别进行归并排序，然后对这两部分进行一次归并排序
 * 将原数组拆成两个，对它们分别进行排序后合并
 * 拆分合并
 * 时间复杂度：nlogn
 * 空间复杂度：n
 * 稳定性：稳定
 * 应用场景：单链表做合并排序的空间复杂度为O(1), 
 *           对数据的随机存储要求低。
 * 属于分治算法
 */
