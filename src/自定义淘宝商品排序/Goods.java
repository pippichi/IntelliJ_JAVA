package 自定义淘宝商品排序;

public class Goods {
    private int price;
    private int fav;
    private String name;

    public Goods() {
    }

    public Goods(String name, int fav, int price) {
        this.price = price;
        this.fav = fav;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        str.append("商品名称: "+name).append("\t");
        str.append("商品价格: "+price).append("\t");
        str.append("商品收藏量: "+fav).append("\n");

        return str.toString();
    }
}
