package com.list;

/**
 * @projectName: data-structure-test
 * @package: com.list
 * @className: Queue
 * @author: Zhou xiang
 * @description: 队列的定义
 * @date: 2023/1/17 16:33
 * @version: 1.0
 */
public interface Queue {
    /**
     * @param o: 要入队的元素
     * @return boolean 入队是否成功
     * @author ZhouXiang
     * @description 元素入队
     * @exception 无
     */
    public boolean enQueue(Object o);

    /**
     * @param :
     * @return boolean 出队是否成功
     * @author ZhouXiang
     * @description 元素出队
     * @exception 无
     */
    public boolean deQueue();

    /**
     * @param :
     * @return Object 队头元素的引用
     * @author ZhouXiang
     * @description 获取队头元素
     * @exception 队为空时抛异常
     */
    public Object getFront() throws Exception;

    /**
     * @param :
     * @return boolean 队空为真，否则为假
     * @author ZhouXiang
     * @description 判断队是否为空
     * @exception 无
     */
    public boolean isEmpty();

    /**
     * @param :
     * @return void
     * @author ZhouXiang
     * @description 打印队列全部信息
     * @exception 无
     */
    public void printQueue();
}
