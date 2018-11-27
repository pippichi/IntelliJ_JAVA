package GOF23.P269_命令模式;

public class Invoke {

    private Command command;    //也可以通过容器List<Command>容纳很多命令对象，进行批处理，数据库底层的事务管理就是类似的结构！

    public Invoke(Command command) {
        this.command = command;
    }

    //业务方法，用于调用命令的方法
    public void call(){
        command.execute();
    }
}
