package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MinSwap {
    static int minimumSwaps(int[] arr) {
        int[] newArr = new int[arr.length];
        Integer cnt = 0;
       // quickSort(arr,0,arr.length,cnt);
       // cnt = insertionSort(arr,0,arr.length);
        //cnt = bubbleSort(arr);
        cnt = countSwap(arr);


        System.out.print("Count " + cnt);
        return cnt;
    }
    public static void quickSort (int[] arr, int start, int end, Integer cnt){
        if(end - start < 2){
            return ;
        }
        int pivotPosition = partition(arr,start,end,cnt);
        quickSort(arr,start,pivotPosition,cnt);
        quickSort(arr,pivotPosition+1, end, cnt);
    }
    public static int partition(int[] arr, int start, int end, Integer cnt){

        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while( i < j && arr[--j] >= pivot);
            if (i < j) {
                arr[i] = arr[j];
                cnt=+1;
                //i++;
            }
            while(i < j && arr[++i] <= pivot);
            if(i < j){
                arr[j] = arr[i];
                cnt=+1;
               // j--;
            }
        }
        arr[i] = pivot;
        return  i;
    }
    public static int insertionSort (int[] arr, int start, int end) {
        int cnt = 0;
        for(int i = 1; i < end; i ++){
            int compareNum = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1] >= compareNum; j -- ){
                arr[j] = arr[j-1];
            }
            arr[j] = compareNum;
            cnt++;
        }
       return  cnt;
    }
    public static void  swap(int[] arr, int i, int j){

        if(i == j ){
            return ;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;


    }

    public static int bubbleSort (int[] arr){
        int cnt = 0;
        for(int i = arr.length -1 ; i > 0; i -- ){
            for(int j = 0; j < i; j ++ ){
                if(arr[j] > arr[j+1]) {
                    cnt++;
                    swap(arr,j,j+1);
                }


            }

        }



        return  cnt;
    }
    public static int countSwap(int[] arr){
       int cont = 0;
      for (int index = 0 ; index < arr.length; index++){
          if(arr[index] == index+1){
              continue;
          }
          for(int j = index+1; j < arr.length; j ++){
              if(arr[j] == index+1){
                  swap(arr,index,j);
                  cont++;
                  break;
              }
          }
      }
      return cont;
    }
    public static void main(String[] args) {
       // int[] q = {4,3,1,2};
        int [] q = {1, 2, 5, 3, 7, 8, 6, 4};


        minimumSwaps(q);
    }
}
