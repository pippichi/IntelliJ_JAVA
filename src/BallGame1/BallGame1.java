package BallGame1;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BallGame1 extends JFrame{
    Image ball = Toolkit.getDefaultToolkit().getImage("resource/ball.png");
    ImageIcon desk = new ImageIcon("resource/desk.jpg");
    private double xCoord = 100;
    private double yCoord = 100;
    private double degree = Math.PI/3;
    public BallGame1(){
        JLabel panel = new JLabel();
        panel.setIcon(desk);
        add(panel);
    }

    void launchFrame(){
        setTitle("BallGame1");
        setLocation(50,50);
        setSize(856,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        while(true){
            repaint();
            try{
                Thread.sleep(20);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void paint(Graphics g){
        super.paintComponents(g);
        //g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int) xCoord,(int) yCoord,null);

        xCoord = xCoord + 10 * Math.cos(degree);
        yCoord = yCoord + 10 * Math.sin(degree);
        if(xCoord<40||xCoord>(856-40-30)){
            degree = 3.14-degree;
        }
        if(yCoord<(40+40)||yCoord>(500-40-30)){
            degree = -degree;
        }
    }
    public static void main(String[] args){
        BallGame1 frame = new BallGame1();
        frame.launchFrame();
    }
}
