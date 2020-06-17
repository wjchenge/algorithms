package wjchenge.arithmetic;

/**
 * 排序工具类
 * @author wjchenge
 */
public class SortUtil {

    /**
     * 异或法交换数组中的两个元素
     * @param a 要交换元素的数组
     * @param i 要交换元素的第一个坐标
     * @param j 要交换元素的第二个坐标
     */
    public static void swap(int[] a, int i, int j) {
        if (a[i] != a[j]) {
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
    }

    /**
     * 临时变量法交换数组中的两个元素
     * @param a 要交换元素的数组
     * @param i 要交换元素的第一个坐标
     * @param j 要交换元素的第二个坐标
     */
    public static void swapByTemp(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 判断数组是否有序
     * @param a 需要验证的数组
     * @param type 1 正序从小到大 2 倒序从大到小
     * @return
     */
    public static boolean isOrdered(int[] a, int type) {
        if (a == null || a.length == 0) return true;
        int value = a[0];
        for (int i = 1; i < a.length; i++) {
            if (type == 1 && a[i] < value) {
                return false;
            } else if (type == 2 && a[i] > value) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成随机数组
     * @param size 数组大小
     * @param max 随机因子大小
     * @return
     */
    public static int[] getRandomArray(int size, int max) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * max);
        }
        return a;
    }

    /**
     * 生成顺序数组
     * @param size 数组大小
     * @return
     */
    public static int[] getOrderArray(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        return a;
    }

}
