package com.mapImp;

import java.util.LinkedList;
import java.util.List;
import com.list.Stack;
import com.listImp.LinkedStack;

/**
 * @projectName: data-structure-test
 * @package: com.mapImp
 * @className: LinkedBinaryTree
 * @author: Zhou xiang
 * @description: 三叉链表实现的线索二叉树
 * @date: 2023/1/21 23:47
 * @version: 1.0
 */
public class LinkedBinaryTree implements com.map.BinaryTree {

    private int order; //标识是前序，后序还是中序,-1为未进行线索化,0为前序线索化，1为中序，2为后序
    private Node root; //根节点

    private int loc; //用在初始化时指示建立到了哪一个节点

    private Node pre; //用于线索化时指示前驱节点

    public int getOrder() {
        return order;
    }

    public Node getRoot() {
        return root;
    }

    private LinkedBinaryTree() {
        this.order = -1;
        this.root = new Node(null);
        this.loc = 0;
        this.pre = new Node(null);
    }

    /**
     * @param datas: 带空的先序序列，如ABDH##I##E##CF#J##G##
     * @return LinkedBinaryTree 初始化好的二叉树
     * @author ZhouXiang
     * @description 根据带空的先序序列初始化二叉树，
     * @exception 无
     */
    public static LinkedBinaryTree getInitBinaryTree(Object[] datas){
        LinkedBinaryTree tree = new LinkedBinaryTree();
        tree.root = tree.initBinaryTree(datas, null);
        return tree;
    }

    //根据带空的先序序列将二叉树节点初始化,返回初始化好的节点
    private Node initBinaryTree(Object[] datas, Node pre){
        Node node = new Node(null);
        int now = loc;
        loc++;
        if (datas[now] != null){
            node.setFather(pre);
            node.setData(datas[now]);
            node.setLeftChild(initBinaryTree(datas, node));
            node.setRightChild(initBinaryTree(datas, node));
        }
        return node;
    }

    /**
     * @param order: 线索化的顺序，先序0，中序1，后序2
     * @return void
     * @author ZhouXiang
     * @description 按所给的顺序码对二叉树进行线索化
     * @exception 只能处理未线索化的二叉树,顺序码只能是0,1,2
     */
    public void InThread(int order) throws Exception {
        if(this.order != -1){
            throw new Exception("只能处理未线索化的二叉树");
        }

        this.order = order;
        this.pre = new Node(null);
        switch (order){
            case 0:
                this.preInThread(root);
                break;
            case 1:
                this.midInThread(root);
                break;
            case 2:
                this.postInThread(root);
                break;
            default:
                throw new Exception("错误的顺序码");
        }

        if(pre.getData() != null && pre.getRightChild() == null){
            pre.setRNext(true);
        }
    }
    //线索化的过程中对要线索化的节点进行的操作
    private void visitThread(Node node){
        if(node.getLeftChild().getData() == null){
            node.setLeftChild(pre);
            node.setLPre(true);
        }
        if(pre.getData() != null && pre.getRightChild().getData() == null){
            pre.setRightChild(node);
            pre.setRNext(true);
        }
        pre = node;
    }
    //先序线索化的递归
    private void preInThread(Node node){
        if(node.getData() != null){
            if(node.getData().equals("F")){
                int a = 1;
            }
            visitThread(node);
            if(!node.isLPre()){
                preInThread(node.getLeftChild());
            }
            if(!node.isRNext()){
                preInThread(node.getRightChild());
            }
        }
    }
    //中序线索化的递归
    private void midInThread(Node begin){
        if(begin.getData() != null){
            if(!begin.isLPre()){
                midInThread(begin.getLeftChild());
            }

            visitThread(begin);

            if(!begin.isRNext()){
                midInThread(begin.getRightChild());
            }
        }

    }
    //后序线索化的递归
    private void postInThread(Node node){
        if(node.getData() != null){
            if(!node.isLPre()){
                postInThread(node.getLeftChild());
            }
            if(!node.isRNext()){
                postInThread(node.getRightChild());
            }

            visitThread(node);
        }
    }

    @Override
    public List<Object> getOrder(int order) throws Exception {
        if(this.order == -1){
            List<Object> list = new LinkedList<>();
            Node p = this.root;
            Stack stack = new LinkedStack();
            switch (order){
                case 0:
                    while (p.getData() != null || !stack.isEmpty()){
                        if(p.getData() != null){
                            list.add(p.getData());
                            stack.push(p);
                            p = p.getLeftChild();
                        }else {
                            p = (Node) stack.pop();
                            p = p.getRightChild();
                        }
                    }
                    break;
                case 1:
                    while (p.getData() != null || !stack.isEmpty()){
                        if(p.getData() != null){
                            stack.push(p);
                            p = p.getLeftChild();
                        }else {
                            p = (Node) stack.pop();
                            list.add(p.getData());
                            p = p.getRightChild();
                        }
                    }
                    break;
                case 2:
                    Node lstNode = null; //记录最近被访问过的节点
                    while (p.getData() != null || !stack.isEmpty()){
                        if(p.getData() != null){
                            stack.push(p);
                            p = p.getLeftChild();
                        }else {
                            p = (Node) stack.getTop();
                            if(p.getRightChild().getData() != null && lstNode != p.getRightChild()){
                                p = p.getRightChild();
                            } else {
                                stack.pop();
                                list.add(p.getData());
                                lstNode = p;
                                p = new Node(null);
                            }
                        }
                    }
                    break;
                default:
                    throw new Exception("错误的排序类型");
            }
            return list;
        }
        else {
            throw new Exception("暂未实现线索化后二叉树的遍历");
        }
    }

    @Override
    public Node getPre(Node node) throws Exception {
        if(node == null){
            throw new Exception("空节点无前驱");
        }
        if(node.isLPre()){
            return node.getLeftChild();
        }
        switch (this.order){
            case 0:
                Node father = node.getFather();
                if(node.equals(father.getLeftChild())){
                    return father;
                } else if (father.isLPre()) {
                    return father;
                }else {
                    return this.getPreLast(father.getLeftChild());
                }
            case 1:
                while (!node.getLeftChild().isRNext()){
                    node = node.getRightChild();
                }
                return node;
            case 2:
                if(!node.isRNext()){
                    return node.getRightChild();
                }else {
                    return node.getLeftChild();
                }

            default:
                throw new Exception("只支持前序/中序/后序线索二叉树的元素找前驱");
        }
    }

    //从node前序遍历时，获取最后一个元素
    private Node getPreLast(Node node){
        Node old = node;
        if(!node.isRNext()){
            node = node.getRightChild();
        }
        if(!node.isLPre()){
            node = node.getLeftChild();
        }
        if(!node.equals(old)){
            node = this.getPreLast(node);
        }
        return node;
    }

    @Override
    public Node getNext(Node node) throws Exception {
        if(node == null){
            throw new Exception("空节点无前驱");
        }
        if(node.isRNext()){
            return node.getRightChild();
        }

        switch (this.order){
            case 0:
                if(!node.isLPre()){
                    return node.getLeftChild();
                }else {
                    return node.getRightChild();
                }
            case 1:
                while (!node.isRNext()){
                    node = node.getRightChild();
                }
                return node;
            case 2:
                Node father = node.getFather();
                if(node.equals(father.getRightChild())){
                    return father;
                } else if (father.isRNext()) {
                    return father;
                }else {
                    return this.getPostFirst(father.getRightChild());
                }
            default:
                throw new Exception("只支持前序/中序/后序线索二叉树找后继");
        }
    }

    //从node后序遍历时，获取第一个元素
    private Node getPostFirst(Node node){
        Node old = node;
        if(!node.isLPre()){
            node = node.getLeftChild();
        }
        if(!node.isRNext()){
            node = node.getRightChild();
        }
        if(!node.equals(old)){
            node = getPostFirst(node);
        }
        return node;
    }
}
