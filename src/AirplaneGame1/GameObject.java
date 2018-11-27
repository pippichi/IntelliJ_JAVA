package AirplaneGame1;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Graphics;

public class GameObject{
    Image image;
    int width,height;
    double x,y;
    double speed;


    public void drawSelf(Graphics g){
        g.drawImage(image,(int)x,(int)y,null);
    }

    public GameObject(){}
    public GameObject(Image image,double x,double y){
        super();
        this.image = image;
        this.x = x;
        this.y = y;
    }
    public GameObject(Image image,double x,double y,double speed,int width,int height){
        super();
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }public GameObject(Image image,double speed,int width,int height){
        super();
        this.image = image;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    /**
     * 返回物体所在矩形，便于后期碰撞检测
     * @getRect
     */
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
