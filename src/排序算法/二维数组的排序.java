package 排序算法;


public class 二维数组的排序 {
    public static int[][] binarySort(int[][] a){
        for(int i=0;i<a.length;i++){
            double currentMin = a[i][0];
            int currentMinIndex = i;
            for(int j=i;j<a.length;j++){
                if(currentMin>a[j][0]||currentMin==a[j][0]&&a[currentMinIndex][1]>a[j][1]){
                    currentMin = a[j][0];
                    currentMinIndex = j;
                }
            }
            if(currentMinIndex!=i){
               int temp0 = a[currentMinIndex][0];
               int temp1 = a[currentMinIndex][1];
               a[currentMinIndex][0] = a[i][0];
               a[currentMinIndex][1] = a[i][1];
               a[i][0] = temp0;
               a[i][1] = temp1;
            }
        }
        return a;
    }
    public static void printArray(int[][] a){
        for(int i=0;i<a.length;i++){
            System.out.print("("+a[i][0]+","+a[i][1]+") ");
        }
    }
    public static void main(String[] args){
        int[][] a = {{1,2},{3,4},{3,2},{5,1},{7,8},{10,1},{4,11}};
        binarySort(a);
        printArray(a);
    }
}
