import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScaleneTriangle extends JFrame {
    private Container c;
    private JLabel imageLabel,tl1,tl2,tl3, tl4,tl5,tl6,tl7,tl8,Label;
    private JTextField a,b,d,h,tfA,tfP;
    private JButton Home_Page,Calc,Back;
    private Font f1,f2;
    private ImageIcon image,back,home;
    ScaleneTriangle()

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

        image = new ImageIcon(getClass().getResource("Sca.png"));
        back = new ImageIcon(getClass().getResource("Back.png"));

        Back=new JButton(back);
        Back.setBounds(20,20,45,45);
        c.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Triangle Demo=new Triangle();
                Demo.setVisible(true);
                dispose();
            }
        });

        imageLabel = new JLabel(image);
        imageLabel.setBounds(1200, 100, image.getIconWidth(), image.getIconHeight());
        c.add(imageLabel);

        Label=new JLabel("<html><b><u>Scalene Triangle</u></b></html>");
        Label.setBounds(700,50,300,60);
        Label.setFont(f2);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        tl1 = new JLabel("<html>A scalene triangle is a triangle in which all three sides are in different lengths, " +
                "and all three angles are of different measures. However, the sum of all the interior angles is " +
                "always equal to 180 degrees.<br><br>" +
                "* Area = 0.5 X c X h<br>" +
                "* Perimeter = a + b + c;</html>");
        tl1.setBounds(100, 100, 1050, 200);
        tl1.setForeground(Color.blue);
        tl1.setFont(f1);
        c.add(tl1);

        tl2=new JLabel("Calculation of the properties of a Parallelogram:");
        tl2.setBounds(100,400,1000,50);
        tl2.setFont(f2);
        c.add(tl2);

        tl3 = new JLabel("a:");
        tl3.setBounds(100,480,40,50);
        tl3.setFont(f1);
        c.add(tl3);

        a=new JTextField();
        a.setBounds(140,480,100,50);
        a.setFont(f1);
        c.add(a);

        tl4=new JLabel("b:");
        tl4.setBounds(330,480,40,50);
        tl4.setFont(f1);
        c.add(tl4);

        b=new JTextField();
        b.setBounds(370,480,100,50);
        b.setFont(f1);
        c.add(b);

        tl7=new JLabel("c: ");
        tl7.setBounds(540,480,40,50);
        tl7.setFont(f1);
        c.add(tl7);

        d= new JTextField();
        d.setBounds(580,480,100,50);
        d.setFont(f1);
        c.add(d);

        tl4=new JLabel("h :");
        tl4.setBounds(750,480,40,50);
        tl4.setFont(f1);
        c.add(tl4);

        h=new JTextField();
        h.setBounds(790,480,100,50);
        h.setFont(f1);
        c.add(h);

        Calc = new JButton("Calculate");
        Calc.setBounds(970,480,200,50);
        Calc.setFont(f1);
        c.add(Calc);

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


        Calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if((a.getText().isEmpty()) && (b.getText().isEmpty()))
                    {
                        tfA.setText(String.valueOf(0.5*((Double.parseDouble(d.getText())) * (Double.parseDouble(h.getText())))));
                    }

                   else if(h.getText().isEmpty()) {
                        tfP.setText(String.valueOf( (Double.parseDouble(a.getText())) + (Double.parseDouble(b.getText()))
                                + (Double.parseDouble(d.getText()))));
                    }
                    else
                    {
                        tfA.setText(String.valueOf(0.5*((Double.parseDouble(d.getText())) * (Double.parseDouble(h.getText())))));
                        tfP.setText(String.valueOf( (Double.parseDouble(a.getText())) + (Double.parseDouble(b.getText()))
                                + (Double.parseDouble(d.getText()))));
                    }

                }catch (NumberFormatException ex)
                {

                }
            }
        });

    }

    public static void main(String[] args) {
        ScaleneTriangle Demo=new ScaleneTriangle();
        Demo.setVisible(true);
    }
}
