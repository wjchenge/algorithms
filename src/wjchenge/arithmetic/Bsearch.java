package wjchenge.arithmetic;

/**
 * 二分查找算法
 * @author user
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
            int mid = l + (r - l) /2;
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

    public static void main(String[] args) {
        int[] a = SortUtil.getOrderArray(100);
        System.out.println(bsearch(a, 99));
    }
}
