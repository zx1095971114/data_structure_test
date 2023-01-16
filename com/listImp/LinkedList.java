package com.listImp;

import com.list.List;

import java.util.Arrays;

/**
 * @projectName: data-structure-test
 * @package: com.listImp
 * @className: LinkedList
 * @author: Zhou xiang
 * @description: 用带头节点的单链表实现线性表操作
 * @date: 2023/1/11 21:28
 * @version: 1.0
 */
public class LinkedList implements List {
    private final Node head;
    private int length;

    public LinkedList() {
        this.head = new Node(null, null);
        this.length = getLength();
    }

    @Override
    //后插操作
    public boolean add(int loc, Object o){
        if(loc < 0 || loc > this.length + 1){
            return false;
        }

        Node node = new Node(o, null);
        Node p = this.head;
        for(int i = 0; i < loc - 1; i++){
            p = p.getNext();
        }
        node.setNext(p.getNext());
        p.setNext(node);
        this.length = getLength();
        return true;
    }

    @Override
    public Object remove(int loc) throws Exception {
        if(loc < 1 || loc > this.length){
            throw new Exception("要移除的位置不存在");
        }

        Object result;
        Node p = this.head;
        for(int i = 0; i < loc - 1; i++){
            p = p.getNext();
        }
        result = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        this.length = this.getLength();

        return result;
    }

    @Override
    public Object get(int loc) throws Exception {
        if(loc < 1 || loc > this.length){
            throw new Exception("查找位序超出范围");
        }

        Node p = this.head;
        for(int i = 0; i < loc; i++){
            p = p.getNext();
        }

        return p.getData();
    }

    @Override
    public int[] getByValue(Object o) {
        int[] array = new int[this.length];
        int num = 0;
        int digit = 0;
        Node p = this.head;
        while (p.getNext() != null){
            digit++;
            p = p.getNext();
            if(p.getData().equals(o)){
                array[num] = digit;
                num++;
            }
        }

        return Arrays.copyOfRange(array, 0, num);
    }

    @Override
    public void printList() {
        Node p = this.head;
        System.out.println("该表表长为" + this.length);
        System.out.println("开始打印");
        while (p.getNext() != null){
            p = p.getNext();
            System.out.println(p.getData());
        }
        System.out.println("打印结束");
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int getLength() {
        int l = 0;
        Node node = this.head.getNext();
        while (node != null){
            l++;
            node = node.getNext();
        }
        return l;
    }
}


