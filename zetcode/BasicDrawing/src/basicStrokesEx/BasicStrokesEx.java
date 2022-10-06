package basicStrokesEx;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {

    private void doDrawing(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        float[] kisaCizgi1 = {2f, 0f, 2f};
        float[] kisaCizgi2 = {1f, 1f, 1f};
        float[] kisaCizgi3 = {4f, 0f, 2f};
        float[] kisaCizgi4 = {4f, 4f, 1f};
        graphics.drawLine(20, 40, 250, 40);  // Düz çizgimiz.

        BasicStroke basicStroke1 = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, kisaCizgi1, 2f);

        graphics2D.setStroke(basicStroke1); // Düz çizgimizi kopyalıyoruz.
        graphics2D.drawLine(20, 80, 250, 80);

        BasicStroke basicStroke2 = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, kisaCizgi2, 2f);

        graphics2D.setStroke(basicStroke2);
        graphics2D.drawLine(20, 120, 250, 120);

        BasicStroke basicStroke3 = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, kisaCizgi3, 2f);

        graphics2D.setStroke(basicStroke3);
        graphics2D.drawLine(20, 160, 250, 160);

        BasicStroke basicStroke4 = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, kisaCizgi4, 2f);

        graphics2D.setStroke(basicStroke4);
        graphics2D.drawLine(20, 200, 250, 200);

    /*
        dispose() :
        - Bu grafik içeriğini atar ve kullandığı sistem kaynaklarını serbest bırakır.
        - Dispose çağrıldıktan sonra Graphics nesnesi kullanılamaz.
    */
        graphics2D.dispose();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class BasicStrokesEx extends JFrame {


    public BasicStrokesEx() {
        initUI();
    }

    public void initUI() {
        add(new Surface());
        setTitle("Temel Çizgiler");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BasicStrokesEx basicStrokesEx = new BasicStrokesEx();
    }
}
