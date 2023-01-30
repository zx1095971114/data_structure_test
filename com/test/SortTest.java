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
    public static void main(String[] args) {
        int[] nums1 = new int[]{5, 6, 8 , 3, 6 , 2};
        int[] nums2 = nums1.clone();
        int[] nums3 = nums1.clone();
        Sort sort = new SortTool();

        System.out.println("直接插入排序");
        sort.directInsertSort(nums1);
        Object[] o1 = new Object[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            o1[i] = (Object) nums1[i];
        }
        Iterator it = new IteratorImp(o1);
        it.print();

        System.out.println("折半插入排序");
        sort.halfInsertSort(nums2);
        Object[] o2 = new Object[nums2.length];
        for(int i = 0; i < nums2.length; i++){
            o2[i] = (Object) nums2[i];
        }
        it = new IteratorImp(o2);
        it.print();

        System.out.println("希尔排序");
        sort.shellSort(nums3);
        Object[] o3 = new Object[nums3.length];
        for(int i = 0; i < nums3.length; i++){
            o3[i] = (Object) nums1[i];
        }
        it = new IteratorImp(o3);
        it.print();
    }
}
