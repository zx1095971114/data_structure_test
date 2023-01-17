package com.test;

import com.utils.Iterator;
import com.utilsImp.IteratorImp;

/**
 * @projectName: data-structure-test
 * @package: com.test.com.test
 * @className: Test
 * @author: Zhou xiang
 * @description: 用于各种小测试
 * @date: 2023/1/10 12:44
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args){
        int[] a = {1, 2, 3};
        Object[] b = new Object[3];
        for(int i = 0; i < 3; i++){
            b[i] = a[i];
        }
        Iterator it = new IteratorImp(b);

        while (it.hasNext()){
            System.out.println(it.next());
        }

        it.print();


    }
}
