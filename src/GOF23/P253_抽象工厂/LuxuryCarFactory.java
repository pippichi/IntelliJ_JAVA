package GOF23.P253_抽象工厂;

public class LuxuryCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }
}
