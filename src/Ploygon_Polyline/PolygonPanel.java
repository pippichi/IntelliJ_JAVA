package Ploygon_Polyline;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
public class PolygonPanel extends JPanel {
    private int[] x = {20,30,40,50,60};
    private int[] y = {50,30,40,20,10};
    public PolygonPanel(){}
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawPolyline(x,y,x.length);//Polygon或者Polyline

    }
    public Dimension setPreferredSize(){
        return new Dimension(200,200);
    }
}
