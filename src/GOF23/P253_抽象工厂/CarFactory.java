package GOF23.P253_抽象工厂;

public interface CarFactory {
    Engine createEngine();
    Tyre createTyre();
    Seat createSeat();
}
