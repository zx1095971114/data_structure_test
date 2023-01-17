package com.listImp;

import com.list.Queue;
import com.utils.Iterator;
import com.utilsImp.IteratorImp;

/**
 * @projectName: data-structure-test
 * @package: com.listImp
 * @className: LinkedQueue
 * @author: Zhou xiang
 * @description: 队列的链式实现, 带头节点的单链表为基础
 * @date: 2023/1/17 20:23
 * @version: 1.0
 */
public class LinkedQueue implements Queue {
    private final Node front; //头指针，指向头节点
    private Node rear; //尾指针，指向队尾元素

    public LinkedQueue(){
        front = new Node(null, null);
        rear = front;
    }
    @Override
    public boolean enQueue(Object o) {
        Node node = new Node(o, null);
        rear.setNext(node);
        rear = node;
        return true;
    }

    @Override
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        if(rear.equals(front.getNext())){
            rear = front;
        }
        front.setNext(front.getNext().getNext());
        return true;
    }

    @Override
    public Object getFront() throws Exception {
        if(front.getNext() == null){
            throw new Exception("队列为空");
        }

        return front.getNext().getData();
    }

    @Override
    public boolean isEmpty() {
        return front.equals(rear);
    }

    /**
     * @param :
     * @return Iterator 获得的迭代器
     * @author ZhouXiang
     * @description 获取该队列的迭代器
     * @exception 无
     */
    Iterator iterator(){
        int len = 0;
        Node node = front.getNext();
        while (node != null){
            node = node.getNext();
            len++;
        }

        Object[] objs = new Object[len];
        node = front;
        for(int i = 0; i < len; i++){
            node = node.getNext();
            objs[i] = node.getData();
        }

        return new IteratorImp(objs);
    }
    @Override
    public void printQueue() {
        this.iterator().print();
    }
}
