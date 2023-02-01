package com.map;

import com.utils.Iterator;

/**
 * @projectName: data-structure-test
 * @package: com.map
 * @className: Heap
 * @author: Zhou xiang
 * @description: 堆的定义,该堆暂只能存整数
 * @date: 2023/2/1 20:31
 * @version: 1.0
 */
public interface Heap {
    /**
     * @param num: 要加入的数
     * @return boolean 真为成功
     * @author ZhouXiang
     * @description 增加一个数，使其仍保持大顶/小顶堆的性质
     * @exception
     */
    public boolean add(int num);

    /**
     * @param no: 要删的数的序号
     * @return boolean 真为成功
     * @author ZhouXiang
     * @description 删除一个数，使其仍保持大顶/小顶堆的性质
     * @exception
     */
    public boolean delete(int no);

    /**
     * @param :
     * @return int 返回的序列
     * @author ZhouXiang
     * @description 输出该堆中元素的升序序列
     * @exception
     */
    public int[] sort();

    /**
     * @param :
     * @return Iterator 该堆的迭代器
     * @author ZhouXiang
     * @description 获取该堆的迭代器
     * @exception
     */
    public Iterator iterator();
}
