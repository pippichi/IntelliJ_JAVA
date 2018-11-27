package 排序算法;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args){
        int[] value = {2,3,1,10,9,59,6,3,2,10};
        Arrays.fill(value,1,2,5);
        System.out.println(Arrays.toString(value));
        sort(value);
        System.out.println(Arrays.toString(value));
    }
    public static void sort(int[] value){
        int temp;
        for(int i=0;i<value.length-1;i++){
            boolean sorted = true;
            for(int j=0;j<value.length-1-i;j++){
                if(value[j]>value[j+1]){
                    temp = value[j];
                    value[j] = value[j+1];
                    value[j+1] = temp;
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
    }
}
