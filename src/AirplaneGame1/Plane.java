package AirplaneGame1;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    private boolean up,right,left,down;
    private boolean live = true;

    public Plane(){}
    public Plane(Image image,double x,double y,double speed){
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }
    public Plane(Image image,double x,double y){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }
    public void setLive(boolean live){
        this.live = live;
    }

    public boolean getLive(){return live;}

    public void drawSelf(Graphics g){
        if(live) {
            g.drawImage(image, (int) x, (int) y, 50, 50, null);
            if (up) {
                y -= speed;
            }
            if (down) {
                y += speed;
            }
            if (right) {
                x += speed;
            }
            if (left) {
                x -= speed;
            }
        }
    }
    public void addDirection(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
    }
    public void minusDirection(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
    }

}
