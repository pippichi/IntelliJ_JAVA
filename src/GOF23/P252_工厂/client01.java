package GOF23.P252_工厂;

public class client01 {
    public static void main(String[] args) {
        Car c = new AudiFactory().createCar();
    }
}
