package 排序算法;

import java.util.Arrays;

public class 快速排序 {
    public static int[] quickSort(int[]a ,int low,int high){
        if (low<high) {
            int i = low;
            int j = high;
            int key = a[low];
            while (i < j && key < a[j]) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && key > a[i]) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
            a[i] = key;
            quickSort(a, low, i - 1);
            quickSort(a, i + 1, high);
        }
        return a;
    }
    public static int[] quickSort(int[] a){
        if(a.length>0){
            quickSort(a,0,a.length-1);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {2,7,9,3,5,6,1,8};
        quickSort(a);
        System.out.println(args[0]);
        System.out.println(Arrays.toString(a));
    }
}
