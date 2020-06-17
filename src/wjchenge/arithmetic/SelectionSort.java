package wjchenge.arithmetic;

import java.util.Arrays;

/**
 * 选择排序
 * @author wjchenge
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[]{4,8,2,1,6,3,5};
        System.out.println(Arrays.toString(a));
        SelectionSort.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionSort(int[] a) {
        if (a == null || a.length == 0) return;
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            int minValue = a[i];
            for (int j = i; j < a.length; j++) {
                if (a[j] < minValue) {
                    minValue = a[j];
                    minIndex = j;
                }
            }
            if (minIndex > i) {
                SortUtil.swap(a, i, minIndex);
            }
        }
    }
}
