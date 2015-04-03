package com.example.demo.sort;

//排序结果最终是升序
public class SortUtil {
  
  /**
   * 1. 冒泡排序
   */
  public static void bubbleSort(int[] data) {
      // TODO Auto-generated method stub
      int len = data.length;
      
      for (int i = len - 1; i > 0; i--) {
          boolean change = false;
          
          for (int j = 0; j < i; j++) {
              //大数据往后沉，一轮过后最大的数据在最后
              if (data[j] > data[j+1]) {
                  int tmp = data[j];
                  data[j] = data[j+1];
                  data[j+1] = tmp;
                  change = true;
              }
          }
          
          if (change == false) {
              //没有新的数据交换，说明已经排好了。
              break;
          }
      }
  }
  
  
  /**
   * 2. 选择排序
   */
  public static void selectSort(int[] data) {
      int len = data.length;
      
      for (int i = 0; i < len; i++) {
          int min = i;//
          
          for (int j = i+1; j < len; j++) {
              //一轮下来找到[i, len)区间最小的元素，并与i位置元素交换
              if (data[min] > data[j]) {
                  min = j;
              }
          }
          
          if (min != i) {
              int tmp = data[i];
              data[i] = data[min];
              data[min] = tmp;
          }
      }
  }
  
  /**
   * 3. 插入排序
   */
  public static void insertSort(int[] data) {
      int len = data.length;
      
      for (int i = 1; i < len; i++) {
          for (int j = i; j > 0; j--) {
              if (data[j] < data[j-1]) {
                  int tmp = data[j];
                  data[j] = data[j-1];
                  data[j-1] = tmp;
              } else {
                  break;
              }
          }
      }
  }
  
  /**
   * 4. 归并排序，分而治之思想
   */
  public static void mergeSort(int[] data, int start, int end) {
      
      if (start >= end) {
          return;
      }
      
      int mid = (start + end) / 2;
      mergeSort(data, start, mid);
      mergeSort(data, mid+1, end);
      
      //现在[start, mid]和[mid+1, end]均已有序
      int ret[] = new int[end-start+1];
      int i = start, j = mid+1;
      int k = 0;
      for (; i <= mid && j <= end ; k++) {
          if (data[i] < data[j]) {
              ret[k] = data[i];
              i++;
          } else {
              ret[k] = data[j];
              j++;
          }
      }
      
      while (i <= mid) {
          ret[k] = data[i];
          i++;
          k++;
      }
      while (j <= end) {
          ret[k] = data[j];
          j++;
          k++;
      }
      
      System.arraycopy(ret, 0, data, start, ret.length);
  }
  
  /**
   * 5. 快速排序
   * 思想：选定一个枢纽元素，对待排序序列进行分割，分割之后的序列一个部分小于枢纽元素，
   * 一个部分大于枢纽元素，再对这两个分割好的子序列进行上述的过程。
   */
  public static void quickSort(int[] data, int start, int end) {
      
      if (start >= end) {
          return;
      }
      
      {
          int mid = (start + end) / 2;
          int tmp = data[mid];
          data[mid] = data[start];
          data[start] = tmp;
      }
      
      int index = partition(data, start, end);
      quickSort(data, start, index);
      quickSort(data, index+1, end);
      
  }
  //辅助函数
  private static int partition(int data[], int start, int end) {
      int n = data[start];
      
      while (start < end) {
          while (data[end] >= n && start < end) {
              end--;
          }
          
          //swap
          {
              int tmp = data[end];
              data[end] = data[start];
              data[start] = tmp;
          }
          
          while (data[start] <= n && start < end) {
              start++;
          }
          
          //swap
          {
              int tmp = data[start];
              data[start] = data[end];
              data[end] = tmp;
          }
      }
      
      return start;
  }

}
