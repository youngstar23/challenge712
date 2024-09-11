package com.yang.algorithm.leetcode.SlidingWindows;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/21 10:55
 * @Version: 1.0
 */
public class LC_08_0209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        long total = 0;
        int res = nums.length + 1;
        for (int right = 0, left = 0; right < nums.length; right++) {
            total += nums[right];
            while (total - nums[left] >= target) {
                total -= nums[left++];
            }
            if (total >= target) {
                res = Math.min(res, right - left + 1);
            }
        }
        return res > nums.length ? 0 : res;
    }
}
