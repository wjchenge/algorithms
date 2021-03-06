package wjchenge.arithmetic;

import java.util.Arrays;

/**
 * 快速排序
 * @author wjchenge
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{4,8,2,1,6,3,5};
        System.out.println(Arrays.toString(a));
        QuickSort.quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a) {
        if (a == null || a.length == 0) return;
        doQuickSort(a, 0, a.length - 1);
    }

    //[l,r]
    private static void doQuickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = QuickSort.partition(a, l, r);
        QuickSort.doQuickSort(a, l, p);
        QuickSort.doQuickSort(a, p + 1, r);

    }

    private static int partition(int[] a, int l, int r) {
        //[l + 1,i] < v [i + 1, j) >= v
        int i = l;
        int j = l + 1;
        int value = a[l];
        while (j <= r) {
            if (a[j] < value) {
                SortUtil.swap(a, ++i, j++);
            } else {
                ++j;
            }
        }
        SortUtil.swap(a, l, i);
        return i;
    }
}
