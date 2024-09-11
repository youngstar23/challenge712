package com.yang.algorithm.acwing.Week24025;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/6/30 21:14
 * @Version: 1.0
 */
public class LC1343 {
    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int compare = threshold * k;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= compare) {
            ++res;
        }
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            if (sum >= compare) {
                ++res;
            }
        }
        return res;
    }
}
