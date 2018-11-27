package 排序算法;

import java.util.Arrays;

public class 选择排序 {
    public static int[] selectSort(int[] a){
        int minIndex;
        for(int i=0;i<a.length-1;i++){
            minIndex = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[minIndex]){
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return a;
    }
    public static void main(String[] args){
        int[] a = {9,5,7,6,8,4,3,2,6,1};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
