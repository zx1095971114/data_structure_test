package com.utilsImp;

import com.map.Heap;
import com.mapImp.ArrayHeap;
import com.utils.Sort;

import java.util.Arrays;

/**
 * @projectName: data-structure-test
 * @package: com.utilsImp
 * @className: SortTool
 * @author: Zhou xiang
 * @description: 排序的实现类
 * @date: 2023/1/30 17:35
 * @version: 1.0
 */
public class SortTool implements Sort {

    @Override
    public void directInsertSort(int[] nums) {
        int i = 1; //指示排序位置，在该位置之前的数组均已排好
        while (i < nums.length){
            if(nums[i] < nums[i - 1]){
                int temp = nums[i]; //临时储存
                int j = i - 1;
                for(; j >= 0 && nums[j] > temp; j--){
                    nums[j + 1] = nums[j];
                }
                nums[j + 1] = temp;
            }
            i++;
        }
    }

    @Override
    public void halfInsertSort(int[] nums) {
        int i = 1;
        while (i < nums.length){
            if(nums[i] < nums[i - 1]){
                int low = 0;
                int high = i - 1;
                int temp = nums[i];
                while (low <= high){
                    int mid = (low + high) / 2;
                    if(nums[mid] <= temp){
                        low = mid + 1;
                    }else {
                        high = mid - 1;
                    }
                }
                for(int j = i - 1; j >= low; j--){
                    nums[j + 1] = nums[j];
                }
                nums[low] = temp;
            }
            i++;
        }
    }

    @Override
    public void shellSort(int[] nums) {
        int d = nums.length / 2; //步长
        while (d != 0){
            for(int i = 0; i < d; i++){
                int j = i + d;
                while (j < nums.length){
                    if(nums[j] < nums[j - d]){
                        int temp = nums[j];
                        int k = j - d;
                        for(; k >= 0 && nums[k] > temp; k = k - d){
                            nums[k + d] = nums[k];
                        }
                        nums[k + d] = temp;
                    }
                    j = j + d;
                }
            }
            d = d / 2;
        }

    }

    @Override
    public void bubbleSort(int[] nums) {
        boolean flag = false; //标识在一趟排序中是否发生交换
        for(int i = 0; i < nums.length; i++){ //i标识已经排好序的位置
            for(int j = nums.length - 1; j >= i + 1; j--){
                if(nums[j] < nums[j - 1]){
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;

                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    @Override
    public void quickSort(int[] nums, int low, int high) {
        if(low < high){
            int pos = partition(nums, low, high);
            quickSort(nums, low, pos - 1);
            quickSort(nums, pos + 1, high);
        }
    }

    //快速排序的一次划分
    private int partition(int[] nums, int low, int high){
        int pivot = nums[low]; //枢轴

        while (low < high){
            //开始时，空出的位置是pivot记录的low的位置，所以移动high，来填上该位置
            while (nums[high] >= pivot && low < high){
                high--;
            }
            nums[low] = nums[high];

            //high位置空出来了，移动low，找元素填high
            while (nums[low] <= pivot && low < high){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;

        return low;
    }

    @Override
    public void selectSort(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int min = i;
            for(int j = min + 1; j < nums.length; j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }

    @Override
    public void heapSort(int[] nums) {
        Heap heap = new ArrayHeap(nums,0);
//        nums = heap.sort();
        for(int i = 0; i < nums.length; i++){
            nums[i] = heap.sort()[i];
        }
    }

    @Override
    public void mergeSort(int[] nums, int low, int high) {
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }

    }

    //归并两个有序序列,low为第一个的起点，mid为第一个的终点，
    //mid + 1为第二个的起点，high为第二个的终点
    private void merge(int[] nums, int low, int mid, int high){
        int[] temp = Arrays.copyOf(nums, nums.length);
        int i = low;
        int j = mid + 1;
        int k = low; //指向原数组(用于存放排好的数据)

        while (i <= mid && j <= high){
            if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else {
                nums[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid){
            nums[k] = temp[i];
            i++;
            k++;
        }

        while (j <= high){
            nums[k] = temp[j];
            j++;
            k++;
        }
    }
}
