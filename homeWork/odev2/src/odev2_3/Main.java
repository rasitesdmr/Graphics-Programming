package odev2_3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Main extends JFrame {

    int weightMin = 400;
    int weightMax = 800;
    int heightMin = 200;
    int heightMax = 720;


    public Main() {
        initUI();
    }


    public void initUI() {

        Random random = new Random();
        int weight = random.nextInt((weightMax - weightMin) + 1) + weightMin; // 0 399 arası +1
        int height = random.nextInt((heightMax - heightMin) + 1) + heightMin;

        add(new Surface());
        setTitle("En Dış Pencere");
        setBounds(0, 0, weight, height); // konumu ve boyutu manuel olarak ayarlar.
        setVisible(true);
        setLocationRelativeTo(null);
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
