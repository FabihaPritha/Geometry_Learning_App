import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculation extends JFrame{
    private Container c;
    private ImageIcon image,home,back;
    private JLabel imageLabel,textLabel1,textLabel2,textLabel3, textLabel4,textLabel5,textLabel6,Label;
    private Font f1,f2;
    private JTextField r,tf1,tf2,tf3;
    private JButton Back,Home_Page;
    Calculation()
    {
        initComponent();
    }
    public void initComponent()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Calculation");

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        f1=new Font("Arial", Font.BOLD, 20);
        f2=new Font("Arial", Font.BOLD, 24);

        image=new ImageIcon(getClass().getResource("1.png"));
        back = new ImageIcon(getClass().getResource("Back.png"));

        Back=new JButton(back);
        Back.setBounds(20,20,45,45);
        c.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circle Demo=new Circle();
                Demo.setVisible(true);
                dispose();

            }
        });

        imageLabel=new JLabel(image);
        imageLabel.setBounds(1250,100,image.getIconWidth(),image.getIconHeight());
        c.add(imageLabel);

        Label=new JLabel("<html><b><u>Circle</u></b></html>");
        Label.setBounds(725,50,100,60);
        Label.setFont(f2);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        textLabel1=new JLabel("<html>A circle is a round-shaped figure that has no corners or edges. " +
                "The center of a circle is the center point in a circle from which all the distances to the points " +
                "on the circle are equal. This distance is called the radius of the circle. The straight line that joins" +
                " any two points on the circumference of a circle is called the chord. A line segment passing " +
                "through the center of a circle, and having its endpoints on the circle, is called the diameter of the circle.<br><br>" +
                "* Diameter of a circle, D = 2r<br>" +
                "* Area of a circle, A = πr^2<br>" +
                "* Perimeter of a circle, P = 2πr</html>");
        textLabel1.setBounds(100,100,1100,231);
        textLabel1.setForeground(Color.blue);
        textLabel1.setFont(f1);
        c.add(textLabel1);

        textLabel4=new JLabel("Calculation of the properties of a circle:");
        textLabel4.setBounds(100,340,500,50);
        textLabel4.setFont(f2);
        c.add(textLabel4);

        textLabel6 = new JLabel("Radius :");
        textLabel6.setBounds(100,400,80,50);
        textLabel6.setFont(f1);
        c.add(textLabel6);

        r=new JTextField();
        r.setBounds(200,400,100,40);
        r.setFont(f1);
        c.add(r);

        JButton calc = new JButton("Calculate");
        calc.setBounds(400,400,200,50);
        calc.setFont(f1);
        c.add(calc);

        textLabel2=new JLabel("Diameter: ");
        textLabel2.setBounds(100,480,150,50);
        textLabel2.setFont(f1);
        c.add(textLabel2);

        tf1= new JTextField();
        tf1.setBounds(280,480,200,50);
        tf1.setFont(f1);
        c.add(tf1);

        textLabel3=new JLabel("Area: ");
        textLabel3.setBounds(100,580,150,50);
        textLabel3.setFont(f1);
        c.add(textLabel3);

        tf2= new JTextField();
        tf2.setBounds(280,580,200,50);
        tf2.setFont(f1);
        c.add(tf2);

        textLabel5=new JLabel("Perimeter: ");
        textLabel5.setBounds(100,680,150,50);
        textLabel5.setFont(f1);
        c.add(textLabel5);

        tf3= new JTextField();
        tf3.setBounds(280,680,200,50);
        tf3.setFont(f1);
        c.add(tf3);

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double radius=Double.parseDouble(r.getText());
                double D=2*radius;
                double P= (2*3.1416*radius);
                double A= (3.1416*radius*radius);
                String DD=String.valueOf(D);
                String PP= String.valueOf(P);
                String AA=String.valueOf(A);
                tf1.setText(DD);
                tf3.setText(PP);
                tf2.setText(AA);
            }
        });

    }
}
public class CircleCalculation {
    public static void main(String[] args) {
        Calculation demo=new Calculation();
        demo.setVisible(true);
    }
}
