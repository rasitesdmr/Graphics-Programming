package starEx;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

class Surface extends JPanel {

    private final double points[][] = {
            {0, 85}, {75, 75}, {100, 10}, {125, 75},
            {200, 85}, {150, 125}, {160, 190}, {100, 150},
            {40, 190}, {50, 125}, {0, 85}
    };

    public void doDrawing(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics.create();

        // Çizgilerimizin render kalitesini artırıyor
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        graphics2D.setPaint(Color.RED);
        graphics2D.translate(100, 25); // Yeni kordinat tanımlıyor . Bu kordinata göre yeri belirleniyor.

        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(points[0][0], points[0][1]);

        for (int k = 1; k < points.length; k++) {
            generalPath.lineTo(points[k][0], points[k][1]);
        }
        generalPath.closePath();
        graphics2D.fill(generalPath);
        graphics2D.dispose();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class StarEx extends JFrame {

    public StarEx() {
        initUI();
    }

    public void initUI() {
        add(new Surface());
        setTitle("Star");
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StarEx starEx = new StarEx();
            }
        });
    }
}
