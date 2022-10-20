package odev2_3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Surface extends JPanel {
    int xEkseniKareSayisi = 10;
    int yEkseniKareSayisi = 8;

    float[] dash4 = {4f, 4f, 1f}; // Cizgi deseni

    public void doDrawing(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        int weight = getWidth();

        int height = getHeight();

        BasicStroke bs4 = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);

        for (int i = 0; i < xEkseniKareSayisi; i++) {

            float alpha = (i + 1) * 0.1f; // ya saydam ya opak (0,1)

            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);

            graphics2D.setComposite(alcom);  // işliyorum

            for (int j = 0; j < yEkseniKareSayisi; j++) {

                Random random = new Random();

                graphics2D.setStroke(bs4);
                graphics2D.setPaint(Color.BLACK);
                graphics2D.drawRect(i * (weight / xEkseniKareSayisi), j * (height / yEkseniKareSayisi), weight / xEkseniKareSayisi, height / yEkseniKareSayisi);

                Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                graphics2D.setColor(color);
                graphics2D.fillRect(i * (weight / xEkseniKareSayisi), j * (height / yEkseniKareSayisi), weight / xEkseniKareSayisi, height / yEkseniKareSayisi);
            }
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
