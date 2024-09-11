package com.yang.algorithm.acwing.Week24025;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/1 23:27
 * @Version: 1.0
 */
public class LC2461 {
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum123321(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
    }

    public static long maximumSubarraySum123321(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        long res = 0;
        if (map.size() == k) {
            res = sum;
        }
        for (int i = k; i < n; i++) {
            int left = nums[i - k];
            int right = nums[i];
            map.put(left, map.getOrDefault(left, 0) - 1);
            if (map.get(left) == 0) {
                map.remove(left);
            }
            map.put(right, map.getOrDefault(right, 0) + 1);
            sum = sum - left + right;
            if (map.size() == k) {
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
