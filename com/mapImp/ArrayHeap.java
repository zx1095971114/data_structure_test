package com.mapImp;

import com.map.Heap;
import com.utils.Iterator;
import com.utilsImp.IteratorImp;

import java.util.Arrays;
import java.util.List;

/**
 * @projectName: data-structure-test
 * @package: com.mapImp
 * @className: ArrayHeap
 * @author: Zhou xiang
 * @description: 顺序存储的堆
 * @date: 2023/2/1 20:54
 * @version: 1.0
 */
public class ArrayHeap implements Heap {
    private int[] data; //堆中存储的数据
    private final int topSize; //大顶堆为0，小顶堆为1
    private final int maxSize; //堆的最大尺寸
    private int size; //堆的实际大小

    public int getTopSize() {
        return topSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getSize() {
        return size;
    }

    /*大顶堆返回序号对应data的数中，最大的那个数的序号;
            小顶堆返回序号对应data的数中，最大的那个数的序号;*/
    private int threeCompare(int a, int b, int c){
        int temp = 0;
        if(topSize == 0){
            temp = a;
            if(data[a] < data[b]){
                temp = b;
            }
            if(data[temp] < data[c]){
                temp = c;
            }

            return temp;
        }else {
            temp = a;
            if(data[a] > data[b]){
                temp = b;
            }
            if(data[temp] > data[c]){
                temp = c;
            }
            return temp;
        }
    }

    /*大顶堆返回序号对应data的数中，最大的那个数的序号;
      小顶堆返回序号对应data的数中，最大的那个数的序号;
    */
    private int twoCompare(int a, int b){
        if(topSize == 0){
            return (data[a] > data[b]) ? a : b;
        }else {
            return (data[a] < data[b]) ? a : b;
        }
    }

    /*在root左右均保持了堆的性质的时候，将根下沉，使其还保持堆性质;
      root为要下沉的根节点序号，rear为保持堆性质的数组最后一个元素的下标
     */
    private void elementDown(int root, int rear){
        int loc = root;
        for(int i = root * 2; i <= rear; i = i * 2){
            if(i + 1 <= rear){
                i = threeCompare(loc, i, i + 1);
            }else {
                i = twoCompare(loc, i);
            }
            if(loc == i){
                break;
            }else {
                int temp = data[loc];
                data[loc] = data[i];
                data[i] = temp;
                loc = i;
            }
        }
    }

    //在除最后一个元素外都保持了堆性质的时候，将最后一个元素上浮，使其还保持堆的性质
    private void elementUp(){
        int loc = data.length - 1;
        for(int i = loc / 2; i >= 1; i = i / 2){
            int max = twoCompare(i, loc);
            if(max == loc){
                int temp = data[loc];
                data[loc] = data[i];
                data[i] = temp;
                loc = i;
            }else {
                break;
            }
        }
    }

    public ArrayHeap(int[] nums , int topSize) {
        this.size = nums.length;
        this.maxSize = nums.length;
        this.topSize = topSize;
        int[] data = new int[maxSize + 1];
        for(int i = 1; i < data.length; i++){
            data[i] = nums[i - 1];
        }
        this.data = data;

        for(int i = data.length / 2; i >= 1; i--){
            elementDown(i, data.length - 1);
        }

    }

    @Override
    public boolean add(int num) {
        if(size == maxSize){
            return false;
        } else {
            size++;
            data[size] = num;
            elementUp();
            return true;
        }

    }

    @Override
    public boolean delete(int no) {
        if(no <= size && no >= 1){
            data[no] = data[size];
            size--;
            elementDown(no, size);
            return true;
        }else {
            return false;
        }

    }


    @Override
    public int[] sort() {
        int[] old = Arrays.copyOf(data, data.length);
        int[] result = new int[size];
        for(int i = size; i >= 2; i--){
            int temp = data[i];
            data[i] = data[1];
            data[1] = temp;

            elementDown(1, i - 1);
        }

        if(topSize == 0){
            for(int i = 0; i < result.length; i++){
                result[i] = data[i + 1];
            }
        }else {
            for(int i = 0; i < result.length; i++){
                result[i] = data[data.length - 1 - i];
            }
        }

        //每次排完序，会将原本的堆弄乱，要复原
        data = old;
        return result;
    }

    @Override
    public Iterator iterator() {
        Object[] objects = new Object[size];
        for(int i = 0; i < objects.length; i++){
            objects[i] = data[i + 1];
        }
        return new IteratorImp(objects);
    }
}
