package com.utils;

import com.utilsImp.SortTool;

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
     * @param nums: 待排序的序列
     * @param id: 选择的算法序号
     * @return void
     * @author ZhouXiang
     * @description 选择某算法进行升序排列
     * @exception
     */
    public static void sort(int[] nums, int id) throws Exception {
        Sort sort = new SortTool();
        switch (id){
            case 0:
                sort.directInsertSort(nums);
                break;
            case 1:
                sort.halfInsertSort(nums);
                break;
            case 2:
                sort.shellSort(nums);
                break;
            case 3:
                sort.bubbleSort(nums);
                break;
            case 4:
                sort.quickSort(nums,0,nums.length - 1);
                break;
            default:
                throw new Exception("不存在序号为" + id + "的排序算法");
        }
    }
    /**
     * @param nums: 待排序的int序列
     * @return void
     * @author ZhouXiang
     * @description 直接插入排序，排序结果是直接改变原数组,序号0
     * @exception 无
     */
    public void directInsertSort(int[] nums);

    /**
     * @param nums: 待排序的int序列
     * @return void
     * @author ZhouXiang
     * @description 折半插入排序，排序结果是直接改变原数组,序号1
     * @exception 无
     */
    public void halfInsertSort(int[] nums);

    /**
     * @param nums: 待排序的int序列
     * @return void
     * @author ZhouXiang
     * @description 希尔排序，排序结果是直接改变原数组，增量d1 = len / 2,di = d(i - 1) / 2，序号2
     * @exception 无
     */
    public void shellSort(int[] nums);

    /**
     * @param nums: 待排序的int序列
     * @return void
     * @author ZhouXiang
     * @description 冒泡排序，排序结果是直接改变原数组，序号3
     * @exception 无
     */
    public void bubbleSort(int[] nums);

    /**
     * @param nums: 待排序的int序列
     * @param low: 开始排序的位置
     * @param nums: 结束排序的位置
     * @return void
     * @author ZhouXiang
     * @description 快速排序，排序结果是直接改变原数组，序号4
     * @exception 无
     */
    public void quickSort(int[] nums,int low, int high);
}
