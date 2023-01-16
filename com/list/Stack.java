package com.list;

/**
 * @projectName: data-structure-test
 * @package: com.list
 * @className: Stack
 * @author: Zhou xiang
 * @description: 栈的定义文件
 * @date: 2023/1/16 17:35
 * @version: 1.0
 */
public interface Stack {
    /**
     * @param o: 要压入的元素
     * @return boolean 成功为True，失败为False
     * @author ZhouXiang
     * @description 向栈中压入一个元素
     * @exception 无
     */
    public boolean push(Object o);

    /**
     * @param :
     * @return Object 弹出的元素引用
     * @author ZhouXiang
     * @description 从栈顶弹出一个元素
     * @exception 栈空则异常
     */
    public Object pop() throws Exception;

    /**
     * @param :
     * @return Object 栈顶元素的引用
     * @author ZhouXiang
     * @description 获取栈顶元素
     * @exception 栈空则异常
     */
    public Object getTop() throws Exception;


    /**
     * @param :
     * @return boolean 空为True， 非空为False
     * @author ZhouXiang
     * @description 判断栈是否为空
     * @exception 无
     */
    public boolean isEmpty();

    /**
     * @param :
     * @return void
     * @author ZhouXiang
     * @description 遍历栈中元素并打印
     * @exception 无
     */
    public void printStack();

}
