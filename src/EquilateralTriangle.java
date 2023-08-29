import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquilateralTriangle extends JFrame {
    private Container c;
    private JLabel imageLabel,tl1,tl2,tl3, tl4,tl5,tl6,tl7,tl8,Label;
    private JTextField a,h,tfA,tfP;
    private JButton Home_Page,Calc,Back;
    private Font f1,f2;
    private ImageIcon image,home,back;
    EquilateralTriangle()

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

        image = new ImageIcon(getClass().getResource("Equ.png"));
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

        Label=new JLabel("<html><b><u>Equilateral Triangle</u></b></html>");
        Label.setBounds(700,50,300,60);
        Label.setFont(f2);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        tl1 = new JLabel("<html>Equilateral Triangle has 3 equal sides. Each of the interior angles will have" +
                " a measure of 60 degrees. Since the angles of an equilateral triangle are same, it is also known as an " +
                "equiangular triangle.<br><br>" +
                "* Area, A= ((√3)/4)*a^2.<br>" +
                "* Perimeter, P= 3*a.<br>" +
                "* Height, h= ((√3)/2)*a</html>");
        tl1.setBounds(100, 100, 1050, 200);
        tl1.setForeground(Color.blue);
        tl1.setFont(f1);
        c.add(tl1);

        tl2=new JLabel("Calculation of the properties of a Equilateral Triangle:");
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

        Calc = new JButton("Calculate");
        Calc.setBounds(400,480,200,50);
        Calc.setFont(f1);
        c.add(Calc);

        tl5=new JLabel("Area: ");
        tl5.setBounds(100,560,150,50);
        tl5.setFont(f1);
        c.add(tl5);

        tfA= new JTextField();
        tfA.setBounds(230,560,200,50);
        tfA.setFont(f1);
        c.add(tfA);

        tl6=new JLabel("Perimeter: ");
        tl6.setBounds(100,640,150,50);
        tl6.setFont(f1);
        c.add(tl6);

        tfP= new JTextField();
        tfP.setBounds(230,640,200,50);
        tfP.setFont(f1);
        c.add(tfP);

        tl7=new JLabel("Height: ");
        tl7.setBounds(600,560,150,50);
        tl7.setFont(f1);
        c.add(tl7);

        h= new JTextField();
        h.setBounds(700,560,200,50);
        h.setFont(f1);
        c.add(h);


        Calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {

                        tfA.setText(String.valueOf((1.732*((Double.parseDouble(a.getText())) * (Double.parseDouble(a.getText()))))/4));

                        h.setText(String.valueOf( (1.7321*(Double.parseDouble(a.getText())))/2));
                        tfP.setText(String.valueOf( (3*(Double.parseDouble(a.getText())))));


                }catch (NumberFormatException ex)
                {

                }
            }
        });

    }

    public static void main(String[] args) {
        EquilateralTriangle Demo=new EquilateralTriangle();
        Demo.setVisible(true);
    }
}
