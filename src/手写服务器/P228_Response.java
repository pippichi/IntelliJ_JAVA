package 手写服务器;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class P228_Response {

    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";
    //流
    private BufferedWriter bw;

    //正文
    private StringBuilder content;

    //存储头信息
    private StringBuilder headInfo;

    //存储正文长度
    private int len = 0;
    public P228_Response(){
        headInfo = new StringBuilder();
        content = new StringBuilder();
        len = 0;
    }
    public P228_Response(OutputStream os){
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }
    public P228_Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            headInfo = null;
        }
    }
    /**
     * 构建正文
     */
    public P228_Response print(String con){
        content.append(con);
        len+=con.getBytes().length;
        return this;
    }
    /**
     * 构建正文+回车
     */
    public P228_Response println(String con){
        content.append(con).append(CRLF);
        len+=(con+CRLF).getBytes().length;
        return this;
    }

    /**
     * 构建响应头
     */
    private void createHeadInfo(int code){
        //1\    HTTP协议版本、状态码、描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code){
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT FIND");
                break;
            case 500:
                headInfo.append("SERVER ERROR");
        }

        headInfo.append(CRLF);
        //2\    响应头(P223_Response Head)
        headInfo.append("Server:bjsxt Server/0.0.1").append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Content-type:text/html;charset=GBK").append(CRLF);
        //3\    正文长度:字节长度
        headInfo.append("Content-Length:").append(len).append(CRLF);
        headInfo.append(CRLF); //分隔符
    }

    //推送到客户端
    void pushToClient(int c){
        if(headInfo==null){
            c = 500;
        }
        createHeadInfo(c);
        try {
            //头信息+分隔符
            bw.append(headInfo.toString());
            bw.append(content.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        FileUtil.closeAll(bw);
    }
}
