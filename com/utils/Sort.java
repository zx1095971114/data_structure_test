package com.utils;

/**
 * @projectName: data-structure-test
 * @package: com.utils
 * @className: Sort
 * @author: Zhou xiang
 * @description: 常用的排序算法,ps:所有方法结果都是升序排列
 * @date: 2023/1/30 17:28
 * @version: 1.0
 */
public interface Sort {
    /**
     * @param nums: 待排序的int序列
     * @return void
     * @author ZhouXiang
     * @description 直接插入排序，排序结果是直接改变原数组
     * @exception 无
     */
    public void directInsertSort(int[] nums);

    /**
     * @param nums: 待排序的int序列
     * @return void
     * @author ZhouXiang
     * @description 折半插入排序，排序结果是直接改变原数组
     * @exception 无
     */
    public void halfInsertSort(int[] nums);

    /**
     * @param nums: 待排序的int序列
     * @return void
     * @author ZhouXiang
     * @description 希尔排序，排序结果是直接改变原数组，增量d1 = len / 2,di = d(i - 1) / 2
     * @exception 无
     */
    public void shellSort(int[] nums);
}
