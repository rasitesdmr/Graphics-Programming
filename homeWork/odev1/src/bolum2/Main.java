package bolum2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

class TurkBayragi extends JPanel {

    private double height;
    private double width;
    private double uckurlukGenisligi;

    public void arkaPLan(Graphics graphics) {

        height = getHeight();
        width = getWidth();
        uckurlukGenisligi = height / 30;

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        renderingHints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        graphics2D.setRenderingHints(renderingHints);
        setBackground(Color.RED);

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, (int) uckurlukGenisligi, (int) height);
    }

    public void ay(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        renderingHints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        graphics2D.setRenderingHints(renderingHints);
        graphics2D.setColor(Color.WHITE);
        Area area1 = new Area(new Ellipse2D.Double((height * 0.25) + uckurlukGenisligi, height * 0.25, height * 0.50, height * 0.50));
        graphics2D.fill(area1);

        Area area2 = new Area(new Ellipse2D.Double((height*0.5)+(height/16)+uckurlukGenisligi-(height*0.2),height*0.3,height*0.4,height*0.4));
        graphics2D.setColor(Color.RED);
        graphics2D.fill(area2);
    }

    public void yildiz(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        renderingHints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.setColor(Color.WHITE);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        arkaPLan(g);
        ay(g);
    }
}

public class Main extends JFrame {

    public Main() {
        initUI();
    }


    public void initUI() {

        double height = 600;
        double width = 1.5 * height;

        add(new TurkBayragi());
        setTitle("Türk Bayrağı");
        setSize((int) width, (int) height);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });
    }
}
