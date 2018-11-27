package JVM_测试类加载全过程;


import java.io.*;
import java.net.URL;

/**
 * 自定义网络类加载器
 */
public class P245_Net extends ClassLoader{

    //com.bjsxt.test.User  --> www.sxt.cn/myjava/ com/bjsxt/test/User.class
    private String rootUrl;

    public P245_Net(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        Class<?> c = findLoadedClass(name);
        //查询有没有加载过这个类
        if(c!=null) {
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name); //派给父类加载
            }catch (Exception e){
                e.printStackTrace();
            }
            if(c!=null){
                return c;
            }else{
                byte[] classData = getClassData(name);
                if(classData==null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassData(String className){    //com.bjsxt.test.User  --> d:/myjava/ com/bjsxt/test/User.class
        String path = rootUrl + "/" + className.replace(".","/") + ".class";

//        IOUtils,可以使用它将流中的数据转成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            URL url = new URL(path);
            is = url.openStream();
            int temp = 0;
            byte[] buffer = new byte[1024];
            while((temp=is.read(buffer))!=-1)
                baos.write(buffer,0,temp);
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            if(baos!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
