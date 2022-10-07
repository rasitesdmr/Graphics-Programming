package deneme1;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Ev extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;

        // Evin çatısı
        graphics2D.drawLine(100,200,250,50);
        graphics2D.drawLine(400,200,250,50);

        // Evin zemini
        graphics2D.drawLine(100,200,400,200);
        graphics2D.drawLine(100,200,100,500);
        graphics2D.drawLine(100,500,400,500);
        graphics2D.drawLine(400,500,400,200);

        // Sol pencere
        graphics2D.drawLine(150,250,200,250);
        graphics2D.drawLine(150,250,150,300);
        graphics2D.drawLine(150,300,200,300);
        graphics2D.drawLine(200,300,200,250);

        // Sağ pencere
        graphics2D.drawLine(300,250,350,250);
        graphics2D.drawLine(300,250,300,300);
        graphics2D.drawLine(300,300,350,300);
        graphics2D.drawLine(350,300,350,250);

        // Kapı
        graphics2D.drawLine(200,500,200,400);
        graphics2D.drawLine(200,400,300,400);
        graphics2D.drawLine(300,400,300,500);

        // Kapı kolu
        graphics2D.drawLine(200,450,230,450);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Main extends JFrame {

    public Main() {

        initUI();
    }

    private void initUI() {

        add(new Ev());

        setTitle("Ev 1");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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