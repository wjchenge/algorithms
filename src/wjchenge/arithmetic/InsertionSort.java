package wjchenge.arithmetic;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = new int[]{4,8,2,1,6,3,5};
        System.out.println(Arrays.toString(a));
        InsertionSort.insertionSort(a);
        InsertionSort.insertionSort2(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] a) {
        if (a == null || a.length == 0) return;
        for (int i = 1; i < a.length; ++i) {
            int j = i;
            while (j > 0) {
                if (a[j] < a[j - 1]) {
                    a[j] = a[j] ^ a[j - 1];
                    a[j - 1] = a[j] ^ a[j - 1];
                    a[j] = a[j] ^ a[j - 1];
                } else {
                    break;
                }
                --j;
            }
        }
    }

    public static void insertionSort2(int[] a) {
        if (a == null || a.length == 0) return;
        for (int i = 1; i < a.length; ++i) {
            int j = i;
            int tmp = a[i];
            while (j > 0 && tmp < a[j - 1]) {
                    a[j] =  a[--j];
            }

            if (i != j) {
                a[j] = tmp;
            }
        }
    }
}
