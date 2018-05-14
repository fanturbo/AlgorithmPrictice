package com.turbo.test.other;

/**
 * 查找第k大的数
 */
public class FindK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, 4, 15, 7, 11, 15, 5};
        int target = findK(nums, 0, nums.length - 1, 2);
        System.out.print("target = " + target);
    }

    public static int findK(int[] array, int left, int right, int k) {
        int i = partition(array, left, right);
        if (i == k - 1) {
            return array[k - 1];
        } else if (i > k - 1) {
            return findK(array, left, i - 1, k);
        } else if (i < k - 1) {
            return findK(array, i + 1, right, k);
        }
        return 0;
    }

    private static int partition(int[] array, int left, int right) {
        int i = left, j = right;
        int index = array[i];
        while (i < j) {
            while (i < j && array[j] >= index) {
                j--;
            }
            if (i < j)
                array[i++] = array[j];
            while (i < j && array[i] < index) {
                i++;
            }
            if (i < j)
                array[j--] = array[i];
        }
        array[i] = index;
        return i;
    }
}
