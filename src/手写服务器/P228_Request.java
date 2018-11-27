package 手写服务器;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 封装request
 */
public class P228_Request {
    //请求方式
    private String method;
    //请求资源
    private String url;

    public String getUrl() {
        return url;
    }

    //请求参数
    private Map<String, List<String>> paramMapValues;

    //内部
    public static final String CRLF = "\r\n";
    private InputStream is;
    private String requestInfo;

    public P228_Request(){
        method = "";
        url = "";
        paramMapValues = new HashMap<>();
        requestInfo = "";
    }
    public P228_Request(InputStream is){
        this();
        this.is = is;
        byte[] data = new byte[20480];
        try {
            int len = is.read(data);
            requestInfo = new String(data,0,len);
        } catch (IOException e) {
            return;
        }

        //分析头信息
        parseRequestInfo();
    }

    /**
     * 分析请求信息
     */
    private void parseRequestInfo(){
        if(null==requestInfo||(requestInfo=requestInfo.trim()).equals("")){
            return;
        }

        /**
         * ==================================================
         * 从信息的首航分解出:请求方式   请求路径    请求参数(get可能存在)
         *     如:GET/index.html?name=123&pwd=5456 HTTP/1.1
         *
         *如果为post方式，请求参数可能在最后正文中
         *
         *
         *
         * ==================================================
         */

        String paramString = "";    //接收请求参数
//        获取请求方式
        String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
        int idx = requestInfo.indexOf("/");
        this.method = firstLine.substring(0,idx).trim();
        String urlstr = firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();

        if(this.method.equalsIgnoreCase("post")){
            this.url = urlstr;
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        }else if(this.method.equalsIgnoreCase("get")){
            if(urlstr.contains("")){    //是否存在参数
                String[] urlArray = urlstr.split("\\?");
                this.url = urlArray[0];
                paramString = urlArray[1];  //接收请求参数
            }else{
                this.url = urlstr;
            }
        }

        //不存在请求参数
        if(paramString.equals(""))
            return;
        //2、将请求参数封装到Map中
        parseParams(paramString);
    }
    private void parseParams(String param){
        //分割 将字符串转成数组
        StringTokenizer token = new StringTokenizer(param,"&");
        while(token.hasMoreTokens()){
            String keyValue = token.nextToken();
            String[] keyvalues = keyValue.split("=");
            if(keyvalues.length==1){
                keyvalues = Arrays.copyOf(keyvalues,2);
                keyvalues[1]=null;
            }

            String key = keyvalues[0].trim();
            String value = keyvalues[1]==null?null:decode(keyvalues[1].trim(),"gbk");

            //转换成Map 分拣
            if(!paramMapValues.containsKey(key)){
                paramMapValues.put(key,new ArrayList<>());
            }
            List<String> values = paramMapValues.get(key);
            values.add(value);
        }
    }

    /**
     * 解码
     * @param value
     * @param code
     * @return
     */
    private String decode(String value,String code){
        try {
            return java.net.URLDecoder.decode(value,code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据ue，页面的name 获取对应的多个值
     * @param name
     * @return
     */
    public String[] getParameterValues(String name){
        List<String> values = null;
        if((values=paramMapValues.get(name))==null){
            return null;
        }else{
            return values.toArray(new String[0]);//将toArray()对象直接转换成String[]
        }
    }

    /**
     * 根据页面的name 获取对应的值
     */
    public String getParameter(String name){
        String[] values = getParameterValues(name);
        if(values==null){
            return null;
        }else{
            return values[0];
        }
    }
    public static void main(String[] args) {
        String params = "uname=&pwd=213&fav=0&fav=1&fav=2";
        new P228_Request().parseParams(params);
    }
}
