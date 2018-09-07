package com.turbo.test.javaoffer;

/**
 * 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class No1 {
    public static void main(String[] args) {
        int[][] array = {
                {0, 1, 3, 4, 5, 7, 8, 11, 13, 15, 18, 21, 24, 27, 30, 32, 35, 36, 39, 41, 42, 43, 46, 49, 52, 55, 58, 60, 63, 66, 67, 69, 72, 75, 78, 80, 81, 82, 85, 86},
                {1, 4, 6, 8, 11, 12, 15, 17, 18, 20, 23, 24, 27, 30, 33, 34, 38, 39, 42, 44, 47, 48, 51, 52, 55, 57, 59, 62, 64, 67, 70, 72, 75, 77, 81, 83, 84, 87, 90, 91},
                {4, 7, 8, 11, 14, 16, 18, 20, 21, 24, 27, 29, 32, 35, 36, 39, 40, 42, 44, 46, 49, 52, 54, 56, 58, 60, 61, 64, 67, 70, 73, 76, 78, 81, 84, 87, 89, 91, 93, 96},
                {5, 8, 10, 13, 15, 19, 21, 23, 24, 27, 29, 31, 34, 37, 38, 41, 43, 45, 46, 49, 52, 55, 58, 59, 61, 64, 67, 69, 71, 72, 76, 78, 79, 83, 87, 90, 91, 94, 96, 97},
                {6, 11, 14, 16, 18, 22, 24, 27, 29, 32, 33, 35, 36, 40, 42, 44, 47, 50, 51, 52, 54, 58, 60, 62, 64, 67, 70, 73, 76, 79, 82, 84, 87, 88, 91, 94, 97, 99, 101, 102}
        };
        boolean find = Find(22, array);
        System.out.println(find);
    }

    public static boolean Find(int target, int[][] array) {
        //对于数组中的任何一个元素, 比它小的元素都在它的左方或者上方, 比它大的元素都在它的右边或者下方
        //但是这两个区域还有可能有重叠，比如右边或下边会在右下角有重叠。
        //为了不重复的处理重叠的数据, 以右上角为起点，因为每个一维数组的长度相同，所以取0号一维数组的长度
        for (int i = array[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] == target) return true;
                if (array[j][i] > target) break;
                if (array[j][i] < target) continue;
            }
        }
        return false;
    }

    public static boolean horizontalSearch(int target, int[][] array, int rowNum) {

        return false;
    }

    public static boolean verticalSearch(int target, int[][] array, int coloumNum) {
        return false;
    }
}
