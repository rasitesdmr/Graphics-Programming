package transparentRectanglesEx;

import javax.swing.*;
import java.awt.*;


class Surface extends JPanel  {

    public void doDrawing(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setPaint(Color.RED);

        for (int i = 1; i < 10; i++) {

            float alpha = i * 0.1f;
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            graphics2D.setComposite(alphaComposite);
            graphics2D.fillRect(i * 50, 20, 40, 40);

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

}

public class TransparentRectanglesEx extends JFrame {

    public TransparentRectanglesEx() {
        init();
    }

    public void init() {
        add(new Surface());
        setTitle("Şeffaf Nesne");
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TransparentRectanglesEx transparentRectanglesEx = new TransparentRectanglesEx();
    }
}
