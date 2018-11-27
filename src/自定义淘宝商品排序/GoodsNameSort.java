package 自定义淘宝商品排序;

/**
 * 排序业务类，专门搞定排序的类
 */
public class GoodsNameSort implements java.util.Comparator<Goods>{
    @Override
    public int compare(Goods o1,Goods o2){
        return -(o1.getName().compareTo(o2.getName())>0?1:o1.getName().compareTo(o2.getName())==0?0:-1);
    }
}
