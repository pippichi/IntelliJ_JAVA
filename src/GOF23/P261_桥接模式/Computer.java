package GOF23.P261_桥接模式;

/**
 * 未使用桥接模式
 */
public interface Computer {
    void sale();
}

class Desktop implements Computer{

    @Override
    public void sale() {
        System.out.println("销售台式机!");
    }
}

class Laptop implements Computer{

    @Override
    public void sale() {
        System.out.println("销售手提电脑!");
    }
}

class Pad implements Computer{

    @Override
    public void sale() {
        System.out.println("销售Pad!");
    }
}

class LenovoDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售联想台式机!");
    }
}

class LenovoLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("销售联想手提电脑!");
    }
}

class LenovoPad extends Pad{
    @Override
    public void sale() {
        System.out.println("销售联想Pad!");
    }
}

class ShenzhouDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售神州台式机!");
    }
}

class ShenzhouLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("销售神州手提电脑!");
    }
}

class ShenzhouPad extends Pad{
    @Override
    public void sale() {
        System.out.println("销售神州Pad!");
    }
}

class DellDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售戴尔台式机!");
    }
}

class DellLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("销售戴尔手提电脑!");
    }
}

class DellPad extends Pad{
    @Override
    public void sale() {
        System.out.println("销售戴尔Pad!");
    }
}