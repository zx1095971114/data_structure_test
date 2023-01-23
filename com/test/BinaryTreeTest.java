package com.test;

import com.map.BinaryTree;
import com.mapImp.LinkedBinaryTree;
import com.mapImp.Node;
import com.utils.Iterator;
import com.utilsImp.IteratorImp;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: BinaryTreeTest
 * @author: Zhou xiang
 * @description: 二叉树检测
 * @date: 2023/1/23 13:20
 * @version: 1.0
 */
public class BinaryTreeTest {
    public static void main(String[] args) throws Exception {
        Object[] datas = new Object[]{"A","B","D",null,null,"E",null,null,"C","F",null,null,null};
        BinaryTree tree = LinkedBinaryTree.getInitBinaryTree(datas);
        System.out.println("前序遍历");
        Iterator it = new IteratorImp(tree.getOrder(0).toArray());
        it.print();

        System.out.println("中序遍历");
        it = new IteratorImp(tree.getOrder(1).toArray());
        it.print();

        System.out.println("后序遍历");
        it = new IteratorImp(tree.getOrder(2).toArray());
        it.print();

        LinkedBinaryTree pre = LinkedBinaryTree.getInitBinaryTree(datas);
        pre.InThread(0);
        Node nodePre = pre.getRoot().getRightChild();
        System.out.println("当前节点: " + nodePre.getData());
        System.out.println("前序前驱: " + pre.getPre(nodePre).getData());
        System.out.println("前序后继: " + pre.getNext(nodePre).getData());

        LinkedBinaryTree mid = LinkedBinaryTree.getInitBinaryTree(datas);
        mid.InThread(1);
        Node nodeMid = mid.getRoot().getLeftChild().getRightChild();
        System.out.println("当前节点: " + nodeMid.getData());
        System.out.println("中序前驱: " + mid.getPre(nodeMid).getData());
        System.out.println("中序后继: " + mid.getNext(nodeMid).getData());

        LinkedBinaryTree post = LinkedBinaryTree.getInitBinaryTree(datas);
        post.InThread(2);
        Node nodePost = post.getRoot().getLeftChild().getRightChild();
        System.out.println("当前节点: " + nodePost.getData());
        System.out.println("后序前驱: " + post.getPre(nodePost).getData());
        System.out.println("后序后继: "+ post.getNext(nodePost).getData());

    }
}
