import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParallelogramCalc extends JFrame {
    private Container c;
    private JLabel imageLabel,tl1,tl2,tl3, tl4,tl5,tl6,tl7,tl8,Label;
    private JTextField a,b,α,tfA1,tfA2,tfP,tfh;
    private JButton Home_Page,Back;
    private Font f1,f2;
    private ImageIcon image,home,back;

     ParallelogramCalc()
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

        image = new ImageIcon(getClass().getResource("4.png"));
        back = new ImageIcon(getClass().getResource("Back.png"));

        imageLabel = new JLabel(image);
        imageLabel.setBounds(1200, 100, image.getIconWidth(), image.getIconHeight());
        c.add(imageLabel);

        Back=new JButton(back);
        Back.setBounds(20,20,45,45);
        c.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parallelogram Demo=new Parallelogram();
                Demo.setVisible(true);
                dispose();
            }
        });

        Label=new JLabel("<html><b><u>Parallelogram</u></b></html>");
        Label.setBounds(700,50,300,60);
        Label.setFont(f2);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        tl1=new JLabel("<html>A parallelogram is a two-dimensional geometrical shape whose sides are parallel to each " +
                "other. It is a type of polygon having four sides (also called quadrilateral), where the pair of parallel " +
                "sides are equal in length. The Sum of adjacent angles of a parallelogram is equal to 180 degrees.<br><br>" +
                "* Area with height = b X h.<br>" +
                "* Area without height = a X bX sin α;<br>" +
                "* Perimeter = 2 (a+b).</html>");
        tl1.setBounds(100,100,1050,200);
        tl1.setForeground(Color.blue);
        tl1.setFont(f1);
        c.add(tl1);

        tl2=new JLabel("Calculation of the properties of a Parallelogram:");
        tl2.setBounds(100,400,1000,50);
        tl2.setFont(f2);
        c.add(tl2);

        tl3 = new JLabel("Base:");
        tl3.setBounds(100,480,90,50);
        tl3.setFont(f1);
        c.add(tl3);

        b=new JTextField();
        b.setBounds(180,480,100,50);
        b.setFont(f1);
        c.add(b);

        tl4=new JLabel("Side:");
        tl4.setBounds(310,480,90,50);
        tl4.setFont(f1);
        c.add(tl4);

        a=new JTextField();
        a.setBounds(390,480,100,50);
        a.setFont(f1);
        //final boolean editable = a.isEditable(0);
        c.add(a);

        tl7=new JLabel("Height: ");
        tl7.setBounds(520,480,90,50);
        tl7.setFont(f1);
        c.add(tl7);

        tfh= new JTextField();
        tfh.setBounds(600,480,100,50);
        tfh.setFont(f1);
        c.add(tfh);

        tl8=new JLabel("Angle: ");
        tl8.setBounds(730,480,90,50);
        tl8.setFont(f1);
        c.add(tl8);

        α= new JTextField();
        α.setBounds(810,480,100,50);
        α.setFont(f1);
        c.add(α);

        JButton calc = new JButton("Calculate");
        calc.setBounds(970,480,200,50);
        calc.setFont(f1);
        c.add(calc);

        tl5=new JLabel("Area with height: ");
        tl5.setBounds(100,600,200,50);
        tl5.setFont(f1);
        c.add(tl5);

        tfA1= new JTextField();
        tfA1.setBounds(260,600,200,50);
        tfA1.setFont(f1);
        tfA1.setEditable(false);
        c.add(tfA1);

        tl7=new JLabel("Area without height: ");
        tl7.setBounds(600,560,210,50);
        tl7.setFont(f1);
        c.add(tl7);

        tfA2= new JTextField();
        tfA2.setBounds(810,560,200,50);
        tfA2.setFont(f1);
        tfA2.setEditable(false);
        c.add(tfA2);

        tl6=new JLabel("Perimeter: ");
        tl6.setBounds(600,640,150,50);
        tl6.setFont(f1);
        c.add(tl6);

        tfP= new JTextField();
        tfP.setBounds(810,640,200,50);
        tfP.setFont(f1);
        tfP.setEditable(false);
        c.add(tfP);

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try
            {
                if((a.getText().isEmpty()) && (α.getText().isEmpty()))
                {
                    double base = Double.parseDouble(b.getText());
                    double height=Double.parseDouble(tfh.getText());
                    Double A1 = base * height;
                    String AA1 = String.valueOf(A1);
                    tfA1.setText(AA1);
                }

                if(tfh.getText().isEmpty()) {
                    double base = Double.parseDouble(b.getText());
                    double angle=Double.parseDouble(α.getText());
                    double angRad=Math.toRadians(angle);
                    double side = Double.parseDouble(a.getText());
                    Double A2 = (side * base) * Math.sin(angRad);
                    Double P = 2 * (side + base);

                    String PP = String.valueOf(P);
                    String AA2 = String.valueOf(A2);
                    tfP.setText(PP);
                    tfA2.setText(AA2);
                }
                else
                {
                    tfA1.setText(String.valueOf((Double.parseDouble(b.getText())) * (Double.parseDouble(tfh.getText()))));
                    tfP.setText(String.valueOf((2 * (Double.parseDouble(a.getText())) + (Double.parseDouble(b.getText())))));
                    tfA2.setText(String.valueOf(((Double.parseDouble(a.getText())) * (Double.parseDouble(b.getText()))) *
                            Math.sin((Math.toRadians(Double.parseDouble(α.getText()))))));
                }

            }catch (NumberFormatException ex)
            {

            }
            }
        });

    }

    public static void main(String[] args) {
        ParallelogramCalc Demo=new ParallelogramCalc();
        Demo.setVisible(true);
    }

}
