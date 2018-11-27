package GOF23;

/**
 * 通过枚举实现单例模式(没有延时加载)
 * 天然的防止反射和反序列化漏洞！
 */
public enum P249_枚举 {

    //这个枚举元素，本身就是单例对象
    INSTANCE;

    //添加自己需要的操作
    public void singletonOperation(){}
}
