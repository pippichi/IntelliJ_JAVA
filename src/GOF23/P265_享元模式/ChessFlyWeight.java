package GOF23.P265_享元模式;

/**
 * 享元类
 */
public interface ChessFlyWeight {
    void setColor(String c);
    String getColor();
    void display(Coordinate c);
}


class ConcreteChess implements ChessFlyWeight{

    private String color;

    @Override
    public void setColor(String c) {
        this.color = c;
    }

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子颜色: "+color);
        System.out.println("棋子位置: "+c.getX()+"----"+c.getY());
    }
}
