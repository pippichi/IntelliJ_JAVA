package AirplaneGame1;
import java.awt.Graphics;
import java.awt.Image;

public class Explode {
    double x,y;
    int count=0;
    static Image[] images = new Image[6];
    static{
        for(int i=0;i<6;i++){
            images[i] = GameUtil.getImage("AirplaneGame1/Explode/e"+(i+1)+".png");
            images[i].getWidth(null);
        }
    }

    public void draw(Graphics g){
        if(count<=5){
            g.drawImage(images[count],(int)x,(int)y,null);
            count++;
        }
    }

    public Explode(double x,double y){
        this.x = x;
        this.y = y;
    }
}
