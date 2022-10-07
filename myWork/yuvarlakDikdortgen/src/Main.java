import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;


class Surface extends JPanel {

    final static float[] dash1 = {1.0f};
    final static float[] dash2 = {10.0f};

    public void doDrawing(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        BasicStroke basicStroke1 = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dash1, 0.0f);
        graphics2D.setStroke(basicStroke1);
        graphics2D.draw(new RoundRectangle2D.Double(100, 100, 100, 50, 10, 10));

        BasicStroke basicStroke2 = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10.0f, dash2, 0.0f);
        graphics2D.setStroke(basicStroke2);
        graphics2D.draw(new RoundRectangle2D.Double(100, 200, 100, 50, 10, 10));



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
        setTitle("Şekiller");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
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