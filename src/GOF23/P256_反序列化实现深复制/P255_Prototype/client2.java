package GOF23.P256_反序列化实现深复制.P255_Prototype;

/**
 * 测试普通new方式创建对象和clone方式创建对象的效率差异!
 * 如果
 */
public class client2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        testNew(1000);
        testClone(1000);
    }
    public static void testNew(int times){
        long start = System.currentTimeMillis();
        for(int i=0;i<times;i++){
            Laptop t = new Laptop();
        }
        long end = System.currentTimeMillis();
        System.out.println("new的方式创建耗时: "+(end-start));
    }
    public static void testClone(int times) throws CloneNotSupportedException {
        Laptop t = new Laptop();
        long start = System.currentTimeMillis();
        for(int i=0;i<times;i++){
            Laptop temp = (Laptop) t.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("clone的方式创建耗时: "+(end-start));
    }
}

class Laptop implements Cloneable{   //笔记本电脑
    public Laptop(){
        try{
            Thread.sleep(10);   //模拟耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}