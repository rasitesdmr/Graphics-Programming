package odev2_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Surface extends JPanel implements ActionListener {

    public Surface() {
        initTimer();
    }

    int xEkseniKareSayisi = 10;

    int yEkseniKareSayisi = 8;

    private Timer timer;
    private final int DELAY = 5000;

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void doShapeDrawing(Graphics graphics) { // şekiller oluşur

        Graphics2D graphics2D = (Graphics2D) graphics;

        int weight = getWidth();

        int height = getHeight();

        for (int i = 0; i < xEkseniKareSayisi; i++) {

            for (int j = 0; j < yEkseniKareSayisi; j++) {
                Random random = new Random();

                Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                graphics2D.setColor(color);

                graphics2D.fillRect(i * (weight / xEkseniKareSayisi), j * (height / yEkseniKareSayisi), weight / xEkseniKareSayisi, height / yEkseniKareSayisi);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) { // Boyama işlemi geldiğinde çağrılır. cizdiriyoruz.
        super.paintComponent(g);
        doShapeDrawing(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

