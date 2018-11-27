package 反射;

import 反射1.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Demo05 {
    public void test01(Map<String,User> map, List<User>list){
        System.out.println("Demo05.test01()");
    }

    public Map<Integer,User> test02(){
        System.out.println("Demo05.test02()");
        return null;
    }

    public static void main(String[] args) {

        try{

            //获得指定方法参数泛型信息
            Method m = Demo05.class.getDeclaredMethod("test01",Map.class,List.class);
            Type[] t = m.getGenericParameterTypes();
            for(Type paramType:t){
                System.out.println("#"+paramType);
                if(paramType instanceof ParameterizedType){
                    Type[] genericType = ((ParameterizedType)paramType).getActualTypeArguments();
                    for(Type temp:genericType){
                        System.out.println("泛型类型："+temp);
                    }
                }
            }

            //获得指定方法返回值泛型信息
            Method m2 = Demo05.class.getDeclaredMethod("test02",null);
            Type returnType = m2.getGenericReturnType();
            if(returnType instanceof ParameterizedType){
                Type[] temp = ((ParameterizedType)returnType).getActualTypeArguments();

                for(Type genericType:temp){
                    System.out.println("返回值，泛型类型："+genericType);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
