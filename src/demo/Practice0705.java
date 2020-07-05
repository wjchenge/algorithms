package demo;

import java.util.*;

import static wjchenge.arithmetic.SortUtil.isOrdered;
import static wjchenge.arithmetic.SortUtil.swap;

public class Practice0705 {
    public static void main(String[] args) {
//        System.out.println(reverseVowels("hello"));
//        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
//        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
//        System.out.println(findLongestWord("aaa", Arrays.asList("aaa","aa","a")));
        System.out.println(findLongestWord("bab", Arrays.asList("ba","ab","a","b")));
    }

    public static String findLongestWord(String s, List<String> d) {
        String result = "";
        if (s == null || s.length() == 0 || d == null || d.isEmpty()) return result;
        for (String str : d) {
            if (str == null
                    || str.length() == 0
                    || str.length() > s.length()
                    || result.length() > str.length()
                    || (result.length() == str.length() && result.compareTo(str) < 0)) {
                continue;
            }
            // 双指针遍历 i 和 j分别指向 s 和 str
            int i = 0;
            int j = 0;
            while (i < s.length()) {

                if (s.charAt(i) == str.charAt(j)) {
                    ++i;
                    ++j;
                } else {
                    ++i;
                }

                if (j == str.length()) {
                    result = str;
                    break;
                }
            }
        }
        return result;
    }


    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (slowNode != null && fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) return true;

        }
        return false;
    }

      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - n - 1; //nums1 起始索引
        int j = n - 1; // nums2 起始索引
        int k = m - 1; // 归并起始索引
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            } else if (j < 0) {
                --i;
            } else if (nums1[i] > nums2[j]) {
                nums1[k--] = nums2[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }



    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        boolean b = true; //可以删除一个
        while (i < j) {
            if (chars[i] != chars[j]) {
                return isPalindrome(chars, i + 1, j) || isPalindrome(chars, i, j - 1);
            }
            ++i;
            --j;
        }
        return true;
    }

    private static boolean isPalindrome(char[] chars, int i, int j) {
        if (i >= j) return false;
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }


    public static String reverseVowels(String s) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            if(!vowelsSet.contains(chars[i])) {
                ++i;
            } else if (!vowelsSet.contains(chars[j])) {
                --j;
            } else {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }


        }
        return new String(chars);
    }



}
