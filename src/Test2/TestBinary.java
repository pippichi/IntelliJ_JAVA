package Test2;

import java.util.Random;

public class TestBinary {

    public static void main(String[] args){
        intBinary ib1 = new intBinary("qyf",16);
        intBinary ib2 = new intBinary("qyf2");

        int a = Integer.valueOf("10",2);
        int b = Integer.valueOf("11",16);
        int c = Integer.valueOf("101",8);

        int d = Integer.parseInt("10",2);
        int e = Integer.parseInt("11",16);
        int f = Integer.parseInt("101",8);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(false||true&&true);//&&的优先级要高于||

        int x = 0b10000000;
        int y = 0x10;
        int z = 010;
        System.out.println(x+" "+y+" "+z);

        int x1 = 16;
        System.out.println(x1<<2);
        System.out.println(x1>>2);
    }
}
