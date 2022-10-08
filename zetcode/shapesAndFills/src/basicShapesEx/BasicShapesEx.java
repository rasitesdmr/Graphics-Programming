package basicShapesEx;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class Surface extends JPanel{

    public void doDrawing(Graphics graphics){

        Graphics2D graphics2D  = (Graphics2D) graphics;

        graphics2D.setPaint(Color.RED);

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.fillRect(30,20,50,50);
        graphics2D.fillRect(120,20,90,60);
        graphics2D.fillRoundRect(250,20,70,60,25,25);
        graphics2D.fill(new Ellipse2D.Double(10,100,80,100));
        graphics2D.fillArc(120, 130, 110, 100, 360, 270);
        graphics2D.fillOval(270,130,50,50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}


public class BasicShapesEx extends JFrame {

    public BasicShapesEx(){
        initUI();
    }

    public void initUI(){
        add(new Surface());
        setTitle("Basic Shapes");
        setSize(600,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BasicShapesEx basicShapesEx = new BasicShapesEx();
            }
        });
    }
}
