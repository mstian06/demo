package com.example.demo.sort;

public class Main {
    
    public static void main(String[] args) {
        
        int data[] = {4, 2, 5, 6, 8, 3, 9, 10, 3, 7, 1, 21, 18, 17, 16, 15, 
                12, 13, 14, 11};
        printData(data);
        
//      SortUtil.bubbleSort(data);
//      SortUtil.selectSort(data);
//      SortUtil.insertSort(data);
//      SortUtil.mergeSort(data, 0, data.length-1);
        SortUtil.quickSort(data, 0, data.length-1);
        
        printData(data);
    }
    
    public static void printData(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println();
    }

}