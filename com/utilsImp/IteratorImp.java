package com.utilsImp;

import com.utils.Iterator;

/**
 * @projectName: data-structure-test
 * @package: com.utilsImp
 * @className: IteratorImp
 * @author: Zhou xiang
 * @description: 迭代器实现类
 * @date: 2023/1/17 17:04
 * @version: 1.0
 */
public class IteratorImp implements Iterator {
    private final Object[] datas; // 要迭代的数据
    private int iterator; // 迭代指针

    public IteratorImp(Object[] datas){
        this.datas = datas;
        this.iterator = 0;
    }

    @Override
    public boolean hasNext() {
        if(this.iterator == this.datas.length){
            return false;
        }else {
            this.iterator++;
            return true;
        }
    }

    @Override
    public Object next() {
        return this.datas[this.iterator - 1];
    }

    @Override
    public void print() {
        System.out.println("集合中的元素个数有" + this.datas.length + "个");
        System.out.println("开始打印集合元素");
        for (Object data : datas) {
            System.out.print(data + " ");
        }
        System.out.println("\n集合元素打印完毕");
        System.out.println();
    }
}
