package bolum1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

class RastgeleCizgiler extends JPanel implements ActionListener {

    private final int DELAY = 1500;
    private Timer timer;

    public RastgeleCizgiler() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Timer getTimer() {

        return timer;
    }

    public void doDrawing(Graphics graphics) {
        double width = getWidth();
        double height = getHeight();

        Graphics2D graphics2D = (Graphics2D) graphics;

        Random random = new Random();

        float x = Math.abs(random.nextFloat());
        float y = Math.abs(random.nextFloat());
        float z = Math.abs(random.nextFloat());


        for (int i = 0; i < 5; i++) {

            float k = Math.abs(random.nextFloat() * 100);
            float[] dash1 = {x, y, z};

            BasicStroke bs1 = new BasicStroke(k, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 1.0f, dash1, 1.0f);
            graphics2D.setColor(Color.GREEN);
            graphics2D.setStroke(bs1);

            int x1 = (int) (Math.abs(random.nextInt()) % width);
            int y1 = (int) (Math.abs(random.nextInt()) % height);
            int x2 = (int) (Math.abs(random.nextInt()) % width);
            int y2 = (int) (Math.abs(random.nextInt()) % height);

            graphics2D.drawLine(x1, y1, x2, y2);

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class Main extends JFrame {

    public Main() {
        initUI();
    }

    public void initUI() {
        RastgeleCizgiler rastgeleCizgiler = new RastgeleCizgiler();
        add(rastgeleCizgiler);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = rastgeleCizgiler.getTimer();
                timer.stop();
            }
        });


        double height = 600;
        double width = 600;

        setTitle("Rastgele Çizgiler");
        setSize((int) width, (int) height);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        Main main = new Main();
    }
}
