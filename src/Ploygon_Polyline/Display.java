package Ploygon_Polyline;
import javax.swing.JFrame;
public class Display extends JFrame{
    public Display(){
        PolygonPanel polygonPanel = new PolygonPanel();
        polygonPanel.setPreferredSize();
        add(polygonPanel);
    }
    public static void main(String[] args){
        Display frame = new Display();
        frame.setTitle("PolygonPanel");
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
