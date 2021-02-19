package hackerrank;

import java.io.IOException;

public class CountSwap {

    public static void countSwap(int[] a){
        int n = a.length;
        int count = 0;
        for(int i = 0 ; i < n ; i ++ ){
            for (int j = 0; j < n-1; j ++ ){
                if (a[j] > a[j + 1]) {
                    count++;
                    swap(a, j, j + 1);
                }
            }
        }
        System.out.println("Array is sorted in "+ count +" swaps.");
        System.out.println("First Element: "+ a[0]);
        System.out.println("Last Element: "+ a[n-1]);
    }
    public static  void swap(int[] array, int a, int b){
        if(a == b)
            return;
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }
    public static void main(String[] args) {
        int a[] = {6,4,1};


        countSwap(a);

    }
}
