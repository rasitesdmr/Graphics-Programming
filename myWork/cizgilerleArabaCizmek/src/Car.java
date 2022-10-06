import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {

    private void doDrawing(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.drawLine(200,50,400,50);
        graphics2D.drawLine(200,50,100,100);
        graphics2D.drawLine(400,50,300,100);
        graphics2D.drawLine(100,100,300,100);

        graphics2D.drawLine(200,50,100,70);
        graphics2D.drawLine(100,100,80,120);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Car extends JFrame {

    public Car() {
        initUI();
    }

    public void initUI() {
        add(new Surface());
        setTitle("Araba Penceresi");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Car car = new Car();
    }
}
