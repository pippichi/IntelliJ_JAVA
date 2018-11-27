package for循环别名;

/**
 * for循环别名,用于停止外层循环
 */
public class test1 {
    public static void main(String[] args) {
        int i=0,j=5;
        t1:for(;;){
            i+=2;
            t2:for(;;){
                if(i>j--){
                    break t1;
                }else{
                    System.out.println(i+" "+j);
                }
            }
        }
        System.out.println("i="+i+"j="+j);
    }
}
