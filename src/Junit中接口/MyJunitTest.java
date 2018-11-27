package Junit中接口;

public class MyJunitTest {

    @Before
    public void prepare(){
        System.out.println("before :所有的测试方法之前都先执行这个方法");
    }

    @After
    public void destory(){
        System.out.println(" destroy ：所有的测试方法之后都要执行这个方法");
    }

    @Test
    public void testAdd(){
        System.out.println(" test ：testadd() ");
    }

    @Test
    public void testUpdate(){
        System.out.println(" test ：testUpdate() ");
    }
}
