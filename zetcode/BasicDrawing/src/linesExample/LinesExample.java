package linesExample;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel{

    private void doDrawing(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.drawLine(30, 30, 200, 30);
        graphics2D.drawLine(200, 30, 30, 200);
        graphics2D.drawLine(30, 200, 200, 200);
        graphics2D.drawLine(200, 200, 30, 30);
    }

    private void doDrawing2(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.YELLOW);
        graphics2D.fillOval(10, 10, 200, 200);
        // draw Eyes
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillOval(55, 65, 30, 30);
        graphics2D.fillOval(135, 65, 30, 30);
        // draw Mouth
        graphics2D.fillOval(50, 110, 120, 60);
        // adding smile
        graphics2D.setColor(Color.YELLOW);
        graphics2D.fillRect(50, 110, 120, 30);
        graphics2D.fillOval(50, 120, 120, 40);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        doDrawing2(g);
    }
}
public class LinesExample extends JFrame {  // JFrame :  Ana penceremiz

    public LinesExample(){
        initUI();
    }

    public void initUI(){
        add(new Surface());
        setTitle("Lines Examples ");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        LinesExample linesExample = new LinesExample();
        linesExample.setVisible(true);  // Ana pencereyi Görünür olarak ayarla
    }

}
