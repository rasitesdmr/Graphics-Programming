package capsEx;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {

    public void doDrawing(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics.create();  // Bu Graphics nesnesinin bir kopyası olan yeni bir Graphics nesnesi oluşturur.

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        BasicStroke basicStroke1 = new BasicStroke(8,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
        graphics2D.setStroke(basicStroke1);
        graphics2D.drawLine(100,100,500,100);

        BasicStroke basicStroke2 = new BasicStroke(8,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
        graphics2D.setStroke(basicStroke2);
        graphics2D.drawLine(100,200,500,200);

        BasicStroke basicStroke3 = new BasicStroke(8,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL);
        graphics2D.setStroke(basicStroke3);

        graphics2D.drawLine(100,300,500,300);

        BasicStroke basicStroke4 = new BasicStroke();
        graphics2D.setStroke(basicStroke4);
        graphics2D.drawLine(100,90,100,310);

        graphics2D.drawLine(500,90,500,310);

        graphics2D.drawLine(503,90,503,310);



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class CapsEx extends JFrame {

    public CapsEx() {
        initUI();
    }

    public void initUI() {
        add(new Surface());
        setTitle("Caps");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CapsEx capsEx = new CapsEx();
            }
        });

    }
}
