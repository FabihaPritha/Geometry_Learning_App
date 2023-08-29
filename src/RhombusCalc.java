import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RhombusCalc extends JFrame {
    private Container c;
    private JLabel imageLabel,tl1,tl2,tl3, tl4,tl5,tl6,tl7,tl8,Label;
    private JTextField a,b,α,tfA,tfP,d;
    private JButton Calc,Home_Page,Back;
    private Font f1,f2;
    private ImageIcon image,home,back;

    RhombusCalc()
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

        image = new ImageIcon(getClass().getResource("5.png"));
        back = new ImageIcon(getClass().getResource("Back.png"));

        Back=new JButton(back);
        Back.setBounds(20,20,45,45);
        c.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RhombusDrawing demo1 = new RhombusDrawing();
                demo1.setVisible(true);
                dispose();

            }
        });

        imageLabel = new JLabel(image);
        imageLabel.setBounds(1200, 100, image.getIconWidth(), image.getIconHeight());
        c.add(imageLabel);

        Label=new JLabel("<html><b><u>Rhombus</u></b></html>");
        Label.setBounds(700,50,300,60);
        Label.setFont(f2);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        tl1 = new JLabel("<html>A rhombus is a special case of a parallelogram. In a rhombus, opposite sides are parallel " +
                "and the opposite angles are equal. Moreover, all the sides of a rhombus are equal in length, and the diagonals " +
                "bisect each other at right angles. The rhombus is also called a diamond or rhombus diamond. The plural form of a " +
                "rhombus is rhombi or rhombuses.<br><br>" +
                "* Area = (d1 X d2) / 2.<br>" +
                "* Perimeter = 4 * a.</html>");
        tl1.setBounds(100, 100, 1050, 200);
        tl1.setForeground(Color.blue);
        tl1.setFont(f1);
        c.add(tl1);

        tl2 = new JLabel("Calculation of the properties of a Parallelogram:");
        tl2.setBounds(100, 400, 1000, 50);
        tl2.setFont(f2);
        c.add(tl2);

        tl3 = new JLabel("length:");
        tl3.setBounds(100,480,90,50);
        tl3.setFont(f1);
        c.add(tl3);

        a=new JTextField();
        a.setBounds(180,480,100,50);
        a.setFont(f1);
        c.add(a);

        tl4=new JLabel("d1:");
        tl4.setBounds(330,480,90,50);
        tl4.setFont(f1);
        c.add(tl4);

        b=new JTextField();
        b.setBounds(370,480,100,50);
        b.setFont(f1);
        c.add(b);

        tl7=new JLabel("d2: ");
        tl7.setBounds(540,480,90,50);
        tl7.setFont(f1);
        c.add(tl7);

        d= new JTextField();
        d.setBounds(580,480,100,50);
        d.setFont(f1);
        c.add(d);

        Calc=new JButton("Calculate");
        Calc.setBounds(970,480,200,50);
        Calc.setFont(f1);
        c.add(Calc);

        tl5=new JLabel("Area: ");
        tl5.setBounds(100,600,150,50);
        tl5.setFont(f1);
        c.add(tl5);

        tfA= new JTextField();
        tfA.setBounds(190,600,200,50);
        tfA.setFont(f1);
        c.add(tfA);

        tl6=new JLabel("Perimeter: ");
        tl6.setBounds(600,600,150,50);
        tl6.setFont(f1);
        c.add(tl6);

        tfP= new JTextField();
        tfP.setBounds(730,600,200,50);
        tfP.setFont(f1);
        c.add(tfP);

        Calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(a.getText().isEmpty())
                    {
                        Double d1=Double.parseDouble(b.getText());
                        Double d2=Double.parseDouble(d.getText());

                        Double A=(d1*d2)/2;

                        String AA=String.valueOf(A);
                        tfA.setText(AA);
                    }
                   else if((b.getText().isEmpty()) && (d.getText().isEmpty()))
                    {
                        double l=Double.parseDouble(a.getText());
                        double p=4*l;
                        String PP=String.valueOf(p);
                        tfP.setText(PP);
                    }
                   else
                    {
                        tfA.setText(String.valueOf(((Double.parseDouble(b.getText()))*(Double.parseDouble(b.getText())))/2));
                        tfP.setText(String.valueOf(4*(Double.parseDouble(a.getText()))));
                    }
                }catch (NumberFormatException ex)
                {

                }
            }
        });
    }

    public static void main(String[] args) {
        RhombusCalc Demo=new RhombusCalc();
        Demo.setVisible(true);
    }
    }
