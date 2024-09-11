package com.yang.algorithm.leetcode.SlidingWindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/28 23:00
 * @Version: 1.0
 */
public class LC_10_2799 {
    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}));
    }

    public static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.merge(ele, 1, Integer::sum);
            while (map.size() == set.size()) {
                if (map.merge(nums[left], -1, Integer::sum) == 0) {
                    map.remove(nums[left]);
                }
                ++left;
            }
            res += left;
        }
        return res;
    }
}
