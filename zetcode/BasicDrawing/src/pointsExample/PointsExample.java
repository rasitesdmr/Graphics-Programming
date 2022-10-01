package pointsExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/*
    - Düğmeye veya menü öğesine her tıkladığınızda Java ActionListener bildirilir.
    - ActionEvent'e karşı bildirim yapılır.
    - ActionListener arabirimi, java.awt.event paketinde bulunur.
    - Yalnızca bir yöntemi vardır: actionPerformed().
*/

class Surface extends JPanel implements ActionListener {

    private final int DELAY = 150;
    private Timer timer;

    public Surface() {
        initTimer();
    }

    public void initTimer() {
        timer = new Timer(DELAY, this);   // DELAY milisaniye
        timer.start();
    }

    public Timer getTimer(){
        return timer;
    }

    private void doDrawing(Graphics graphics) {  // Alt pencere tanımlıyorum

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setPaint(Color.RED);   // Oluşacak nesnenin rengini belirtiyorum

        int width = getWidth();     // int tipinde genişlik alıyorum
        int height = getHeight();   // int tipinde yükseklik alıyorum;

        Random random = new Random();   // Random nesnesini oluşturuyorum

        for (int i = 0; i < 1000; i++) {
            int x = Math.abs(random.nextInt()) % width;  // Math.abs() : Bir sayının mutlak değerini almak için kullanılır.
            int y = Math.abs(random.nextInt()) % height;
            graphics2D.drawLine(x, y, x, y);  // birinci x,y kordinatını ve ikinci x,y kordinatı arasına çizgi ciziyor.
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


public class PointsExample extends JFrame {  // JFrame : En dış pencere

    public PointsExample() {
        initUI();
    }

    private void initUI() {
        Surface surface = new Surface();
        add(surface);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               Timer timer = surface.getTimer();
               timer.stop();
            }
        });
        setTitle("Points");  // Bir başlık belirtiyoruz : Points
        setSize(500, 500);  // Genişlik : 500 , Yükseklik : 500 belirliyoruz.
        setLocationRelativeTo(null);   // İstersek istediğiz konumda çalıştırabiliriz : null
        // setLocation();   Konum belirliyebiliyoruz
        setDefaultCloseOperation(EXIT_ON_CLOSE); // En dış pencereyi kapatmak için kullanıyoruz.
    }


    public static void main(String[] args) {

        PointsExample pointsExample = new PointsExample();
        pointsExample.setVisible(true);
    }

}

