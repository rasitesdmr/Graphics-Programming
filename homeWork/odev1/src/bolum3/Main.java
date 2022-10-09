package bolum3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.TimerTask;

class CopAdam extends JPanel implements ActionListener{

    private final int DELAY = 1500;
    private Timer timer;

    public CopAdam() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Timer getTimer() {

        return timer;
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
        }
    };

    public void doDrawing(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.RED);
        Area area = new Area(new Ellipse2D.Double(20, 20, 30, 30));
        graphics2D.fill(area);
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
        CopAdam copAdam = new CopAdam();
        add(copAdam);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = copAdam.getTimer();
                timer.stop();
            }
        });
        setTitle("Çöp Adam");
        setSize(400, 400);
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
