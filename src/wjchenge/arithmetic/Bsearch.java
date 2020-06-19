package wjchenge.arithmetic;

/**
 * 二分查找算法
 * @author wjchenge
 */
public class Bsearch {

    /**
     * 通过二分查找查询指定值所在的索引
     * @param a 需要查找数据的数组
     * @param value 需要查找的值
     * @return 返回指定值所在的索引,没查询到返回-1
     */
    public static int bsearch(int[] a, int value){
        int result = -1;
        if (a == null || a.length == 0) return result;
        int l = 0;
        int r = a.length;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 假定数组从小到大排序，其中存在重复元素，查找给定的值第一次出现的位置
     * @param a
     * @param value
     * @return
     */
    public static int bsearchFirst(int[] a, int value){
        int result = -1;
        if (a == null || a.length == 0) return result;
        int l = 0;
        int r = a.length;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] == value) {
                if (mid == 0 || (a[mid - 1]) != value) return mid;
                r = mid - 1;
            } else if (a[mid] > value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 假定数组从小到大排序，其中存在重复元素，查找给定的值最后一次出现的位置
     * @param a
     * @param value
     * @return
     */
    public static int bsearchLast(int[] a, int value){
        int result = -1;
        if (a == null || a.length == 0) return result;
        int l = 0;
        int r = a.length;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] == value) {
                if (mid == 0 || (a[mid + 1]) != value) return mid;
                l = mid + 1;
            } else if (a[mid] > value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 假定数组从小到大排序，其中存在重复元素，查找第一个大于等于给定值的元素出现的位置
     * @param a
     * @param value
     * @return
     */
    public static int bsearchFirstGE(int[] a, int value){
        int result = -1;
        if (a == null || a.length == 0) return result;
        int l = 0;
        int r = a.length;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || (a[mid - 1]) < value) return mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 假定数组从小到大排序，其中存在重复元素，查找最后一个小于等于给定值的元素出现的位置
     * @param a
     * @param value
     * @return
     */
    public static int bsearchFirstLE(int[] a, int value){
        int result = -1;
        if (a == null || a.length == 0) return result;
        int l = 0;
        int r = a.length;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] <= value) {
                if (mid == 0 || (a[mid + 1]) > value) return mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = SortUtil.getOrderArray(100);
        System.out.println(bsearch(a, 55));
        for (int i = 55; i < 66; i++) {
            a[i] = 55;
        }
        System.out.println(bsearchFirst(a, 55));
        System.out.println(bsearchLast(a, 55));
        System.out.println(bsearchFirstGE(a, 53));
        System.out.println(bsearchFirstLE(a, 55));
    }
}
