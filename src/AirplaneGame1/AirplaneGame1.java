package AirplaneGame1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.awt.Font;
import java.awt.Color;

public class AirplaneGame1 extends Frame{

    Image plane1 = GameUtil.getImage("AirplaneGame1/images/plane.png");
    Image bg = GameUtil.getImage("AirplaneGame1/images/bg1_0.jpg");
    Explode explode;

    Plane planePlayer1 = new Plane(plane1,150,600,0.3);
    Shell[] shells = new Shell[50];
    Date startTime = new Date();
    Date stopTime;

    private int period;//计算玩的时间

    public void launchFrame(){
        this.setSize(Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("AirplaneGame");

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        new PaintThread().start();//启动重画窗口的线程
        addKeyListener(new KeyMonitor());

        for(int i=0;i<shells.length;i++){
            shells[i] = new Shell();
        }
    }
    public Dimension setPreferredSize(){
        return new Dimension(500,500);
    }

    //以下为多线程
    class PaintThread extends Thread{
        @Override
        public void run() {
            while(true){
                repaint();
                try{
                    Thread.sleep(40);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
        Font f = g.getFont();
        Color c = g.getColor();
        for(int i=0;i<shells.length;i++) {
            shells[i].draw(g);
            planePlayer1.drawSelf(g);
            boolean isIntersect = shells[i].getRect().intersects(planePlayer1.getRect());
            if (isIntersect) {

                planePlayer1.setLive(false);
                if (explode == null) {
                    explode = new Explode(planePlayer1.x, planePlayer1.y);
                    stopTime = new Date();
                    period = (int) (stopTime.getTime() - startTime.getTime()) / 1000;
                    explode.draw(g);
                }
            }
        }
        if(!planePlayer1.getLive()){
            g.setFont(new Font("幼圆",Font.BOLD,50));
            g.setColor(Color.red);
            g.drawString("时间："+period,(int)planePlayer1.x,(int)planePlayer1.y);
        }
        g.setColor(c);
        g.setFont(f);
    }
    class KeyMonitor extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            planePlayer1.addDirection(e);
        }
        public void keyReleased(KeyEvent e){
            planePlayer1.minusDirection(e);
        }
    }

    public static void main(String[] args){
        AirplaneGame1 frame = new AirplaneGame1();
        frame.launchFrame();
    }

    /**
     * 解决Frame的闪烁问题
     */
    private Image offScreenImage = null;
    public void update(Graphics g){
        if(offScreenImage==null)
            offScreenImage = createImage(Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);//游戏窗口大小
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }
}
