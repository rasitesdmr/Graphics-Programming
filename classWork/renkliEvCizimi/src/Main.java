import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

class Surface extends JPanel {
    private final double[][] points = {
            {50, 50}, {100, 0}, {150, 50}
    };

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setPaint(Color.BLUE);



        GeneralPath star = new GeneralPath();

        star.moveTo(points[0][0], points[0][1]);

        for (int k = 1; k < points.length; k++)
            star.lineTo(points[k][0], points[k][1]);

        star.closePath();
        g2d.fill(star);


        Area a1 = new Area(new Rectangle2D.Double(50, 50, 100, 100));
        Area a2 = new Area(new Rectangle2D.Double(68, 70, 20, 20));
        Area a3 = new Area(new Rectangle2D.Double(110, 70, 20, 20));
        Area a4 = new Area(new Rectangle2D.Double(110, 0, 20, 40));

        a1.subtract(a2);
        a1.subtract(a3);
        g2d.setPaint(Color.RED);
        g2d.fill(a1);
        g2d.setPaint(Color.BLACK);
        g2d.fill(a4);


        g2d.dispose();

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

    }
}

public class Main extends JFrame {

    public Main() {
        initUI();
    }

    public void initUI() {
        add(new Surface());
        setTitle("Lines Examples ");
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}

