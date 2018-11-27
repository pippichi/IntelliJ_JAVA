package 多线程;

/**
 * 静态代理 设计模式
 * 1、真实角色
 * 2、代理角色: 持有真实角色的引用
 * 3、二者 实现相同的接口
 */
public class Demo02 {
    public static void main(String[] args) {
        Marry you = new You();
        Company c = new Company(you);
        c.marry();
    }
}
interface Marry{
    void marry();
}
//主要角色
class You implements Marry{

    @Override
    public void marry() {
        System.out.println("你和。。。结婚了！");
    }
}
//代理角色
class Company implements Marry{
    private Marry you;

    public Company(Marry you) {
        this.you = you;
    }

    public Company() {
    }
    public void before(){
        System.out.println("先。。。");
    }
    public void after(){
        System.out.println("后。。。");
    }
    @Override
    public void marry() {
        before();
        you.marry();
        after();
    }
}
