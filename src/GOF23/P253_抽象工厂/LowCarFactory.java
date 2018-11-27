package GOF23.P253_抽象工厂;

public class LowCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }
}
