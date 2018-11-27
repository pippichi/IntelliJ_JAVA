package 排序算法;

import java.util.Arrays;

public class 合并排序_归并排序的前身 {
    public static int[] mergeSort(int[] a,int[] b){
        int i,j,k;
        i = j = k = 0;
        int lA = a.length;
        int lB = b.length;
        int[] c = new int[lA+lB];
        while(i<lA&&j<lB){
            if(a[i]<b[j]){
                c[k++] = a[i++];
            }
            else{
                c[k++] = b[j++];
            }
        }
        while(i<lA){
            c[k++] = a[i++];
        }
        while(j<lB){
            c[k++] = b[j++];
        }
        return c;
    }
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {2,3,6,8};
        int[] c = mergeSort(a,b);
        System.out.println(Arrays.toString(c));
    }
}
