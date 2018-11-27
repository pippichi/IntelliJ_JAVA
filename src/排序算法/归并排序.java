package 排序算法;

import java.util.Arrays;

public class 归并排序 {
    public static void mergeSort(int[] a,int left,int mid,int right){
        int record = left;
        int record2 = left;
        int m = mid + 1;
        int[] k = new int[a.length];
        while(left<=mid&&m<=right){
            if(a[left]<=a[m]){
                k[record++] = a[left++];
            }else{
                k[record++] = a[m++];
            }
        }
        while(left<=mid){
            k[record++] = a[left++];
        }
        while(m<=right){
            k[record++] = a[m++];
        }

        for(;record2<=right;record2++){
            a[record2] = k[record2];
        }
    }

    public static void mSort(int[] a,int left,int right){
        if(left>=right){
            return;
        }
        int mid = (left + right) / 2;
        mSort(a,left,mid);
        mSort(a,mid+1,right);
        mergeSort(a,left,mid,right);
    }
    public static int[] Sort(int[] a){
        int len = a.length;
        mSort(a,0,len-1);
        return a;
    }
    public static void main(String[] args){
        int[] a = {5,4,3,77,4,2,9,0,1,11};
        Sort(a);
        System.out.println(Arrays.toString(a));
    }
}
