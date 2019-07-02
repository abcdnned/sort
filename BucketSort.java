import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    static float[] sort(float[] a) {
        ArrayList<ArrayList<Float>> ls = new ArrayList<>(a.length);
        for (int i = 0; i < a.length; ++i) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < a.length; ++i) {
            int j = ((int)(a.length * a[i]));
            ls.get(j).add(a[i]);
        }
        for (int i = 0; i < ls.size(); ++i) {
            Collections.sort(ls.get(i));
        }
        float[] b = new float[a.length];
        int index = 0;
        for (int i = 0; i < ls.size(); ++i) {
            for (Float f: ls.get(i)) {
                b[index++] = f;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        float[] a = {0.17f, 0.37f, 0.89f, 0.67f, 0.74f, 0.33f, 0.37f, 0.23f, 0.29f, 0.79f};
        float[] b = sort(a);
        System.out.println(Arrays.toString(b));
    }
}

/*
 * 时间复杂度：O(n + k) k是桶大小, 最坏情况下O(n^2)如果所有元素都被分配到一个桶里，且底层使用的是插入排序，可以用快速排序将速度优化到O(nlogn)
 * 空间复杂度：O(n + k) k是桶大小
 * 稳定性取决于底层排序算法
 * 使用场景：数组均匀分布
 * 
 * function bucketSort(array, k) is
 * buckets ← new array of k empty lists
 * M ← the maximum key value in the array
 * for i = 1 to length(array) do
 *   insert array[i] into buckets[floor(array[i] / M * k)]
 * for i = 1 to k do
 *   nextSort(buckets[i])
 * return the concatenation of buckets[1], ...., buckets[k]
 *
 * 将元素分布到桶中，对每个桶分别排序，合并所有桶
 *
 */
