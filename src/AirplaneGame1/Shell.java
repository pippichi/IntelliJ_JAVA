package AirplaneGame1;
import java.awt.Graphics;
import java.awt.Color;

public class Shell extends GameObject{
    double degree;
    public Shell(){
        x = 100;
        y = 100;
        width = 20;
        height = 20;
        speed = 7;
        degree = 2*Math.PI*Math.random();
    }
    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int)x,(int)y,width,height);

        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);

        if(x<10||x>Constant.FRAME_WIDTH-width-10){
            degree = Math.PI - degree;
        }
        if(y<35||y>Constant.FRAME_HEIGHT-height-10){
            degree = -degree;
        }

        g.setColor(c);
    }
}
