package wjchenge.arithmetic;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{4,8,2,1,6,3,5};
        System.out.println(Arrays.toString(a));
        BubbleSort.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a) {
        if (a == null || a.length == 0) return;
        int length = a.length;
        boolean flag;
        for (int i = 0; i < length - 1; ++i) {
            flag = true;
            for (int j = 0; j < length - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    a[j] = a[j] ^ a[j + 1];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j] ^ a[j + 1];
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

}
