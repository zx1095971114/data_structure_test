package com.listImp;

import com.list.Stack;

/**
 * @projectName: data-structure-test
 * @package: com.listImp
 * @className: LinkedStack
 * @author: Zhou xiang
 * @description: 链栈的实现，(没有头节点的单链表为基础)
 * @date: 2023/1/16 21:56
 * @version: 1.0
 */
public class LinkedStack implements Stack {
    private Node head; //头指针

    public LinkedStack(){
        this.head = null;
    }

    @Override
    public boolean push(Object o) {
        Node node = new Node(o, null);
        node.setNext(this.head);
        this.head = node;
        return true;
    }

    @Override
    public Object pop() throws Exception {
        if(isEmpty()){
            throw new Exception("空栈无法抛出元素");
        }

        Node old = this.head;
        this.head = old.getNext();

        return old.getData();
    }

    @Override
    public Object getTop() throws Exception {
        if(isEmpty()){
            throw new Exception("空栈无栈顶元素");
        }

        return this.head.getData();
    }

    @Override
    public boolean isEmpty() {
        return (this.head == null);
    }

    @Override
    public void printStack() {
        System.out.println("开始打印栈中元素");
        Node node = this.head;
        while (!(node == null)){
            System.out.println(node.getData());
            node = node.getNext();
        }
        System.out.println("栈中元素打印完毕");
        System.out.println();
    }
}
