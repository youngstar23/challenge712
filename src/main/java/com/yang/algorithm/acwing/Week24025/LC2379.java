package com.yang.algorithm.acwing.Week24025;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/6/30 22:32
 * @Version: 1.0
 */
public class LC2379 {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WB", 1));
    }

    public static int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            if (chars[i] == 'B') {
                ++sum;
            }
        }
        int res = sum;
        for (int i = k; i < chars.length; i++) {
            if (chars[i] == 'B') {
                ++sum;
            }
            if (chars[i - k] == 'B') {
                --sum;
            }
            res = Math.max(res, sum);
        }
        return k - res;
    }
}
