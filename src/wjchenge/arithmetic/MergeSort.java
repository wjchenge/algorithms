package wjchenge.arithmetic;

import java.util.Arrays;

/**
 * 归并排序
 * @author wjchenge
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{4,8,2,1,6,3,5};
        System.out.println(Arrays.toString(a));
        MergeSort.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a) {
        if (a == null || a.length == 0) return;
        doMergeSort(a, 0, a.length - 1);
    }

    //[0, l] [l + 1, r]
    private static void doMergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        doMergeSort(a, l , mid);
        doMergeSort(a, mid + 1 , r);
        doMerge(a, l, mid, r);

    }

    private static void doMerge(int[] a, int l, int p, int r) {
        int[] tmp = a.clone();
        int k = l;//排序后数据的索引
        int i = l;
        int j = p + 1;
        while (i <= p || j <= r ) {
            if (i > p) {
                a[k++] = tmp[j++];
            } else if (j > r) {
                a[k++] = tmp[i++];
            } else if (tmp[i] < tmp[j]) {
                a[k++] = tmp[i++];
            } else {
                a[k++] = tmp[j++];
            }
        }

    }
}
