package com.yang.algorithm.leetcode.SlidingWindows;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/7 20:07
 * @Version: 1.0
 */
public class LC_03_0904 {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] dp = new int[n + 1];
        int res = 0;
        int total = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (++dp[fruits[i]] == 1) {
                ++total;
                while (total > 2) {
                    if (--dp[fruits[j++]] == 0) {
                        --total;
                    }
                }
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
