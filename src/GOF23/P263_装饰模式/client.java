package GOF23.P263_装饰模式;

public class client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        System.out.println("天上飞-----");
        FlyCar car1 = new FlyCar(car);
        car1.move();
        System.out.println("水上漂-----");
        WaterCar car2 = new WaterCar(car);
        car2.move();
        System.out.println("天上飞，水上漂-----");
        WaterCar car3 = new WaterCar(car1);
        car3.move();

        System.out.println("天上飞，水上漂-----2");
        WaterCar car4 = new WaterCar(new FlyCar(new Car()));
        car4.move();
    }
}
