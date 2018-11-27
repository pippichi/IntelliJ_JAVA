package 排序算法;

import java.util.Arrays;

public class 插入排序 {
    public static int[] Insert(int[] initial){
        int i,j;
        int insertNode;
        for(i=1;i<initial.length;i++){
            insertNode = initial[i];
            for(j=i-1;j>=0&&insertNode<initial[j];j--){
                initial[j+1] = initial[j];
            }
            initial[j+1] = insertNode;
        }
        return initial;
    }

    public static void main(String[] args){
        int[] i2 = {2,1,3,3,9,5,6,4};
        Insert(i2);
        System.out.println(Arrays.toString(i2));
    }
}
