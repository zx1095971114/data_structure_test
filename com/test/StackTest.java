package com.test;

import com.list.Stack;
import com.listImp.ArrayStack;
import com.listImp.LinkedStack;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: StackTest
 * @author: Zhou xiang
 * @description: 对Stack接口的测试  [1, 2, 3, 4]
 * @date: 2023/1/16 21:13
 * @version: 1.0
 */
public class StackTest {
    public static void main(String[] args) throws Exception {
        //顺序栈测试时启用注释内容
//        Stack stack = new ArrayStack(4);
        Stack stack = new LinkedStack(); //顺序栈测试时将其注释
        stack.printStack();
        if(stack.isEmpty()){
            System.out.println("判空测试，空通过");
        }

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

//        if(!stack.push(5)){
//            System.out.println("栈满插入测试通过");
//        }
        if(!stack.isEmpty()){
            System.out.println("判空测试，非空通过");
        }
        stack.printStack();

        if(stack.pop().equals(4)){
            System.out.println("弹出测试通过");
        }

        if(stack.getTop().equals(3)){
            stack.printStack();
        }

    }
}
