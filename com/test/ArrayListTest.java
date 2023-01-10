package com.test;

import com.list.List;
import com.listImp.ArrayList;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: ArrayListTest
 * @author: Zhou xiang
 * @description: 测试顺序表 int[] a = new int[]{1, 2, 4, 2, 3, 6};为存入的数据
 * @date: 2023/1/10 21:51
 * @version: 1.0
 */
public class ArrayListTest {
    public static void main(String[] args) throws Exception {
        List arrayList = new ArrayList();
        arrayList.printList();

        if(arrayList.isEmpty()){
            System.out.println("判空测试通过");
        }



        arrayList.add(1, 2);
        arrayList.add(2, 2);
        arrayList.add(3, 6);
        arrayList.add(2, 4);
        arrayList.add(4, 3);
        arrayList.add(1, 1);
        arrayList.printList();

        arrayList.remove(6);
        arrayList.printList();

        System.out.println("位序为3的是" + arrayList.get(3) );

        int[] b = arrayList.getByValue(2);
        for(int elem : b){
            System.out.println("元素2所在的位序有" + elem);
        }

        System.out.println("表长获取测试，获取的表长为" + arrayList.getLength());
        arrayList.printList();

    }
}
