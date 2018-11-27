package net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收线程
 */
public class P218_Receive implements Runnable{

    //输入流
    private DataInputStream dis;
    //线程标识
    private boolean flag = true;

    public P218_Receive(){}
    public P218_Receive(Socket client){
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            P215_closeUtil.closeAll(dis);
        }
    }

    /**
     * 接收数据
     */
    public String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            P215_closeUtil.closeAll(dis);
        }
        return msg;
    }
    @Override
    public void run() {
        //线程体
        while (flag)
            System.out.println(receive());
    }
}
