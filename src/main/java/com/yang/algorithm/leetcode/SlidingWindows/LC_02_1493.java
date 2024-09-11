package com.yang.algorithm.leetcode.SlidingWindows;

import java.util.Arrays;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/7 19:31
 * @Version: 1.0
 */
public class LC_02_1493 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 1, 1}));
    }

    public static int longestSubarray(int[] nums) {
        if (Arrays.stream(nums).sum() == nums.length) {
            return nums.length - 1;
        }
        int n = nums.length;
        int res = 0;
        int left = 0;
        int pos = 0;
        while (left < n) {
            int right = left;
            boolean usedFlag = false;
            while (right < n) {
                if (nums[right] == 1) {
                    res = Math.max(right - left + 1 - (usedFlag ? 1 : 0), res);
                    ++right;
                } else {
                    if (usedFlag == false) {
                        pos = right;
                        usedFlag = true;
                        ++right;
                    } else{
                        left = pos + 1;
                        break;
                    }
                }
            }
            if (right >= n) {
                break;
            }
        }
        return res;
    }
}
