package com.mapImp;

/**
 * @projectName: data-structure-test
 * @package: com.mapImp
 * @className: Node
 * @author: Zhou xiang
 * @description: 线索二叉树的节点
 * @date: 2023/1/23 12:07
 * @version: 1.0
 */
public class Node{
    private Object data; //数据域
    private Node leftChild; //左孩子或前驱
    private Node rightChild; //右孩子或后继
    private boolean isLPre; //leftChild是前驱为true
    private boolean isRNext; //rightChild是后继为true
    private Node father; //父节点

    public Node(Object data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.isLPre = false;
        this.isRNext = false;
        this.father = null;
    }

    public Object getData() {
        return data;
    }

    void setData(Object data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLPre() {
        return isLPre;
    }

    void setLPre(boolean LPre) {
        isLPre = LPre;
    }

    public boolean isRNext() {
        return isRNext;
    }

    void setRNext(boolean RNext) {
        isRNext = RNext;
    }

    public Node getFather() {
        return father;
    }

    void setFather(Node father) {
        this.father = father;
    }
}
