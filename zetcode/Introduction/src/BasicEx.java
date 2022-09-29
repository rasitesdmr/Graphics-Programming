import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {

    private void doDrawing(Graphics2D graphics2D){
        graphics2D.drawString("Java 2D",300,50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing((Graphics2D) g);
    }
}

/*
    JFrame :
    - Bir GUI oluşturmak için etiketler, düğmeler, metin alanları gibi bileşenlerin eklendiği
      ana pencere gibi çalışır.
    - Daha basit anlatımı JFrame bir defter olarak düşenelim , JPanel ise defterin herhangi bir sayfası olarak
      düşünebiliriz.
    - BasicEx extends ederek JFrame'in özelliklerini kazanıyor. Bu sınıfa yazdığımız metotlar bizim ana çerçevemizi
      özelleştirmemizi sağlıyor. Yani defterimizi özelleştiriyoruz diyebiliriz.
    JPanel :
    - JFrame ana penceresinin içine oluşturduğumuz bir çerçevedir.
    - Yani sayfamızdır.
    - Surface extends ederek JPanel'in özelliklerini kazanır. Bu sınıfa yazdığımız metotlar bizim sayfamızı
      özelleştirmemize olanak sağlar.
 */

public class BasicEx extends JFrame {

    public BasicEx() {              // Parametresiz bir Constructor(Yapıcı) oluşturuyoruz.
        initUI();
    }

    private void initUI() {         // Başlangıç kullanıcı arayüzünü özelleştiriyoruz.

        add(new Surface());          // Ana penceremizin içerisine sayfa ekleyecek.
        setTitle("Simple Java 2D example"); // Ana penceremize başlık ekliyoruz.
        setSize(500, 500);   // Genişlik : 500 , Yükseklik : 500 olsun diyoruz.
        setLocationRelativeTo(null);     // Konuma göre ayarla null yapıyoruz.
        // setLocation(60,60);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ana pencereyi kapatmak için kullanıyoruz.
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {   // Öncelik tanımlamak

            @Override
            public void run() {
                BasicEx basicEx = new BasicEx();
                basicEx.setVisible(true);  // Pencereyi görünür yap.
            }
        });
    }

}