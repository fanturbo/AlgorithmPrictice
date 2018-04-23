package com.turbo.test.other;

import java.util.Arrays;

/**
 *
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9, 10, 7, 78, 5, 4, 3, 2, 100};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = (arr.length - 2) / 2; i > 0; i--) {
            adjusHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);//交换堆顶元素和堆底元素
            adjusHeap(arr, i, arr.length);
        }
    }

    /**
     * 调整堆
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjusHeap(int[] arr, int i, int length) {
        int temp = arr[i];//暂存父节点
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k + 1] > arr[k]) {//比较左右子节点找出最大的
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
