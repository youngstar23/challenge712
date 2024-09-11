package com.yang.algorithm.leetcode.SlidingWindows;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/30 22:31
 * @Version: 1.0
 */
public class LC_11_2762 {
    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5, 4, 2, 4}));
    }

    public static long continuousSubarrays(int[] nums) {
        long res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int right = 0, left = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > 2) {
                map.merge(nums[left], -1, Integer::sum);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                ++left;
            }
            res += right - left + 1;
        }
        return res;
    }

    public static long continuousSubarraysTimeOut(int[] nums) {
        long res = 0;
        for (int right = 0, left = 0; right < nums.length; right++) {
            int curPos = right - 1;
            while (left <= curPos && Math.abs(nums[right] - nums[curPos]) <= 2) {
                --curPos;
            }
            left = curPos + 1;
            res += (right - curPos);
        }
        return res;
    }

    public static long continuousSubarrays2(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long res = 0;
        for (int right = 0, left = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > 2) {
                map.merge(nums[left], -1, Integer::sum);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                ++left;
            }
            res += right - left + 1;
        }
        return res;
    }
}
