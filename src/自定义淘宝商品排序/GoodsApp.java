package 自定义淘宝商品排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {
    public static void main(String[] args) {
        List<Goods> goods = new ArrayList<>();
        addGoods(goods);
        Collections.sort(goods,new GoodsNameSort());
        System.out.println(goods);
        Collections.sort(goods,new GoodsPriceSort());
        System.out.println(goods);
    }
    public static void addGoods(List<Goods>goods){
        goods.add(new Goods("qyf",100,20));
        goods.add(new Goods("qyf1",170,120));
        goods.add(new Goods("qyf2",60,220));
        goods.add(new Goods("qyf3",300,3320));
        goods.add(new Goods("qyf4",200,2012));
    }
}
