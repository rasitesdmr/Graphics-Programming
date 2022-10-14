package bolum2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

class TurkBayragi extends JPanel {

    private double A;                   // Dış ay merkezinin uçkurluktan mesafesi : (1/2 G)
    private double B;                  // Ayın dış dairesinin çapı : (1/2 G)
    private double C;                  // Ayın iç ve dış merkezleri arası : (1/16 G)
    private double D;                  // Ayın iç dairesinin çapı : (0.4 G)
    private double G = getHeight();    // Genişlik
    private double L = getWidth();     // Boy : (1.5 G)
    private double M;                  // Uçkurluk genişliği  (1/30 G)

    public void arkaPLan(Graphics graphics) {

        G = getHeight();
        L = getWidth();
        M = G / 30;

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        renderingHints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        graphics2D.setRenderingHints(renderingHints);
        setBackground(Color.RED);

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, (int) M, (int) G);
    }

    public void ay(Graphics graphics) {

        A = G / 2;
        C = G / 16;
        B = G / 2;
        D = 0.4 * G;

        Graphics2D graphics2D = (Graphics2D) graphics;

        // Dış Daire
        graphics2D.setColor(Color.WHITE);
        Area area1 = new Area(new Ellipse2D.Double((A-(B/2)) + M, G / 4, B, B));
        graphics2D.fill(area1);

        // İç Daire
        Area area2 = new Area(new Ellipse2D.Double(A + C + M - (D / 2), G * 0.3, D, D));
        graphics2D.setColor(Color.RED);
        graphics2D.fill(area2);
    }


    public void yildiz(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;


        int[] yildizx = new int[10];
        int[] yildizy = new int[10];

        int aci = 36;
        int disaci = (360 / 5);
        int icaci = (disaci / 2);
        int merkezx = (int) ((int) M + (G / 2) + (G / 16) + (G / 3) + (G / 8) - (G * 0.2));
        int merkezy = (int) (G * 0.5);
        int discember = (int) (G * 1 / 8);
        int iccember = (int) (G * 1 / 20);

        for (int i = 0; i < yildizx.length; i += 2) {
            yildizx[i] = (merkezx + (int) (discember * Math.cos(Math.PI * aci / 180)));
            yildizx[i + 1] = (merkezx + (int) (iccember * Math.cos(Math.PI * (aci + icaci) / 180)));
            yildizy[i] = (merkezy + (int) (discember * Math.sin(Math.PI * aci / 180)));
            yildizy[i + 1] = (merkezy + (int) (iccember * Math.sin(Math.PI * (aci + icaci) / 180)));
            aci += disaci;
        }
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillPolygon(yildizx, yildizy, yildizx.length);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        arkaPLan(g);
        ay(g);
        yildiz(g);

    }
}

public class Main extends JFrame {

    public Main() {
        initUI();
    }


    public void initUI() {

        double height = 400;   // G == height
        double width = 1.5 * height;

        add(new TurkBayragi());
        setTitle("Türk Bayrağı");
        setSize((int) width, (int) height);
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
