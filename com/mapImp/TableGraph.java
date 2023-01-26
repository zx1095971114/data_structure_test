package com.mapImp;

import com.map.Graph;

import java.util.*;

/**
 * @projectName: data-structure-test
 * @package: com.mapImp
 * @className: TableGraph
 * @author: Zhou xiang
 * @description: 邻接表实现的图
 * @date: 2023/1/26 10:32
 * @version: 1.0
 */
public class TableGraph implements Graph {
    private List<VexNode> vexes; //结点链表

    public TableGraph() {
        this.vexes = new ArrayList<>();
    }


    @Override
    public boolean adjacent(int start, int end) {
        for (VexNode vex: vexes){
            if(vex.getId() == start){
                ArcNode arc = vex.getArc();
                while (arc != null){
                    if(arc.getEnd() == end){
                        return true;
                    }
                    arc = arc.getArc();
                }
            }
        }
        return false;
    }

    @Override
    public Map neighbors(int x) throws Exception {
        Map neighbors = new HashMap<>();
        for (VexNode vex: vexes){
            if(vex.getId() == x){
                ArcNode arc = vex.getArc();
                while (arc != null){
                    neighbors.put(getVex(arc.end).data, getVex(x).data);
                    arc = arc.getArc();
                }
            }
        }
        return neighbors;
    }

    @Override
    public boolean insertVertex(Object o) {
        int id = 0;
        if(!vexes.isEmpty()){
            id = vexes.get(vexes.size() - 1).getId() + 1;
        }
        VexNode vexNode = new VexNode(o, id);
        vexes.add(vexNode);
        return true;
    }

    @Override
    public boolean deleteVertex(int x) {
        VexNode vexNode = null;
        for(VexNode vex: vexes){
            if(vex.getId() == x){
                vexNode = vex;
            }else {
                ArcNode arcNode = vex.getArc();
                ArcNode pre = null;
                if(arcNode.getEnd() == x){
                    vex.setArc(arcNode.getArc());
                }else {
                    while (arcNode != null){
                        if(arcNode.getEnd() == x){
                            pre.setArc(arcNode.getArc());
                            break;
                        }
                        pre = arcNode;
                        arcNode = arcNode.getArc();
                    }
                }
            }
        }
        vexes.remove(vexNode);
        return true;
    }

    @Override
    public boolean addEdge(int start, int end, int info) {
        for(VexNode vex: vexes){
            if(vex.getId() == start){
                ArcNode arcNode = new ArcNode(end, info);
                arcNode.setArc(vex.getArc());
                vex.setArc(arcNode);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeEdge(int start, int end) {
        for (VexNode vex: vexes){
            if(vex.getId() == start){
                ArcNode pre = null;
                ArcNode arc = vex.getArc();
                if(arc.getEnd() == end){
                    vex.setArc(arc.getArc());
                    return true;
                }
                while (arc != null){
                    if(arc.getEnd() == end){
                        pre.setArc(arc.getArc());
                        return true;
                    }
                    pre = arc;
                    arc = arc.getArc();
                }
            }
        }
        return false;
    }

    @Override
    public int getEdgeValue(int start, int end) throws Exception {
        for(VexNode vex: vexes){
            if(vex.getId() == start){
                ArcNode arcNode = vex.getArc();
                while (arcNode != null){
                    if(arcNode.getEnd() == end){
                        return arcNode.getInfo();
                    }
                    arcNode = arcNode.getArc();
                }
                throw new Exception("边不存在");
            }
        }
        throw new Exception("边不存在");
    }

    @Override
    public boolean setEdgeValue(int start, int end, int info) {
        for(VexNode vex: vexes){
            if(vex.getId() == start){
                ArcNode arcNode = vex.getArc();
                while (arcNode != null){
                    if(arcNode.getEnd() == end){
                        arcNode.setInfo(info);
                        return true;
                    }
                    arcNode = arcNode.getArc();
                }
                return false;
            }
        }
        return false;
    }

    /**
     * @param x: 要找的点的下标
     * @return int 成功则返回第一个邻接点的下标，失败返回-1
     * @author ZhouXiang
     * @description 找x的第一个邻接点的下标
     * @exception
     */
    private int firstNeighbor(int x) {
        for(VexNode vex: vexes){
            if(vex.getId() == x){
                if(vex.getArc() != null){
                    return vex.getArc().getEnd();
                }
            }
        }
        return -1;
    }

    /**
     * @param x: 起始点下标
     * @param y: 已知邻接点的下标
     * @return int 成功则返回下一个邻接点的下标，失败返回-1
     * @author ZhouXiang
     * @description 找x除y外的下一个邻接点
     * @exception
     */
    private int nextNeighbor(int x, int y) {
        for(VexNode vex: vexes){
            if(vex.getId() == x){
                ArcNode arc = vex.getArc();
                while (arc != null){
                    if(arc.getEnd() == y && arc.getArc() != null){
                            return arc.getArc().getEnd();
                    }
                    arc = arc.getArc();
                }
            }
        }
        return -1;
    }

    @Override
    public List bfsTravel(int x) throws Exception {
        List list = new ArrayList<>();
        for(VexNode vex: vexes){
            vex.visited = false;
        }
        for(VexNode vex: vexes){
            if(vex.id == x){
                list.addAll(bfs((vex)));
            }
        }
        for(VexNode vex: vexes){
            if(!vex.isVisited()){
                list.addAll(bfs(vex));
            }
        }
        return list;
    }

    @Override
    public List dfsTravel(int x) throws Exception {
        for (VexNode vex: vexes) {
            vex.visited = false;
        }
        List result = new ArrayList<>();
        for(VexNode vex: vexes){
            if(vex.getId() == x){
                dfs(vex, result);
            }
        }
        for(VexNode vex: vexes){
            if(!vex.isVisited()){
                dfs(vex,result);
            }
        }
        return result;
    }

    //从vex结点bfs一个联通分支
    private List bfs(VexNode vex) throws Exception {
        Queue<VexNode> queue = new LinkedList<>();
        List list = new ArrayList<>();
        list.add(vex.getData());
        vex.visited = true;
        queue.offer(vex);
        while (!queue.isEmpty()){
            vex = queue.poll();
            for (int i = this.firstNeighbor(vex.id); i >= 0; i = this.nextNeighbor(vex.id, i)){
                if(!this.getVex(i).isVisited()){
                    list.add(this.getVex(i).getData());
                    getVex(i).visited = true;
                    queue.offer(this.getVex(i));
                }
            }
        }

        return list;
    }

    //从vex结点dfs一个连通分支
    private void dfs(VexNode vex, List list) throws Exception {
        list.add(vex.getData());
        vex.visited = true;
        for(int i = firstNeighbor(vex.id); i >= 0; i = this.nextNeighbor(vex.id, i)){
            if(!getVex(i).isVisited()){
                dfs(getVex(i), list);
            }
        }
    }

    //根据结点id获取结点,无该结点抛异常
    private VexNode getVex(int id) throws Exception {
        for(VexNode vex: vexes){
            if(vex.getId() == id){
                return vex;
            }
        }
        throw new Exception("该序号的结点不存在");
    }
    //点结点
    class VexNode{
        private Object data; //结点信息
        private ArcNode arc; //以该点为弧头的第一条邻接边
        private final int id; //点的id信息，作为主键唯一标识该点
        private boolean visited; //在遍历时看是否访问过

        public VexNode(Object data, int id) {
            this.data = data;
            this.arc = null;
            this.id = id;
            this.visited = false;
        }

        public Object getData() {
            return data;
        }

        public ArcNode getArc() {
            return arc;
        }

        void setArc(ArcNode arc) {
            this.arc = arc;
        }

        public int getId() {
            return id;
        }

        public boolean isVisited() {
            return visited;
        }
    }

    //边结点
    class ArcNode{
        private int end; //弧尾的结点序号
        private int info; //边的权值
        private ArcNode arc; //下一条边

        public ArcNode(int end, int info) {
            this.end = end;
            this.info = info;
            this.arc = null;
        }

        public int getEnd() {
            return end;
        }

        public int getInfo() {
            return info;
        }

        public ArcNode getArc() {
            return arc;
        }

        void setArc(ArcNode arc) {
            this.arc = arc;
        }

        void setInfo(int info) {
            this.info = info;
        }
    }
}
