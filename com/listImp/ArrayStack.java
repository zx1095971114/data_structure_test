package com.listImp;

import com.list.Stack;

/**
 * @projectName: data-structure-test
 * @package: com.listImp
 * @className: ArrayStack
 * @author: Zhou xiang
 * @description: 顺序栈
 * @date: 2023/1/16 17:47
 * @version: 1.0
 */
public class ArrayStack implements Stack {
    private int maxSize; //顺序栈容积
    private Object[] data; //存放的数据的数组
    private int topPtr; //栈顶指针，指向栈顶元素的下标，空栈为-1

    public int getMaxSize() {
        return maxSize;
    }

    public ArrayStack(int maxSize) throws Exception{
        if(maxSize < 0){
            throw new Exception("顺序栈最大长度必须大于0且为整数");
        }

        this.maxSize = maxSize;
        this.data = new Object[maxSize];
        this.topPtr = -1;
    }

    @Override
    public boolean push(Object o) {
        if(topPtr >= maxSize - 1){
            return false;
        }
        topPtr++;
        this.data[topPtr] = o;
        return true;
    }

    @Override
    public Object pop() throws Exception {
        if(this.topPtr == -1){
            throw new Exception("空栈无法弹出元素");
        }

        Object o = this.data[topPtr];
        this.data[topPtr] = null;
        this.topPtr--;
        return o;
    }

    @Override
    public Object getTop() throws Exception {
        if(this.topPtr == -1){
            throw new Exception("空栈无栈顶元素");
        }
        Object o = this.data[topPtr];
        return o;
    }

    @Override
    public boolean isEmpty() {
        if(this.topPtr == -1){
            return true;
        }
        return false;
    }

    @Override
    public void printStack() {
        System.out.println("该栈最大容量为" + this.maxSize);
        System.out.println("该栈栈顶指针位置为" + this.topPtr);
        System.out.println("开始打印栈中元素");
        for(int i = this.topPtr; i >= 0; i--){
            System.out.println(this.data[i]);
        }
        System.out.println("栈中元素打印完毕");
        System.out.println();
    }
}
