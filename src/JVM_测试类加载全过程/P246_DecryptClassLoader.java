package JVM_测试类加载全过程;

import java.io.*;

/**
 * 加载文件系统中加密后的class字节码的类加载器
 */
public class P246_DecryptClassLoader extends ClassLoader{
    //com.bjsxt.test.User  --> d:/myjava/ com/bjsxt/test/User.class
    private String rootDir;

    public P246_DecryptClassLoader(String rootDir) {
        this.rootDir = rootDir;
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
        String path = rootDir + "/" + className.replace(".","/") + ".class";

//        IOUtils,可以使用它将流中的数据转成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            is = new FileInputStream(path);
            int temp = 0;
            while((temp=is.read())!=-1)
                baos.write(temp^0xff); //取反操作
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

