package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * 写出数据:输出流
 * 读取数据:输入流
 */
public class P218_server {

    private List<MyChannel> all = new ArrayList<>();

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new P218_server().start();
    }

    /**
     * 一个客户端 一条道路
     * 1、输入流
     * 2、输出流
     * 3、接收数据
     * 4、发送数据
     */

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while(true) {
            Socket client = server.accept();
            //写出数据
            //输入流
            MyChannel channel = new MyChannel(client);
            all.add(channel); //统一管理
            new Thread(channel).start();//一条道路
        }

    }

    private class MyChannel implements Runnable{

        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;
        private String name;

        public MyChannel(Socket client){
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

                this.name = dis.readUTF();
                this.send("欢迎进入聊天室");
                sendOthers(this.name+"进入了聊天室",true);
//                System.out.println(this.name);
            } catch (IOException e) {
//                e.printStackTrace();
                P216_closeUtil.closeAll(dis,dos);
                isRunning = false;
            }
        }

        /**
         * 读取数据
         * @return
         */
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                P216_closeUtil.closeAll(dis);
                all.remove(this); //移除自身,退出群聊
                sendOthers(this.name+"退出了聊天室",true);
            }
            return msg;
        }

        /**
         * 发送数据
         */
        private void send(String msg){
            if(msg==null||msg.equals(""))
                return;
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                P216_closeUtil.closeAll(dos);
                all.remove(this);//移除自身,推出群聊
                sendOthers(this.name+"退出了聊天室",true);
            }
        }

        /**
         * 发送给其他客户端
         */
        private void sendOthers(String msg,boolean sys){
            //遍历容器
            //是否为私聊
            if(msg.startsWith("@")&&msg.indexOf(":")==this.name.length()+1){
                //获取name
                String name = msg.substring(1,msg.indexOf(":"));
                String content = msg.substring(msg.indexOf(":")+1);
                for (MyChannel other:all){
                    if(other.name.equals(name)){
                        other.send(this.name+" 对你说: "+content);
                    }
                }
            }else {
                for (MyChannel temp : all) {
                    if (temp == this)
                        continue;
                    if(sys) {//系统信息
                        temp.send("系统信息: " + msg);
                    }else {
                        //发送给其他客户端
                        temp.send(this.name + " 对所有人说: " + msg);
                    }
                }
            }
        }

        @Override
        public void run() {
            while(isRunning){
                sendOthers(receive(),false);
            }
        }
    }
}
