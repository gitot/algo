package com.guyot.study.algo;

import java.util.Objects;

public class Sort {

    /**
     * 插入排序。
     * 《算法导论》 P10
     *
     * @param nums
     */
    void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
    }

    private void print(int[] nums) {
        for (int i : Objects.requireNonNull(nums)) {
            System.out.print(i + " ");
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 1, 7, 2};
        Sort sort = new Sort();
        sort.insertSort(nums);
        sort.print(nums);
    }
}
