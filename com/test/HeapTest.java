package com.test;

import com.map.Heap;
import com.mapImp.ArrayHeap;
import com.utils.Iterator;
import com.utilsImp.IteratorImp;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: HeapTest
 * @author: Zhou xiang
 * @description: 堆的测试
 * @date: 2023/2/1 22:49
 * @version: 1.0
 */
public class HeapTest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 6, 2, 8, 7};
        Heap heap = new ArrayHeap(nums, 1);
        heap.delete(3);
        heap.add(4);
        int[] nums1  = heap.sort();

        Object[] o = new Object[nums.length];
        for (int i = 0; i < o.length; i++){
            o[i] = nums1[i];
        }
        Iterator it = new IteratorImp(o);
        it.print();
        System.out.println();

        it = heap.iterator();
        it.print();
    }
}
