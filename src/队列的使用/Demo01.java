package 队列的使用;
/**
 * Queue\PriorityQueue\ArrayDeque
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo01 {
    public static void main(String[] args) {
        Queue<Request> queue = new ArrayDeque<>();
        for(int i=0;i<10;i++){
            int num = i;
            queue.offer(new Request(){
               @Override
               public void deposit(){
                   System.out.println("第"+(num+1)+"个人的存款额度为："+Math.random()*1000000);
               }
            });
        }
        dealWith(queue);
    }
    public static void dealWith(Queue<Request> queue){
        Request req = null;
        while((req=queue.poll())!=null){
            req.deposit();
        }
    }

}
interface Request{
    void deposit();
}
