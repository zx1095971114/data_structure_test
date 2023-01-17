package com.utils;

/**
 * @projectName: data-structure-test
 * @package: com.utils
 * @className: Iterator
 * @author: Zhou xiang
 * @description: 迭代器接口，方便list中所有接口进行迭代，迭代器指针始终指向未迭代的第一位
 * @date: 2023/1/17 16:58
 * @version: 1.0
 */
public interface Iterator {
    /**
     * @param :
     * @return boolean 有，返回true
     * @author ZhouXiang
     * @description 判断下一个位置是否还有迭代元素，并将迭代器指针后移一位
     * @exception 无
     */
    public boolean hasNext();

    /**
     * @param :
     * @return Object
     * @author ZhouXiang
     * @description 取出迭代器指针前一位的元素
     * @exception 无
     */
    public Object next();

    /**
     * @param :
     * @return void
     * @author ZhouXiang
     * @description 打印容器中所有元素
     * @exception 无
     */
    public void print();
}
