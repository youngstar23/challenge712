package com.yang.algorithm.leetcode.SlidingWindows;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/8/4 21:07
 * @Version: 1.0
 */
public class LC_13_0930 {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int[] dp = new int[2];
        for (int right = 0, left = 0; right < nums.length; right++) {
            ++dp[nums[right]];
            while (dp[1] > goal) {
                --dp[nums[left++]];
            }
            if (left <= right && dp[1] == goal) {
                int curPos = left;
                while (curPos < right && nums[curPos] == 0) {
                    ++curPos;
                }
                res += (curPos - left + 1);
            }
        }
        return res;
    }
}
