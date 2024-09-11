package com.yang.algorithm.acwing.Week24025;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/6/30 22:46
 * @Version: 1.0
 */
public class LC1052 {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int res = sum;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }
        res = Math.max(res, sum);
        for (int i = 1; i <= n - minutes; i++) {
            if (grumpy[i - 1] == 1) {
                sum -= customers[i - 1];
            }
            if (grumpy[i + minutes - 1] == 1) {
                sum += customers[i + minutes - 1];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
