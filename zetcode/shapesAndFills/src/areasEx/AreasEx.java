package areasEx;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

class Surface extends JPanel {

    public void doDrawing(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        renderingHints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        graphics2D.setRenderingHints(renderingHints);
        graphics2D.setPaint(Color.MAGENTA);

        Area area1 = new Area(new Rectangle2D.Double(20, 20, 100, 100));
        Area area2 = new Area(new Ellipse2D.Double(50, 50, 100, 100));

        area1.subtract(area2); // Belirtilen Alanın şeklini bu Alanın şeklinden çıkarır.
        graphics2D.fill(area1);

        Area area3 = new Area(new Rectangle2D.Double(150, 20, 100, 100));
        Area area4 = new Area(new Ellipse2D.Double(150, 20, 100, 100));

        graphics2D.setColor(Color.GREEN);
        area3.subtract(area4);
        graphics2D.fill(area3);

        Area area5 = new Area(new Rectangle2D.Double(280, 20, 100, 100));
        Area area6 = new Area(new Ellipse2D.Double(320, 40, 100, 100));

        graphics2D.setColor(Color.BLACK);
        area5.add(area6);
        graphics2D.fill(area5);

        Area area7 = new Area(new Rectangle2D.Double(150, 200, 200, 200));
        Area area8 = new Area(new Ellipse2D.Double(50, 300, 200, 200));
        Area area9 = new Area(new Ellipse2D.Double(100, 150, 100, 100));

        graphics2D.setColor(Color.CYAN);
        area7.subtract(area8);
        area7.add(area9);
        graphics2D.fill(area7);
        graphics2D.setColor(Color.RED);
        graphics2D.fill(area9);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}


public class AreasEx extends JFrame {

    public AreasEx() {
        initUI();
    }

    public void initUI() {
        add(new Surface());
        setTitle("Area");
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AreasEx areasEx = new AreasEx();
            }
        });
    }
}
