package joinsEx;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {

    public void doDrawing(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        BasicStroke basicStroke1 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        graphics2D.setStroke(basicStroke1);
        graphics2D.drawRect(100, 100, 80, 50);

        BasicStroke basicStroke2 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        graphics2D.setStroke(basicStroke2);
        graphics2D.drawRect(100, 200, 80, 50);

        BasicStroke basicStroke3 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        graphics2D.setStroke(basicStroke3);
        graphics2D.drawRect(100, 300, 80, 50);


        graphics2D.dispose();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class JoinsEx extends JFrame {

    public JoinsEx() {
        initUI();
    }

    public void initUI() {
        add(new Surface());
        setTitle("Joins");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JoinsEx joinsEx = new JoinsEx();
            }
        });
    }
}
