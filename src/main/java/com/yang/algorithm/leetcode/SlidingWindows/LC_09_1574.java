package com.yang.algorithm.leetcode.SlidingWindows;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/24 20:20
 * @Version: 1.0
 */
public class LC_09_1574 {
    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            --right;
        }
        if (right == 0) {
            return 0;
        }
        int ans = right;
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; left++) {
            while (right < arr.length && arr[left] > arr[right]) {
                ++right;
            }
            ans = Math.min(ans, right - 1 - left);
        }
        return ans;
    }
}
