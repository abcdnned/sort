import java.util.Arrays;

public class HeapSort2 
{ 
    static void heapify(int arr[], int n, int i) {
        System.out.println("i: " + i);
        int root = i;
        int l = root * 2 + 1;
        int r = root * 2 + 2;
        int largest = l;
        while (l <= n - 1) {
            System.out.println(String.format("left: %d right: %d root: %d", l, r, root));
            if (r < n && arr[l] < arr[r]) {
                largest = r;
            }
            if (arr[largest] > arr[root]) {
                int swap = arr[largest];
                arr[largest] = arr[root];
                arr[root] = swap;
            } else {
                break;
            }
            root = largest;
            l = root * 2 + 1;
            r = root * 2 + 2;
            largest = l;
            System.out.println(Arrays.toString(arr)); 
        }
    }

    static void sort(int a[]) {
        for (int i = a.length/2 - 1; i >= 0; i--) {
            heapify(a, a.length, i);
        }
        int i = a.length - 1;
        while(i >= 0) {
            int swap = a[0];
            a[0] = a[i];
            a[i] = swap;
            heapify(a, i, 0);
            i--;
        }
    }
  
  
    // Driver program 
    public static void main(String args[]) 
    { 
        int[] arr = new int[] { 3, 1, 8, 9, 5, 4, 7, 6 };
        sort(arr);
        System.out.println("sort result: " + Arrays.toString(arr)); 
    } 
} 
