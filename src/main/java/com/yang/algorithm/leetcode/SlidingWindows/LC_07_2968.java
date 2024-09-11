package com.yang.algorithm.leetcode.SlidingWindows;

import java.util.Arrays;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/17 19:55
 * @Version: 1.0
 */
public class LC_07_2968 {
    public static void main(String[] args) {
        System.out.println(maxFrequencyScore(new int[]{1, 2, 6, 4}, 3));
    }

    public static int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        long[] acc = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            acc[i + 1] = acc[i] + nums[i];
        }
        int res = 0;
        for (int right = 0, left = 0; right < nums.length; right++) {
            while (left <= right && distance(acc, nums, left, right, (right + left) / 2) > k) {
                ++left;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    private static long distance(long[] acc, int[] nums, int left, int right, int mid) {
        long leftSum = (long)nums[mid] * (mid - left) - (acc[mid] - acc[left]);
        long rightSum = (acc[right + 1] - acc[mid + 1]) - (long)nums[mid] * (right - mid);
        return leftSum + rightSum;
    }
}
