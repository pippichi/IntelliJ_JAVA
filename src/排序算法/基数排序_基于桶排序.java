package 排序算法;

import java.util.ArrayList;
import java.util.Arrays;

public class 基数排序_基于桶排序 {
    public static int[] radixSort(int[] a,int size){
        //基于桶排序的基数排序

        //确定排序的趟数，即排序数组中最大值为809时，趟数为3
        int max = a[0];
        for(int i=0;i<size;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        //算出max的位数
        int time = 0;
        while(max>0){
            max/=10;
            time++;
        }
        //【桶】初始化是个链表作为桶，用户分配时暂存
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            ArrayList<Integer> item = new ArrayList<>();
            list.add(item);
        }
        //进行time次分配和收集
        for(int i=0;i<time;i++){

            //分配元素，按照次序优先，从个位数开始
            for(int j=0;j<size;j++){
                int index = a[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10,i);
                list.get(index).add(a[j]);
            }
            //收集元素，一个一个桶地收集
            int count = 0;
            //10个桶
            for(int k=0;k<10;k++){
                if(list.get(k).size()>0){

                    for(int temp:list.get(k)){
                        a[count++] = temp;
                    }
                    //清除数据，一边下一次收集
                    list.get(k).clear();
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = {9,6,3,4,5,6,6,4,4,3,2,46,5,7,6,1,5,4,3,5};
        radixSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
