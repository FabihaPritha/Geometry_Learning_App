import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Circle extends JFrame {
    private Container c;
    private JButton Draw,Clear,Home_Page,calculation,area,peri,dia;
    private JTextField radius;
    private JLabel r_label, Label;

    private Font f,f1;
    private ImageIcon calc,home;

    Circle()
    {
        initComponents();
    }

    public void initComponents() {
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Circle Drawing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,25);
        f1 = new Font("Arial", Font.BOLD, 20);

        home=new ImageIcon(getClass().getResource("Home_Btn.png"));

        area=new JButton("Calculate Area");
        area.setBounds(20,370,200,50);
        c.add(area);

        area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAreaCalculation();

            }
        });


        peri=new JButton("Calculate Perimeter");
        peri.setBounds(20,430,200,50);
        c.add(peri);

        peri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPeriCalculation();
            }
        });

        dia=new JButton("Calculate Diagonal");
        dia.setBounds(20,490,200,50);
        c.add(dia);

        dia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDiaCalculation();
            }
        });


        r_label=new JLabel("Enter the Radius: ");
        r_label.setBounds(10,70,110,50);
        c.add(r_label);

        Label=new JLabel("Circle");
        Label.setBounds(725,700,100,60);
        Label.setFont(f);
        Label.setForeground(Color.BLACK);
        Label.setBackground(Color.LIGHT_GRAY);
        c.add(Label);


        radius=new JTextField();
        radius.setBounds(120,70,110,50);
        c.add(radius);

        Draw=new JButton("Draw");
        Draw.setBounds(65,130,80,40);
        c.add(Draw);

        Clear=new JButton("Clear");
        Clear.setBounds(155,130,80,40);
        c.add(Clear);

        Home_Page=new JButton(home);
        Home_Page.setBounds(70,180,130,50);
        c.add(Home_Page);


        Home_Page.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main Demo=new Main();
                Demo.setVisible(true);
                dispose();
            }
        });

        calc=new ImageIcon(getClass().getResource("Calc.png"));

        calculation=new JButton(calc);
        calculation.setBounds(60,250,160,50);
        c.add(calculation);

        calculation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculation demo=new Calculation();
                demo.setVisible(true);
               dispose();
            }
        });


        CirclePanel circlePanel=new CirclePanel();
        JPanel drawingPanel=new JPanel();
        drawingPanel.setBounds(250,90,1200,600);
        drawingPanel.setBackground(Color.LIGHT_GRAY);
        drawingPanel.add(circlePanel);
        c.add(drawingPanel);

        Draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                radius.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(radius.getText().isEmpty())
                        {
                            JOptionPane.showMessageDialog(null, "You didn't enter radius");
                        }

                    }
                });

                int r=Integer.parseInt(radius.getText());
                if(r<0) {
                    JOptionPane.showMessageDialog(null, "Enter positive integer value");
                }

                 int xc = 500, yc = 250;
                Graphics g=drawingPanel.getGraphics();
                circlePanel.setCircleDimension(xc,yc,r);
                circlePanel.paint(g);
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radius.setText("");
                circlePanel.clearCircle();
                drawingPanel.repaint();
            }
        });




    }
    private class CirclePanel extends JPanel {
        static int xc = 600, yc = 300;
        int r;

        int x2,y2,r2;

        public void setCircleDimension(int xc, int yc, int r) {
            CirclePanel.xc = xc;
            CirclePanel.yc = yc;
            this.r = r;
        }

        public void clearCircle() {
            x2=0;
            y2=0;
            r2=0;
        }

        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            g.setFont(f1);
            if(r>290)
            {
                r=290;
            } else if (r<50) {
                r=r+100;

            }
            else
            {
                r=r;
            }
            g.drawOval(200,10,2*r,2*r);
//            g.drawOval(350-r,350-r,r*2,r*2);
            g.drawLine(200+r,10+r,200+(2*r),10+r);
            g.drawString("r",200+r+(r/2),r);
        }

    }

    private void showAreaCalculation() {
        int a = Integer.parseInt(radius.getText());
        //int b = Integer.parseInt(height.getText());
        double area = 3.1416*a*a;
        double s=a*a;

        String calcArea = "Area = πr^2\n"
                + "    = 3.1416 X " + a + "^2\n"
                +"     = 3.1416 X " +s+"\n"
                + "    = " + area;

        JTextArea textArea = new JTextArea(calcArea);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JDialog dialog = new JDialog();
        dialog.setTitle("Calculation Result");
        dialog.setLayout(new BorderLayout());
        dialog.add(scrollPane, BorderLayout.CENTER);
       // dialog.setFont(f1);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showPeriCalculation() {
        int a = Integer.parseInt(radius.getText());


        double p =(2*3.1416*a);

        String calcPeri = "Perimeter =2πr\n"
                + "      = 2 X 3.1416 X " + a + "\n"
                +"       ="+p;


        JTextArea textP = new JTextArea(calcPeri);
        textP.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textP);

        JDialog dialog = new JDialog();
        dialog.setTitle("Calculation Result");
        dialog.setLayout(new BorderLayout());
        dialog.add(scrollPane, BorderLayout.CENTER);
        //dialog.setFont(f1);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showDiaCalculation() {
        int a = Integer.parseInt(radius.getText());
        double d =2*a;

        String calcPeri = "Diagonal =2 X r\n"
                + "      = 2 X " + a +"\n"
                +"      ="+d;


        JTextArea textP = new JTextArea(calcPeri);
        textP.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textP);

        JDialog dialog = new JDialog();
        dialog.setTitle("Calculation Result");
        dialog.setLayout(new BorderLayout());
        dialog.add(scrollPane, BorderLayout.CENTER);
      //  dialog.setFont(f1);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }



    public static void main(String[] args) {
        Circle Demo=new Circle();
        Demo.setVisible(true);


    }
}