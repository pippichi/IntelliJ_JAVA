package 排序算法;

import java.util.Arrays;

public class 堆排序 {
    public static int[] heapSort(int[] a,int length){
        /**
         * 堆排序算法
         */
        int i;
        /**
         * 先把啊a[]数组构建成一个大顶堆
         * 从完全二叉树的最下层最右边的非终端结点开始构建
         */
        for(i=length/2-1;i>=0;i--){
            HeapAdjust(a,i,length);
        }

        /**
         * 开始遍历
         */
        for(i=length-1;i>=0;i--){
            swap(a,0,i);
            //每交换一次得到一个最大值然后丢弃
            HeapAdjust(a,0,i);
        }
        return a;
    }

    /**
     * a[i]代表的是下标为i的根结点
     * @param a
     * @param i
     * @param length
     */
    private static void HeapAdjust(int[] a,int i,int length){
        //[注意]这里下标从0开始
        int temp;
        //存储根节点
        temp = a[i];
        //沿根节点的左右孩子中较大的往下遍历，由于完全二叉树特性 i的左子节点的下标为2i+1 i的右子节点的下标为2i+2
        for(int j=2*i+1;j<length;j=j*2+1){
            //一直访问左孩子
            if(j<length-1&&a[j]<a[j+1]){
                ++j;
            }
            if(temp>=a[j]){
                break;
            }
            //将子节点赋值给根节点
            a[i] = a[j];
            //将子节点下标赋值给i
            i = j;
        }
        //将存储的根结点的值赋值给子节点
        a[i] = temp;
    }
    private static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9,7,8,6,5,3,5,4,1,3,4};
        heapSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}
