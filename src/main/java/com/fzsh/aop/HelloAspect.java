package com.fzsh.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * @Author yangxin
 * @Date 2020/4/1 21:06
 * @Version 1.0
 */
@Component
@Aspect
public class HelloAspect {





    public static void main(String[] args) {
       int [] arr = {101,42,23,21,1};
    shellSort(arr);
        System.out.println(Arrays.toString(arr));
       //希尔排序
        // 第一轮

       /*//插入排序
        insertSort(arr);
        System.out.println(Arrays.toString(arr));*/
        //选择排序

        /*for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
        System.out.println(Arrays.toString(arr));*/
    }

    /**
     * 冒泡排序
     */
    public static int[] sort(int data[]){
        int temp =0;
        boolean flag=false;
        for(int j=0;j<data.length-1;j++){
            for(int i=0;i<data.length-1-j;i++) {
                if (data[i] > data[i + 1]) {
                    flag = true;
                    temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
            if(flag){
                flag=false;
            }else {
                break;
            }
            System.out.println(System.currentTimeMillis());
        }
        return data;
    }
    /*
    插入排序
     */
    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while(insertIndex >=0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
        Set fset =

    }
    public static void shellSort(int[] arr){

        for(int gap = arr.length/2;gap > 0;gap /= 2){
            for(int i=gap;i<arr.length;i++){
                int index = i-gap;
                int indexval = arr[i];
                while(index >= 0 && indexval<arr[index]){
                    arr[index+gap] = arr[index];
                    index -= gap;
                }
                arr[index+gap] = indexval;
            }
        }
    }
    public static void quickSort(int[] arr,int left,int right){
        if(left > right){
            return;
        }
        int base = arr[left];
        int i=left;
        int j = right;
        while(i!=j){
            while(arr[j] >= base && j>i){
                j--;
            }
            while(arr[i] >= base && i<j){
                i++;
            }
            //符合条件
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);

    }
}
