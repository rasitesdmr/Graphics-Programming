package ozelBolum3;


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

    int copAdaminGozuX = 37;

    int ayakKordinatiArtirmaX = 1;

    int gercekKordinatX;


    int xKordinatArtirmaMiktari = 1;
    int delay = 10;
    Timer timer = new Timer(delay, this);


    public void copAdaminKafasi(Graphics graphics) {


        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.drawOval(copAdaminKafasiX, copAdaminKafasiY, 50, 50);


    }

    public void copAdaminGovdesi(Graphics graphics) {


        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.drawLine(copAdaminGovdesiX1, copAdaminGovdesiY1, copAdaminGovdesiX2, copAdaminGovdesiY2);

    }

    public void copAdaminKollari(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.drawLine(copAdaminKollari1X1, copAdaminKollari1Y1, copAdaminKollari1X2, copAdaminKollari1Y2);
        graphics2D.drawLine(copAdaminKollari2X1, copAdaminKollari2Y1, copAdaminKollari2X2, copAdaminKollari2Y2);


    }

    public void copAdaminAyaklari(Graphics graphics) {


        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.drawLine(copAdaminAyaklari1X1, copAdaminAyaklari1Y1, copAdaminAyaklari1X2, copAdaminAyaklari1Y2);
        graphics2D.drawLine(copAdaminAyaklari2X1, copAdaminAyaklari2Y1, copAdaminAyaklari2X2, copAdaminAyaklari2Y2);


    }

    public void copAdaminGozu(Graphics graphics) {


        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(renderingHints);

        graphics2D.fillOval(copAdaminGozuX,320,8,8);

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        copAdaminKafasi(g);
        copAdaminGovdesi(g);
        copAdaminAyaklari(g);
        copAdaminKollari(g);
        copAdaminGozu(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (copAdaminKafasiX == 534) {
            xKordinatArtirmaMiktari = 0;
        }

        copAdaminKafasiX += xKordinatArtirmaMiktari;
        gercekKordinatX = copAdaminKafasiX;
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
        copAdaminGozuX += xKordinatArtirmaMiktari;

        if (0 <= gercekKordinatX && gercekKordinatX <= 50) {
            copAdaminKollari1X2 +=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 -= ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 += ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 -= ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 50) {
                System.out.println("1.Adım -) 0 ile 50 kordinatları arasında ");
            }

        }

        if (50 < gercekKordinatX && gercekKordinatX <= 100) {

            copAdaminKollari1X2 -=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 += ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 -= ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 += ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 100) {
                System.out.println("2.Adım -) 50 ile 100 kordinatları arasında ");
            }
        }

        if (100 < gercekKordinatX && gercekKordinatX <= 150) {
            copAdaminKollari1X2 +=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 -= ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 += ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 -= ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 150) {
                System.out.println("3.Adım -) 100 ile 150 kordinatları arasında ");
            }

        }

        if (150 < gercekKordinatX && gercekKordinatX <= 200) {

            copAdaminKollari1X2 -=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 += ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 -= ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 += ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 200) {
                System.out.println("4.Adım -) 150 ile 200 kordinatları arasında ");
            }
        }
        if (200 < gercekKordinatX && gercekKordinatX <= 250) {

            copAdaminKollari1X2 +=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 -= ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 += ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 -= ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 250) {
                System.out.println("5.Adım -) 200 ile 250 kordinatları arasında ");
            }

        }
        if (250 < gercekKordinatX && gercekKordinatX <= 300) {
            copAdaminKollari1X2 -=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 += ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 -= ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 += ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 300) {
                System.out.println("6.Adım -) 250 ile 300 kordinatları arasında ");
            }
        }
        if (300 < gercekKordinatX && gercekKordinatX <= 350) {

            copAdaminKollari1X2 +=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 -= ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 += ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 -= ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 350) {
                System.out.println("7.Adım -) 250 ile 300 kordinatları arasında ");
            }

        }
        if (350 < gercekKordinatX && gercekKordinatX <= 400) {
            copAdaminKollari1X2 -=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 += ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 -= ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 += ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 400) {
                System.out.println("8.Adım -) 350 ile 400 kordinatları arasında ");
            }
        }
        if (400 < gercekKordinatX && gercekKordinatX <= 450) {

            copAdaminKollari1X2 +=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 -= ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 += ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 -= ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 450) {
                System.out.println("9.Adım -) 400 ile 450 kordinatları arasında ");
            }

        }
        if (450 < gercekKordinatX && gercekKordinatX <= 500) {

            copAdaminKollari1X2 -=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 += ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 -= ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 += ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 500) {
                System.out.println("10.Adım -) 450 ile 500 kordinatları arasında ");
            }
        }
        if (500 < gercekKordinatX && gercekKordinatX <= 530) {
            copAdaminKollari1X2 +=ayakKordinatiArtirmaX;
            copAdaminKollari2X2 -= ayakKordinatiArtirmaX;

            copAdaminAyaklari1X2 += ayakKordinatiArtirmaX;
            copAdaminAyaklari2X2 -= ayakKordinatiArtirmaX;
            gercekKordinatX++;

            if (gercekKordinatX == 530) {
                System.out.println("11.Adım -) 500 ile 530 kordinatları arasında ");


            }

        }

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
        setSize(600, 600);
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

