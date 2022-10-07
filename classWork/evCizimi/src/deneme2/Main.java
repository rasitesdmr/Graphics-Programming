package deneme2;

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

        // Ev zemin
        graphics2D.drawRect(100,200,300,300);

        // Sol pencere
        graphics2D.drawRect(150,250,50,50);

        // Sağ pencere
        graphics2D.drawRect(300,250,50,50);

        //Kapı
        graphics2D.drawRect(200,400,100,100);

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

        setTitle("Ev 2");
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