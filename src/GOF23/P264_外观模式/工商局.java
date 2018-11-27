package GOF23.P264_外观模式;

public interface 工商局 {
    void checkName();   //核名
}

class 萧山区工商局 implements 工商局{

    @Override
    public void checkName() {
        System.out.println("检查名字是否有冲突! ");
    }
}
