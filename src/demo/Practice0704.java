package demo;

import java.util.Arrays;

import static wjchenge.arithmetic.SortUtil.isOrdered;
import static wjchenge.arithmetic.SortUtil.swap;

public class Practice0704 {
    public static void main(String[] args) {
        int[] a = {65,78,34,2,1,4,5,38,12,2,78,2,4,3};
        System.out.println(Arrays.toString(a));
//        bubbleSort(a, a.length);
//        insertSort(a, a.length);
//        selectSort(a, a.length);
//        mergeSort(a, 0, a.length - 1);
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(isOrdered(a, 1));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;
        int p = doQuickSort(a, left, right);
        quickSort(a, left, p - 1);
        quickSort(a, p + 1, right);
    }

    private static int doQuickSort(int[] a, int left, int right) {
        int val = a[left];
//        [left + 1, i] < val [i + 1, j) >= val
        int i = left;
        int j = left + 1;
        while (j <= right) {
            if (a[j] < val) {
                swap(a, ++i, j);
            }
            ++j;
        }
        swap(a, i, left);
        return i;
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        doMergeSort(a, left, mid, right);
    }

    private static void doMergeSort(int[] a, int left, int mid, int right) {
        int[] tmp = a.clone();
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid || j <= right) {
            if (i > mid) {
                a[k++] = tmp[j++];
            } else if (j > right) {
                a[k++] = tmp[i++];
            } else if (tmp[i] < tmp[j]) {
                a[k++] = tmp[i++];
            } else {
                a[k++] = tmp[j++];
            }
        }
    }

    private static void selectSort(int[] a, int length) {
        int minval, minIndex;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            minval = a[i];
            for (int j = i + 1; j < length; j++) {
                if (a[j] < minval) {
                    minIndex = j;
                    minval = a[j];
                }
            }
            swap(a, minIndex, i);
        }
    }

    private static void insertSort(int[] a, int length) {
        for (int i = 1; i < length; i++) {
            int val = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > val) {
                a[j] = a[--j];
            }
            a[j] = val;
        }
    }

    private static void bubbleSort(int[] a, int length) {
        boolean b = true;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    swap(a, j, j + 1);
                    b = false;
                }
            }
            if (b) break;
        }
    }
}
