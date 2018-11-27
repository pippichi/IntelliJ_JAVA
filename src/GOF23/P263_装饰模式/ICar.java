package GOF23.P263_装饰模式;

/**
 * 抽象构建
 */
public interface ICar {
    void move();
}

class Car implements ICar{

    /**
     * ConcreteComponent 具体构建角色(真实对象)
     */
    @Override
    public void move() {
        System.out.println("陆地上跑!");
    }
}

class SuperCar implements ICar{

    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

/**
 * ConcreteDecorator具体装饰角色
 */
class FlyCar extends SuperCar{

    public FlyCar(ICar car) {
        super(car);
    }
    public void fly(){
        System.out.println("天上飞!");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

/**
 * ConcreteDecorator具体装饰角色
 */
class WaterCar extends SuperCar{

    public WaterCar(ICar car) {
        super(car);
    }
    public void swim(){
        System.out.println("水上游!");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}
/**
 * ConcreteDecorator具体装饰角色
 */
class AICar extends SuperCar{

    public AICar(ICar car) {
        super(car);
    }
    public void autoMove(){
        System.out.println("自动跑!");
    }

    @Override
    public void move() {
        super.move();
        autoMove();
    }
}