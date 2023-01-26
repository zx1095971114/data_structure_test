package com.test;

import com.map.Graph;
import com.mapImp.TableGraph;
import com.utils.Iterator;
import com.utilsImp.IteratorImp;

import java.util.Map;
import java.util.Set;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: TableGraphTest
 * @author: Zhou xiang
 * @description: 邻接表实现的图的检测
 * @date: 2023/1/26 19:02
 * @version: 1.0
 */
public class TableGraphTest {
    public static void main(String[] args) throws Exception {
        Graph graph = new TableGraph();
        graph.insertVertex("a");
        graph.insertVertex("b");
        graph.insertVertex("c");
        graph.insertVertex("d");
        graph.insertVertex("e");
        graph.insertVertex("f");

        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 0);
        graph.addEdge(0, 3, 0);
        graph.addEdge(1, 0, 1);
        graph.addEdge(1, 2, 0);
        graph.addEdge(2, 0, 0);
        graph.addEdge(2, 1, 0);
        graph.addEdge(2, 3, 0);
        graph.addEdge(3, 0, 0);
        graph.addEdge(3, 2, 0);
        graph.addEdge(4, 5, 0);
        graph.addEdge(5, 4, 0);

        graph.removeEdge(0, 3);
        graph.removeEdge(3, 0);

        graph.deleteVertex(5);

        graph.setEdgeValue(0, 1, 3);

        if(graph.getEdgeValue(0, 1) == 3){
            System.out.println("权值获取,设置成功");
        }

        System.out.println("bfs序列");
        Iterator it = new IteratorImp(graph.bfsTravel(1).toArray());
        it.print();

        System.out.println("\ndfs序列");
        it = new IteratorImp(graph.dfsTravel(2).toArray());
        it.print();

        if(graph.adjacent(0, 2) && !graph.adjacent(0, 3)){
            System.out.println("邻接测试通过");
        }

        System.out.println("\nc的所有邻接边有");

        Map map = graph.neighbors(2);
        Set<Map.Entry> entries = map.entrySet();
        for(Map.Entry entry: entries){
            System.out.print(entry.getValue().toString() + ", " + entry.getKey().toString() + "\n");
        }
    }
}
