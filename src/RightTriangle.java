import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightTriangle extends JFrame {
    private Container c;
    private JLabel imageLabel,tl1,tl2,tl3, tl4,tl5,tl6,tl7,tl8,Label;
    private JTextField a,b,d,tfA,tfP;
    private JButton Home_Page,Calc,Back;
    private Font f1,f2;
    private ImageIcon image,home,back;
    RightTriangle()

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

        image = new ImageIcon(getClass().getResource("Right.png"));
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

        Label=new JLabel("<html><b><u>Right Angled Triangle</u></b></html>");
        Label.setBounds(700,50,300,60);
        Label.setFont(f2);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        tl1 = new JLabel("<html>A right-angled triangle is a triangle, that has one of its interior angles equal to " +
                "90 degrees or any one angle is a right angle. Therefore, this triangle is also called the right triangle " +
                "or 90-degree triangle. The right triangle plays an important role in trigonometry. Let us learn more about " +
                "this triangle in this article<br><br>" +
                "* Area = 0.5 X a X b.<br>" +
                "* Perimeter = a + b + c.<br>" +
                "* c = √(a^2 + b^2).</html>");
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

        Calc = new JButton("Calculate");
        Calc.setBounds(570,480,200,50);
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

        tl7=new JLabel("c: ");
        tl7.setBounds(680,560,150,50);
        tl7.setFont(f1);
        c.add(tl7);

        d= new JTextField();
        d.setBounds(720,560,200,50);
        d.setFont(f1);
        c.add(d);


        Calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                        tfA.setText(String.valueOf(0.5*((Double.parseDouble(a.getText())) * (Double.parseDouble(b.getText())))));
                        d.setText(String.valueOf(Math.sqrt (((Double.parseDouble(a.getText())) * (Double.parseDouble(a.getText())))
                                + ((Double.parseDouble(b.getText())) * (Double.parseDouble(b.getText()))))));

                    tfP.setText(String.valueOf( (Double.parseDouble(a.getText())) + (Double.parseDouble(b.getText()))
                            + (Double.parseDouble(d.getText()))));


                }catch (NumberFormatException ex)
                {

                }
            }
        });

    }

    public static void main(String[] args) {
        RightTriangle Demo=new RightTriangle();
        Demo.setVisible(true);
    }
}
