package com.map;

import java.util.List;
import java.util.Map;

/**
 * @projectName: data-structure-test
 * @package: com.map
 * @className: Graph
 * @author: Zhou xiang
 * @description: 图的定义
 * @date: 2023/1/26 9:25
 * @version: 1.0
 */
public interface Graph {
    /**
     * @param start: 弧头下标
     * @param end: 弧尾下标
     * @return boolean 邻接为真
     * @author ZhouXiang
     * @description 判断两点是否邻接,即(x,y)或<x,y>是否存在
     * @exception 无
     */
    public boolean adjacent(int start, int end);

    /**
     * @param x: 起始点的下标
     * @return Map 获取的点下标集合,注意：返回的是(end，start)，因为map要求key必须不同
     * @author ZhouXiang
     * @description 获取所有与x邻接的边,(要以x为弧尾)
     * @exception getVex中x对应的结点不存在
     */
    public Map neighbors(int x) throws Exception;

    /**
     * @param o: 结点数据域
     * @return boolean 插入成功为真
     * @author ZhouXiang
     * @description 插入数据域为o的结点
     * @exception
     */
    public boolean insertVertex(Object o);

    /**
     * @param x: 要删除的点的下标
     * @return boolean 删除成功为真
     * @author ZhouXiang
     * @description 删除下标为x的结点
     * @exception
     */
    public boolean deleteVertex(int x);

    /**
     * @param start: 弧起点下标
     * @param end: 弧终点下标
     * @param info: 弧的权值
     * @return boolean 增加成功为真
     * @author ZhouXiang
     * @description 增加(start, end)或<start, end> 的边,(start, end)要增加两次，另一次是(start,end)
     * @exception
     */
    public boolean addEdge(int start, int end, int info);

    /**
     * @param start: 弧起点下标
     * @param end: 弧终点下标
     * @return boolean
     * @author ZhouXiang
     * @description 删除(start, end)或<start, end> 的边
     * @exception
     */
    public boolean removeEdge(int start, int end);

    /**
     * @param start: 起始结点下标
     * @param end: 终端结点下标
     * @return int 获取的权值
     * @author ZhouXiang
     * @description 获取(start,end)或<start,end>的权值
     * @exception 边不存在抛异常
     */
    public int getEdgeValue(int start, int end) throws Exception;

    /**
     * @param start: 起始结点下标
     * @param end:   终端结点下标
     * @param info: 权值
     * @return boolean 是否成功
     * @throws
     * @author ZhouXiang
     * @description 设置(start, end)或<start, end>的权值
     */
    public boolean setEdgeValue(int start, int end, int info);

    /**
     * @param int: 开始遍历的结点
     * @return List 广度优先遍历后的结点数据域序列
     * @author ZhouXiang
     * @description 广度优先遍历整个图
     * @exception 该序号对应的结点不在图里
     */
    public List bfsTravel(int x) throws Exception;

    /**
     * @param int: 开始遍历的结点
     * @return List 深度优先遍历后的结点数据域序列
     * @author ZhouXiang
     * @description 深度优先遍历整个图
     * @exception 该序号对应的结点不在图里
     */
    public List dfsTravel(int x) throws Exception;

    /**
     * @param :
     * @return List 输出的拓扑序列
     * @author ZhouXiang
     * @description 对图尝试拓扑排序，输出拓扑序列
     * @exception 存在环则抛异常
     */
    public List topologicalSort();

}
