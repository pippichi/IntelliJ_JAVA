package GOF23.P254_建造者模式;

public class cilent {
    public static void main(String[] args) {
        AirShipDirector director = new SxtAirshipDirector(new SxtAirShipBuilder());

        AirShip ship = director.directAirShip();

        System.out.println(ship.getEngine().getName());
        ship.launch();
    }
}
