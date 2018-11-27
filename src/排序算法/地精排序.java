package 排序算法;

import java.util.Arrays;

public class 地精排序 {
    public static int[] gnomeSwap(int[] a){
        int pos = 1;
        int lA = a.length;
        while(pos<lA){
            if(a[pos]>a[pos-1]){
                pos++;
            }else{
                int temp = a[pos-1];
                a[pos-1] = a[pos];
                a[pos] = temp;
                if(pos>1) pos--;
            }
        }
        return a;
    }
    public static void main(String[] args){
        int[] a = {5,4,2,3,1};
        gnomeSwap(a);
        System.out.println(Arrays.toString(a));
    }
}
