package com.turbo.test.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, 4, 15, 7, 11, 15, 5};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i : ints)
            System.out.print(i + " ");
    }

    /**
     * 时间复杂度（n*n)，循环遍历o(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result = new int[]{i, j};
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度o(n) 但是空间复杂度为o(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.get(tmp) != null) {
                result = new int[]{map.get(tmp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        //使用快排排序数组
        quickSort(nums, 0, nums.length - 1);
        int[] result = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                break;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    private static void quickSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        if (i >= j) return;
        int index = nums[i];
        while (i < j) {
            while (i < j && nums[j] > index)
                j--;
            if (i < j)
                nums[i++] = nums[j];
            while (i < j && nums[i] < index)
                i++;
            if (i < j)
                nums[j--] = nums[i];
        }
        nums[i] = index;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
