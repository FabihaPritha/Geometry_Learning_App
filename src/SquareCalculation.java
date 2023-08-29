import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SquareCalculation extends JFrame {
    private Container c;
    private ImageIcon image,back;
    private JLabel imageLabel,tl1,tl2,tl3, tl4,tl5,tl6,tl7,tl8,Label;
    private Font f1,f2;
    private JTextField a,tfA,tfP,tfD,tfα;
    private JButton Back;
    SquareCalculation()
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

        image = new ImageIcon(getClass().getResource("3.png"));
        back = new ImageIcon(getClass().getResource("Back.png"));

        Back=new JButton(back);
        Back.setBounds(20,20,45,45);
        c.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Square Demo = new Square();
                Demo.setVisible(true);
                dispose();

            }
        });

        imageLabel = new JLabel(image);
        imageLabel.setBounds(1200, 100, image.getIconWidth(), image.getIconHeight());
        c.add(imageLabel);

        Label=new JLabel("<html><b><u>Square</u></b></html>");
        Label.setBounds(700,50,300,60);
        Label.setFont(f2);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        tl1=new JLabel("<html>Square is a two-dimensional plane figure with four equal sides and all the four angles" +
                " are equal to 90 degrees. The properties of rectangle are somewhat similar to a square, but the difference " +
                "between the two is, a rectangle has only its opposite sides equal. Therefore, a rectangle is called a square " +
                "only if all its four sides are of equal length<br><br>" +
                "* Area = a^2.<br>" +
                "* Perimeter = 4 X a.<br>" +
                "* Diagonal, d = √2 X a.</html>");
        tl1.setBounds(100,100,1050,300);
        tl1.setForeground(Color.blue);
        tl1.setFont(f1);
        c.add(tl1);

        tl2=new JLabel("Calculation of the properties of a Square:");
        tl2.setBounds(100,450,1000,50);
        tl2.setFont(f2);
        c.add(tl2);

        tl3 = new JLabel("a :");
        tl3.setBounds(100,530,50,50);
        tl3.setFont(f1);
        c.add(tl3);

        a=new JTextField();
        a.setBounds(150,530,100,50);
        a.setFont(f1);
        c.add(a);

        JButton calc = new JButton("Calculate");
        calc.setBounds(500,530,200,50);
        calc.setFont(f1);
        c.add(calc);

        tl5=new JLabel("Area: ");
        tl5.setBounds(100,610,150,50);
        tl5.setFont(f1);
        c.add(tl5);

        tfA= new JTextField();
        tfA.setBounds(260,610,200,50);
        tfA.setFont(f1);
        c.add(tfA);

        tl6=new JLabel("Perimeter: ");
        tl6.setBounds(100,690,150,50);
        tl6.setFont(f1);
        c.add(tl6);

        tfP= new JTextField();
        tfP.setBounds(260,690,200,50);
        tfP.setFont(f1);
        c.add(tfP);

        tl7=new JLabel("Diagonal: ");
        tl7.setBounds(600,610,150,50);
        tl7.setFont(f1);
        c.add(tl7);

        tfD= new JTextField();
        tfD.setBounds(760,610,200,50);
        tfD.setFont(f1);
        c.add(tfD);

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double length=Double.parseDouble(a.getText());

                Double A=length*length;
                Double P=4*length;
                Double D =1.4142*length;

                String DD=String.valueOf(D);
                String PP= String.valueOf(P);
                String AA=String.valueOf(A);

                tfA.setText(AA);
                tfP.setText(PP);
                tfD.setText(DD);

            }
        });
    }

    public static void main(String[] args) {
        SquareCalculation Demo=new SquareCalculation();
        Demo.setVisible(true);
    }
}
