package 注解Annotation;

@Demo01
public class Test {
    @Demo01(study = "good",grades = 100,id = 1600702113,schools = {"浙江大学"})
    public void test(){}

    @Demo02("aaaaaa")//因为这个注解只有一个属性值value 所以 value = "aaa"  ---> "aaa"
    public static void test01(){}
}
