package GOF23.P271_策略模式;

public class NewCustomerManyStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打9折");
        return standardPrice*0.9;
    }
}
