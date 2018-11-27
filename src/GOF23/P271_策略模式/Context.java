package GOF23.P271_策略模式;

/**
 * 负责和具体的策略类交互
 * 这样的话，具体的算法和直接的客户端调用分离了，使得算法可以独立于客户端独立的变化
 * 如果使用spring的依赖注入功能，还可以通过配置文件，动态注入不同策略对象，动态切换不同的算法
 */
public class Context {
    private Strategy strategy;  //当前采用的算法对象

    //通过构造器注入
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    //通过set方发注入
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void pringPrice(double s){
        System.out.println("您的报价: "+strategy.getPrice(s));
    }
}
