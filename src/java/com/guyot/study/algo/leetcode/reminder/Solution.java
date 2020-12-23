package com.guyot.study.algo.leetcode.reminder;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 提交失败题目查漏补缺
 * @date 2020/12/22
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null) return new String[0];
        Map<Integer, Integer> map = new TreeMap<>((a, b)-> b - a);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        String[] res = new String[nums.length];

        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer i = entry.getValue();
            if (rank == 1) {
                res[i] = "Gold Medal";
            } else if (rank == 2) {
                res[i] = "Silver Medal";
            } else if (rank == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = String.valueOf(rank);
            }
            ++rank;
        }
        return res;
    }

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character,Integer> patternMap = new HashMap();
        Map<String,Integer> strsMap = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            if (patternMap.put(pattern.charAt(i), i) != strsMap.put(strs[i], i)) {
                return false;
            }
        }
        return true;
    }


}
