package com.yang.algorithm.leetcode.SlidingWindows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/15 21:21
 * @Version: 1.0
 */
public class LC_06_2831 {
    public static void main(String[] args) {
        System.out.println(longestEqualSubarray(Arrays.asList(1,1,2,2,1,1), 2));
    }

    public static int longestEqualSubarray(List<Integer> nums, int k) {
        int res = 0;
        int right = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.size()) {
            map.put(nums.get(right), map.getOrDefault(nums.get(right), 0) + 1);
            while (left < nums.size() && (right - left + 1 - map.get(nums.get(left)) > k)) {
                map.put(nums.get(left), map.get(nums.get(left)) - 1);
                ++left;
            }
            res = Math.max(res, map.get(nums.get(right)));
            ++right;
        }
        return res;
    }
}
