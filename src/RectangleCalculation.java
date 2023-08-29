import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectangleCalculation extends JFrame {
    private Container c;
    private ImageIcon image,home,back;
    private JLabel imageLabel,tl1,tl2,tl3, tl4,tl5,tl6,tl7,tl8,Label;
    private Font f1,f2;
    private JTextField h,w,tfA,tfP,tfD,tfα;
    private JButton Back;
     RectangleCalculation()
     {
         initComponent();
     }

    public void initComponent() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Calculation");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Arial", Font.BOLD, 24);

        image = new ImageIcon(getClass().getResource("2.png"));
        back = new ImageIcon(getClass().getResource("Back.png"));

        Back=new JButton(back);
        Back.setBounds(20,20,45,45);
        c.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle Demo = new Rectangle();
                Demo.setVisible(true);
                dispose();

            }
        });


        imageLabel = new JLabel(image);
        imageLabel.setBounds(1250, 100, image.getIconWidth(), image.getIconHeight());
        c.add(imageLabel);

        Label=new JLabel("<html><b><u>Rectangle</u></b></html>");
        Label.setBounds(700,50,300,60);
        Label.setFont(f2);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        tl1=new JLabel("<html>A Rectangle is a four sided-polygon, having all the internal angles equal to 90 degrees." +
                " The two sides at each corner or vertex, meet at right angles. The opposite sides of the rectangle are equal" +
                " in length which makes it different from a square.<br><br>" +
                "* Area = a X b.<br>" +
                "* Perimeter = 2 (a+b).<br>" +
                "* Diagonal, d= √(a^2 + b^2).<br>" +
                "* Angle, α= 2 X arccos (b/d).</html>");
        tl1.setBounds(100,100,1050,200);
        tl1.setForeground(Color.blue);
        tl1.setFont(f1);
        c.add(tl1);

        tl2=new JLabel("Calculation of the properties of a Rectangle:");
        tl2.setBounds(100,400,1000,50);
        tl2.setFont(f2);
        c.add(tl2);

        tl3 = new JLabel("Width (b):");
        tl3.setBounds(100,480,90,50);
        tl3.setFont(f1);
        c.add(tl3);

        w=new JTextField();
        w.setBounds(200,480,100,50);
        w.setFont(f1);
        c.add(w);

        tl4=new JLabel("Height (a):");
        tl4.setBounds(600,480,110,50);
        tl4.setFont(f1);
        c.add(tl4);

        h=new JTextField();
        h.setBounds(720,480,100,50);
        h.setFont(f1);
        c.add(h);

        JButton calc = new JButton("Calculate");
        calc.setBounds(970,480,200,50);
        calc.setFont(f1);
        c.add(calc);

        tl5=new JLabel("Area: ");
        tl5.setBounds(100,560,150,50);
        tl5.setFont(f1);
        c.add(tl5);

        tfA= new JTextField();
        tfA.setBounds(260,560,200,50);
        tfA.setFont(f1);
        c.add(tfA);

        tl6=new JLabel("Perimeter: ");
        tl6.setBounds(100,640,150,50);
        tl6.setFont(f1);
        c.add(tl6);

        tfP= new JTextField();
        tfP.setBounds(260,640,200,50);
        tfP.setFont(f1);
        c.add(tfP);

        tl7=new JLabel("Diagonal: ");
        tl7.setBounds(600,560,150,50);
        tl7.setFont(f1);
        c.add(tl7);

        tfD= new JTextField();
        tfD.setBounds(760,560,200,50);
        tfD.setFont(f1);
        c.add(tfD);

        tl8=new JLabel("Angle: ");
        tl8.setBounds(600,640,150,50);
        tl8.setFont(f1);
        c.add(tl8);

        tfα= new JTextField();
        tfα.setBounds(760,640,200,50);
        tfα.setFont(f1);
        c.add(tfα);

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(h.getText());
                    double b = Double.parseDouble(w.getText());
                    Double A = a * b;
                    Double P = 2 * (a + b);
                    Double D = Math.sqrt((a * a) + (b * b));
                    Double α = 2 * (Math.acos(b / (D)));
                    String DD = String.valueOf(D);
                    String PP = String.valueOf(P);
                    String AA = String.valueOf(A);
                    String αα = String.valueOf(α);
                    tfA.setText(AA);
                    tfP.setText(PP);
                    tfD.setText(DD);
                    tfα.setText(αα);
                }catch (NumberFormatException ex)
                {

                }
            }
        });


    }

    public static void main(String[] args) {
        RectangleCalculation demo=new RectangleCalculation();
        demo.setVisible(true);
    }

    }
