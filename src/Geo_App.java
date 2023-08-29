import javax.swing.*;
import java.awt.*;

public class Geo_App extends JFrame {
    private Container c;
    private JButton triangle, circle,rectangle;
    JLabel Label;
    private Font f,f1;
    private JTextField tf;
    private JTextArea ta;
    private BorderLayout bl;

    Geo_App()
    {

        initComponents();
    }

    public void initComponents() {
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Home Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f = new Font("Arial", Font.BOLD, 30);
    }
    public static void main(String[] args) {
        Geo_App Demo=new Geo_App();
        Demo.setVisible(true);
    }
}
