package com.utilsImp;

import com.utils.Sort;

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
    }
}
