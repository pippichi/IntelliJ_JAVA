package 重写泛型_泛型擦除;

import java.util.List;

public class 容器排序_泛型方法 {
    public static<T extends Comparable<T>> void sort(List<T>list) {
        //第一步，转成数组
        Object[] arr = list.toArray();
        //第二步，使用方法进行排序：sort(arr);
        //第三步，改变容器中对应的值
        for(int i=0;i<arr.length;i++){
            list.set(i,(T)(arr[i]));
        }
    }
}
