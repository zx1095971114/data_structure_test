package com.map;

import com.mapImp.Node;

import java.util.List;

/**
 * @projectName: data-structure-test
 * @package: com.map
 * @className: LinkedBinaryTree
 * @author: Zhou xiang
 * @description: 二叉树的定义
 * @date: 2023/1/21 23:10
 * @version: 1.0
 */
public interface BinaryTree {
    /**
     * @param order: 0:前序序列，1:中序序列，2:后序序列
     * @return Object 获取的序列
     * @throws 无
     * @author ZhouXiang
     * @description 根据参数，获取相应的序列
     */
    public List<Object> getOrder(int order) throws Exception;

    /**
     * @param order: 0:前序序列，1:中序序列，2:后序序列
     * @param node: 要获取前驱的元素的节点
     * @return Node 获取到的前驱节点
     * @author ZhouXiang
     * @description 根据所传的是前序/中序/后序线索二叉树，获取o的前序，中序，后序前驱
     * @exception 无
     */
    public Node getPre(Node node) throws Exception;

    /**
     * @param order: 0:前序序列，1:中序序列，2:后序序列
     * @param node: 要获取前驱的元素
     * @return Node 获取到的后继节点
     * @author ZhouXiang
     * @description 根据所传的是前序/中序/后序线索二叉树，获取前序，中序，后序后继
     * @exception 无
     */
    public Node getNext(Node node) throws Exception;
}
