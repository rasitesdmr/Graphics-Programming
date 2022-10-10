package bolum3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class CopAdam extends JPanel implements ActionListener {
    int copAdaminKafasiX = 0;
    int copAdaminKafasiY = 300;
    int copAdaminGovdesiX1 = 25;
    int copAdaminGovdesiY1 = 350;
    int copAdaminGovdesiX2 = 25;
    int copAdaminGovdesiY2 = 400;
    int copAdaminAyaklari1X1 = 25;
    int copAdaminAyaklari1Y1 = 400;
    int copAdaminAyaklari1X2 = 0;
    int copAdaminAyaklari1Y2 = 450;
    int copAdaminAyaklari2X1 = 25;
    int copAdaminAyaklari2Y1 = 400;
    int copAdaminAyaklari2X2 = 50;
    int copAdaminAyaklari2Y2 = 450;
    int copAdaminKollari1X1 = 25;
    int copAdaminKollari1Y1 = 350;
    int copAdaminKollari1X2 = 0;
    int copAdaminKollari1Y2 = 400;
    int copAdaminKollari2X1 = 25;
    int copAdaminKollari2Y1 = 350;
    int copAdaminKollari2X2 = 50;
    int copAdaminKollari2Y2 = 400;

    int ayakKordinatiArtirmaX = 1;


    int xKordinatArtirmaMiktari = 1;
    int delay = 100;
    Timer timer = new Timer(delay, this);


    public void copAdaminKafasi(Graphics graphics) {


        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.drawOval(copAdaminKafasiX, copAdaminKafasiY, 50, 50);

        timer.start();

    }

    public void copAdaminGovdesi(Graphics graphics) {


        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.drawLine(copAdaminGovdesiX1, copAdaminGovdesiY1, copAdaminGovdesiX2, copAdaminGovdesiY2);

        timer.start();
    }

    public void copAdaminKollari(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.drawLine(copAdaminKollari1X1, copAdaminKollari1Y1, copAdaminKollari1X2, copAdaminKollari1Y2);
        graphics2D.drawLine(copAdaminKollari2X1, copAdaminKollari2Y1, copAdaminKollari2X2, copAdaminKollari2Y2);

        timer.start();
    }

    public void copAdaminAyaklari(Graphics graphics) {


        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.drawLine(copAdaminAyaklari1X1, copAdaminAyaklari1Y1, copAdaminAyaklari1X2, copAdaminAyaklari1Y2);
        graphics2D.drawLine(copAdaminAyaklari2X1, copAdaminAyaklari2Y1, copAdaminAyaklari2X2, copAdaminAyaklari2Y2);

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        copAdaminKafasi(g);
        copAdaminGovdesi(g);
        copAdaminAyaklari(g);
        copAdaminKollari(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (copAdaminKafasiX == 836) {
            xKordinatArtirmaMiktari = 0;
        }

        copAdaminKafasiX += xKordinatArtirmaMiktari;
        copAdaminGovdesiX1 += xKordinatArtirmaMiktari;
        copAdaminGovdesiX2 += xKordinatArtirmaMiktari;
        copAdaminKollari1X1 += xKordinatArtirmaMiktari;
        copAdaminKollari1X2 += xKordinatArtirmaMiktari;
        copAdaminKollari2X1 += xKordinatArtirmaMiktari;
        copAdaminKollari2X2 += xKordinatArtirmaMiktari;
        copAdaminAyaklari1X1 += xKordinatArtirmaMiktari;
        copAdaminAyaklari1X2 += xKordinatArtirmaMiktari;
        copAdaminAyaklari2X1 += xKordinatArtirmaMiktari;
        copAdaminAyaklari2X2 += xKordinatArtirmaMiktari;

        copAdaminAyaklari1X2 += ayakKordinatiArtirmaX;
        copAdaminAyaklari2X2 -= ayakKordinatiArtirmaX;



        repaint();

    }

}


public class Main extends JFrame {

    public Main() {
        initUI();
    }

    public void initUI() {
        add(new CopAdam());
        setTitle("HAREKET EDEN ÇÖP ADAM");
        setSize(900, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        //  setResizable(false); // boyutlandırmayı kapatıyor
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
