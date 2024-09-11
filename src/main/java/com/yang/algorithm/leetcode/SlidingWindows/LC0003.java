package com.yang.algorithm.leetcode.SlidingWindows;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/5 23:29
 * @Version: 1.0
 */
public class LC0003 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            map.put(alpha, map.getOrDefault(alpha, 0) + 1);
            while (map.get(alpha) > 1) {
                char leftAlpha = s.charAt(start);
                map.put(leftAlpha, map.get(leftAlpha) - 1);
                start++;
            }
            ans = Math.max(ans, end- start + 1);
        }
        return ans;
    }
}
