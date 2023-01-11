package com.list;

/**
 * @projectName: data-structure-test
 * @package: com.list
 * @className: List
 * @author: Zhou xiang
 * @description: 线性表的定义
 * @date: 2023/1/10 17:06
 * @version: 1.0
 */
public interface List {
    /**
     * @param i: 增加的位置
     * @param o: 要增加的元素
     * @return boolean 是否成功
     * @author ZhouXiang
     * @description 往线性表增加元素
     * @exception 表满异常
     */
    boolean add(int i, Object o) throws Exception;

    /**
     * @param i: 移除元素的位置
     * @return Object 移除的元素
     * @author ZhouXiang
     * @description 从线性表删除元素
     * @exception 移除位置异常
     */
    Object remove(int i) throws Exception;

    /**
     * @param i: 查找元素的位序
     * @return Object 获取到的元素
     * @author ZhouXiang
     * @description 按位序查找元素
     * @exception 位序异常
     */
    Object get(int i) throws Exception;

    /**
     * @param o: 查找的值
     * @return int[] 查到值的位序组成的数组，若该数组只有一个0，则说明没有找到
     * @author ZhouXiang
     * @description 按值查找
     * @exception 无
     */
    int[] getByValue(Object o);

    /**
     * @param : 无
     * @return void
     * @author ZhouXiang
     * @description 按顺序打印该线性表所有元素
     * @exception 无
     */
    void printList();

    /**
     * @param :
     * @return boolean 是否为空
     * @author ZhouXiang
     * @description 判断该表是否为空
     * @exception 无
     */
    boolean isEmpty();

    /**
     * @param :
     * @return int 表长度
     * @author ZhouXiang
     * @description 获取表长
     * @exception 无
     */
    int getLength();
}
