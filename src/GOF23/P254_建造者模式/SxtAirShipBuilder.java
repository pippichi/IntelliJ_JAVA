package GOF23.P254_建造者模式;

public class SxtAirShipBuilder implements AirShipBuilder {
    @Override
    public Engine builderEngine() {
        System.out.println("构建发动机!");
        return new Engine("Sxt发动机!");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建轨迹仓!");
        return new OrbitalModule("Sxt轨迹仓");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建逃逸塔!");
        return new EscapeTower("Sxt逃逸塔!");
    }//StringBuilder,以后学习XML解析中，JDOM库中的类:DomBuilder,SaxBuilder
}
