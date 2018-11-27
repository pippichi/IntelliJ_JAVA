package 排序算法;

import java.util.Arrays;

public class 梳排序 {
    public static final double LAPSE_RATE = 1.3;
    public static int[] combSort(int[] a){
        int pos;
        if(a==null){
            return null;
        }
        pos = (int)(a.length / LAPSE_RATE);
        while(pos>1){
            pos /= LAPSE_RATE;
            for(int i=0;i<a.length-pos;i++){
                for(int j=i+pos;j<a.length;j+=pos){
                    if(a[j]<a[j-pos]){
                        int temp = a[j];
                        a[j] = a[j-pos];
                        a[j-pos] = temp;
                    }
                }
            }
        }
        return a;
    }
    public static void main(String[] args){
        int[] a = {5,3,6,5,5,91,239,23,1,23,17,-1,7,1,2,9,7};
        combSort(a);
        int[] b = null;
        System.out.println(Arrays.toString(a));
    }
}
