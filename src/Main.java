import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private Container c;
    private JButton triangle, circle,rectangle,square,rhombus,parallelogram,Sca,Iso,Eq,Acute,Right,Obtuse;
    private JLabel Label;
    private Font f,f1;
    private JTextField tf;
    private JTextArea ta;
    private BorderLayout bl;
    Main()
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
        f1 = new Font("Arial", Font.BOLD, 20);
        //bl=new BorderLayout();

        Label=new JLabel(BorderLayout.CENTER);
        Label.setText("         Welcome to Geometry Learning Application");
        Label.setBounds(350,150,800,300);
        Label.setFont(f);
        Label.setOpaque(true);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);

        triangle=new JButton("Triangle");
        triangle.setBounds(200,500,200,100);
        triangle.setFont(f1);
        c.add(triangle);

        rectangle=new JButton("Rectangle");
        rectangle.setBounds(400,500,200,100);
        rectangle.setFont(f1);
        c.add(rectangle);

        circle=new JButton("Circle");
        circle.setBounds(600,500,200,100);
        circle.setFont(f1);
        c.add(circle);

        square=new JButton("Square");
        square.setBounds(200,600,200,100);
        square.setFont(f1);
        c.add(square);

        rhombus=new JButton("Rhombus");
        rhombus.setBounds(400,600,200,100);
        rhombus.setFont(f1);
        c.add(rhombus);

        parallelogram=new JButton("Parallelogram");
        parallelogram.setBounds(600,600,200,100);
        parallelogram.setFont(f1);
        c.add(parallelogram);

        Sca=new JButton("Scalene Triangle");
        Sca.setBounds(800,500,200,100);
        Sca.setFont(f1);
        c.add(Sca);

        Sca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScaleneTriangle Demo=new ScaleneTriangle();
                Demo.setVisible(true);
                dispose();
            }
        });

        Iso=new JButton("<html>Isosceles Triangle</html>");
        Iso.setBounds(1000,500,200,100);
        Iso.setFont(f1);
        c.add(Iso);

        Iso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IsoscelesTriangle Demo=new IsoscelesTriangle();
                Demo.setVisible(true);
                dispose();
            }
        });

        Eq=new JButton("<html>Equilateral Triangle</html>");
        Eq.setBounds(1200,500,200,100);
        Eq.setFont(f1);
        c.add(Eq);

        Eq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EquilateralTriangle Demo=new EquilateralTriangle();
                Demo.setVisible(true);
                dispose();
            }
        });


        Acute=new JButton("<html>Acute Angled Triangle</html>");
        Acute.setBounds(800,600,200,100);
        Acute.setFont(f1);
        c.add(Acute);

        Acute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcuteTriangle Demo=new AcuteTriangle();
                Demo.setVisible(true);
                dispose();
            }
        });

        Right=new JButton("<html>Right Angled Triangle</html>");
        Right.setBounds(1000,600,200,100);
        Right.setFont(f1);
        c.add(Right);

        Right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RightTriangle Demo=new RightTriangle();
                Demo.setVisible(true);
                dispose();
            }
        });

        Obtuse=new JButton("<html>Obtuse Angled Triangle</html>");
        Obtuse.setBounds(1200,600,200,100);
        Obtuse.setFont(f1);
        c.add(Obtuse);

        Obtuse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ObtuseTtiangle Demo=new ObtuseTtiangle();
                Demo.setVisible(true);
                dispose();
            }
        });



        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle Demo = new Rectangle();
                Demo.setVisible(true);
                dispose();
            }
        });
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circle Demo=new Circle();
                Demo.setVisible(true);
                dispose();
            }
        });

        triangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Triangle Demo=new Triangle();
                Demo.setVisible(true);
                dispose();
            }
        });

        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Square Demo = new Square();
                Demo.setVisible(true);
                dispose();
            }
        });

        rhombus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RhombusDrawing demo1 = new RhombusDrawing();
                demo1.setVisible(true);
                dispose();
            }
        });

        parallelogram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parallelogram Demo=new Parallelogram();
                Demo.setVisible(true);
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        Main Demo=new Main();
        Demo.setVisible(true);
    }
}
