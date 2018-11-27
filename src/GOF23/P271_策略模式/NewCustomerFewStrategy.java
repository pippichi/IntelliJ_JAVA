package GOF23.P271_策略模式;

public class NewCustomerFewStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("不打折");
        return standardPrice;
    }
}
