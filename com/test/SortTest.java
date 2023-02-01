package com.test;

import com.utils.Iterator;
import com.utils.Sort;
import com.utilsImp.IteratorImp;
import com.utilsImp.SortTool;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: SortTest
 * @author: Zhou xiang
 * @description: 排序算法检测
 * @date: 2023/1/30 20:04
 * @version: 1.0
 */
public class SortTest {
    public static void main(String[] args) throws Exception {
        int[] nums0 = new int[]{5, 6, 8 , 3, 6 , 2};
        int[] nums1 = nums0.clone();
        int[] nums2 = nums0.clone();
        int[] nums3 = nums0.clone();
        int[] nums4 = nums0.clone();
        int[] nums5 = nums0.clone();
        int[] nums6 = nums0.clone();

        test(nums0, 0);
        test(nums1, 1);
        test(nums2, 2);
        test(nums3, 3);
        test(nums4, 4);
        test(nums5, 5);
        test(nums6, 6);
    }

    private static void test(int[] nums, int id) throws Exception {
        System.out.println("序号为" + id + "的排序算法检验");
        Sort sort = new SortTool();
        Sort.sort(nums,id);
        Object[] o = new Object[nums.length];
        for (int i = 0; i < o.length; i++){
            o[i] = nums[i];
        }
        Iterator it = new IteratorImp(o);
        it.print();
    }
}
