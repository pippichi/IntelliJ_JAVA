package GOF23.P271_策略模式;

public class OldCustomerFewStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打85折");
        return standardPrice*0.85;
    }
}
