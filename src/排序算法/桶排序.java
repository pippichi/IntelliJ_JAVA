package 排序算法;


public class 桶排序 {
    public static void bucketSort(int[] a,int n){
        int[] sorted = new int[n];
        for(int i=0;i<a.length;i++){
            sorted[a[i]] = 1;
        }
        for(int i=0;i<sorted.length;i++){
            if(sorted[i]==1){
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args){
        int[] a = {2,3,4,3,1};
        bucketSort(a,a.length);
    }
}
