package 排序算法;

import java.util.Arrays;

public class 三向切分的快速排序 {
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        int lt = lo,i = lo + 1,gt = hi;
        Comparable v = a[lo];
        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0) exch(a,lt++,i++);
            else if(cmp>0) exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];a[i] = a[j]; a[j] = t;
    }

    public static void main(String[] args) {
        Comparable[] a = {1,2,3,-1,-2,-3};
        sort(a,0,5);
        Arrays.stream(a).forEach(System.out::println);
    }
}
