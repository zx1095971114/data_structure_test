package com.test;

import com.list.Queue;
import com.listImp.ArrayQueue;
import com.listImp.LinkedQueue;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: QueueTest
 * @author: Zhou xiang
 * @description: 队列测试  入队[1, 2, 3, 4]
 * @date: 2023/1/17 19:59
 * @version: 1.0
 */
public class QueueTest {
    public static void main(String[] args) throws Exception {
        //循环队列测试启用
//        Queue queue = new ArrayQueue(4);
//        ArrayQueue q = (ArrayQueue) queue;
        //链队测试启用
        Queue queue = new LinkedQueue();

        queue.printQueue();

        if(queue.isEmpty()){
            System.out.println("判空操作通过");
        }

        for(int i = 1; i <= 4; i++){
            queue.enQueue(i);
        }
        queue.printQueue();

        //循环队列测试启用
//        if(!queue.enQueue(5)){
//            System.out.println("插入测试通过");
//        }

        //循环队列测试启用
//        if(q.isFull()){
//            System.out.println("判满操作通过");
//        }

        queue.deQueue();
        if(queue.getFront().equals(2)){
            System.out.println("获取队头元素测试通过");
        }
        queue.printQueue();

        //循环队列测试启用
//        if(q.getSize() == 3){
//            System.out.println("获取大小测试通过");
//        }

    }
}
