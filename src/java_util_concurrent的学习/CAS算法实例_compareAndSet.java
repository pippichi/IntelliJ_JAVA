package java_util_concurrent的学习;


public class CAS算法实例_compareAndSet {
    public static void main(String[] args) {
        CompareAndSet cas = new CompareAndSet();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    int expectedValue = cas.get();
                    boolean b = cas.compareAndSet(expectedValue,(int)(Math.random()*1000));
                    System.out.println(b);
                }
            }).start();
        }
    }
}

class CompareAndSet{
    private int value;

    //获取内存值
    public synchronized int get(){
        return value;
    }

    //比较
    public synchronized int compareAndSwap(int expectedValue,int newValue){
        int oldValue = value;
        if(oldValue==expectedValue){
            this.value = newValue;
        }
        return oldValue;
    }

    //设置
    public synchronized boolean compareAndSet(int expectedValue,int newValue){
        return expectedValue==compareAndSwap(expectedValue,newValue);
    }
}
