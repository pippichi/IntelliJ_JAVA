package 排序算法;

import java.util.Arrays;

public class 计数排序 {
    public static int[] countingSort(int[] a,int n){
        if(a==null||n<2){
            return a;
        }
        int max = a[0];
        int min = a[0];
        for(int i=0;i<a.length;i++){
            max = Math.max(a[i],max);
            min = Math.min(a[i],min);
        }
        int[] arr = new int[max-min+1];
        for(int i=0;i<a.length;i++){
            arr[a[i]-min]++;
        }
        int index = 0;
        for(int i=0;i<arr.length;i++){
            while(arr[i]-->0){
                a[index++] = i + min;
            }
        }
        return a;
    }
    public static void main(String[] args){
        int[] a = {6,4,9,23,1,0,33,3,3,1};
        countingSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
