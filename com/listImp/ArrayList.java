package com.listImp;

import com.list.List;

import java.util.Arrays;

/**
 * @projectName: data-structure-test
 * @package: com.listImp
 * @className: ArrayList
 * @author: Zhou xiang
 * @description: 线性表的实现方式一：顺序表，动态分配内存
 * @date: 2023/1/10 20:54
 * @version: 1.0
 */
public class ArrayList implements List {
    private int length;
    private Object[] array;

    public ArrayList(){
        this.length = 0;
        this.array = new Object[this.length];
    }

    @Override
    public boolean add(int i, Object o) throws Exception{
        if(i < 1 || i > this.length + 1){
            throw new Exception("插入位置异常");
        }
        this.length++;
        Object[] newArray = new Object[this.length];
        for(int j = 0; j < this.length; j++){
            if(j < i - 1){
                newArray[j] = this.array[j];
            } else if (j == i - 1) {
                newArray[j] = o;
            } else {
                newArray[j] = this.array[j - 1];
            }
        }
        this.array = newArray;
        return true;
    }

    @Override
    public Object remove(int i) throws Exception {
        if(i < 1 || i > this.length + 1){
            throw new Exception("位序超出范围");
        }

        Object[] newArray = new Object[this.length - 1];
        for(int j = 0; j < this.length - 1; j++){
            if(j < i - 1){
                newArray[j] = this.array[j];
            } else {
                newArray[j] = this.array[j + 1];
            }
        }
        Object removeELem = this.array[i - 1];
        this.array = newArray;
        this.length--;

        return removeELem;
    }

    @Override
    public Object get(int i) throws Exception {
        if(i < 1 || i > this.length + 1) {
            throw new Exception("位序超出范围");
        }

        return this.array[i - 1];
    }

    @Override
    public int[] getByValue(Object o) {
        int[] result = new int[this.length];
        int num = 0;
        for(int i = 0; i < this.length; i++){
            if(this.array[i].equals(o)){
                result[num] = i + 1;
                num++;
            }
        }

        return Arrays.copyOfRange(result,0, num);
    }

    @Override
    public void printList() {
        System.out.println("顺序表表长" + this.length);
        if(this.length == 0){
            System.out.println("该顺序表为空");
            return;
        }
        System.out.println("顺序表打印开始");
        for(Object o : this.array){
            System.out.println(o);
        }
        System.out.println("顺序表打印结束");
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;

    }

    @Override
    public int getLength() {
        return this.length;
    }

    /**
     * @param o: 要找的元素
     * @return int 成功则返回其位序，失败返回-1
     * @author ZhouXiang
     * @description 折半查找(未考虑非有序的输入),只用于有序的整数序列
     * @exception get()导致
     */
    public int halfSearch(Object o) throws Exception {
        int low = 1;
        int high = this.length;
        int mid = (low + high) / 2;
        boolean isAsc = (int) this.get(high) >= (int) this.get(low);
        while (low <= high){
            if(isAsc){
                if(this.get(mid) == o){
                    return mid;
                } else if ((int)get(mid) > (int)o) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }else {
                if(this.get(mid) == o){
                    return mid;
                } else if ((int)get(mid) > (int)o) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            mid = (low + high) / 2;
        }

        return -1;
    }
}
