package com.listImp;

import com.list.Queue;
import com.utils.Iterator;
import com.utilsImp.IteratorImp;

import java.lang.reflect.Array;

/**
 * @projectName: data-structure-test
 * @package: com.listImp
 * @className: ArrayQueue
 * @author: Zhou xiang
 * @description: Queue的顺序实现：循环队列。
 * @date: 2023/1/17 16:40
 * @version: 1.0
 */
public class ArrayQueue implements Queue {
    private int front; //队头指针，指向队头元素
    private int rear; //指向队尾元素的下一个
    private final int maxSize; //队列的最大容积，要空出一个标识队满
    private Object[] datas; // 存储的元素

    public ArrayQueue(int maxSize){
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        this.datas = new Object[maxSize + 1];
    }

    @Override
    public boolean enQueue(Object o) {
        if(isFull()){
            return false;
        }

        datas[rear] = o;
        rear++;
        return true;
    }

    @Override
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        datas[front] = null;
        front++;
        return true;
    }

    @Override
    public Object getFront() throws Exception {
        if(isEmpty()){
            throw new Exception("队列为空！");
        }

        return datas[front];
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public void printQueue() {
        this.iterator().print();
    }

    /**
     * @param :
     * @return boolean 队满为TRUE，否则为false
     * @author ZhouXiang
     * @description 判断循环队列是否队满
     * @exception 无
     */
    public boolean isFull(){
        return (rear + 1) % (maxSize + 1) == front;
    }

    /**
     * @param :
     * @return Iterator
     * @author ZhouXiang
     * @description 获取迭代器
     * @exception 无
     */
    Iterator iterator(){
        int size = this.getSize();
        Object[] info = new Object[size];
        int j = front;
        for(int i = 0; i < size; i++){
            info[i] = datas[j];
            j++;
        }
        return new IteratorImp(info);
    }

    /**
     * @param :
     * @return int 队列元素个数
     * @author ZhouXiang
     * @description 获取队列现有元素个数
     * @exception 无
     */
    public int getSize(){
        return (rear - front + maxSize + 1) % (maxSize + 1);
    }
}
