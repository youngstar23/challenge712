package com.yang.algorithm.leetcode.SlidingWindows;

import java.util.Arrays;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/12 23:48
 * @Version: 1.0
 */
public class LC_04_1838 {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 1, 1, 1}, 1));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, sum = 0;
        int res = 0;
        while(right < nums.length) {
            sum += nums[right];
            while (nums[right] * (right - left + 1) - sum > k && left < nums.length) {
                sum -= nums[left++];
            }
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }
}
