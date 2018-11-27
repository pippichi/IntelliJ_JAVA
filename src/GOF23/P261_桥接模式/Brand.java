package GOF23.P261_桥接模式;

/**
 * 使用桥接模式
 */
public interface Brand {
    void sale();
}

class Lenovo implements Brand{

    @Override
    public void sale() {
        System.out.println("销售联想电脑!");
    }
}

class Dell implements Brand{

    @Override
    public void sale() {
        System.out.println("销售戴尔电脑!");
    }
}

class Shenzhou implements Brand{

    @Override
    public void sale() {
        System.out.println("销售神州电脑!");
    }
}

