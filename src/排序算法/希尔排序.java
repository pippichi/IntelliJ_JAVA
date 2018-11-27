package 排序算法;

import java.util.Arrays;

public class 希尔排序 {
    public static int[] ShellSort(int[]a){
        int temp;
        int j;
        for(int gap=a.length;gap>0;gap/=2){
            for(int i=gap;i<a.length;i++){
                temp = a[i];
                for(j=i-gap;j>=0&&temp<a[j];j-=gap){
                    a[j+gap] = a[j];
                }
                a[j+gap] = temp;
            }
        }
        return a;
    }

    public static void main(String[] args){
        int[] a = {9,8,2,5,4,3,6,87};
        ShellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
