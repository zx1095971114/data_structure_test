package com.listImp;

/**
 * @projectName: data-structure-test
 * @package: com.listImp
 * @className: Node
 * @author: Zhou xiang
 * @description: 节点类
 * @date: 2023/1/16 21:58
 * @version: 1.0
 */
class Node{

    private Object data;
    private Node next;

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
