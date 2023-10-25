import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Parallelogram extends JFrame {
    private Container c;
    private JLabel a_Label, b_Label,α_Label,label;
    private JTextField a, b,α;
    private JButton Draw, Clear,Home_Page,calculation,area,peri;
    private Font f,f1;
    private ImageIcon home,calc;

    Parallelogram()
    {
        initComponents();
    }


    public void initComponents() {
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Parallelogram Drawing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 20);

        area=new JButton("Calculate Area");
        area.setBounds(20,380,200,50);
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

        b_Label = new JLabel("Enter the Side:");
        b_Label.setBounds(10, 50, 110, 30);
        c.add(b_Label);

        b = new JTextField();
        b.setBounds(120, 50, 100, 30);
        c.add(b);

        a_Label = new JLabel("Enter the Base:");
        a_Label.setBounds(10, 80, 110, 30);
        c.add(a_Label);

        a = new JTextField();
        a.setBounds(120, 80, 100, 30);
        c.add(a);

        α_Label = new JLabel("Enter the Angle:");
        α_Label.setBounds(10, 110, 110, 30);
        c.add(α_Label);

        α= new JTextField();
        α.setBounds(120, 110, 100, 30);
        c.add(α);

        label=new JLabel("Parallelogram");
        label.setBounds(725,700,200,60);
        label.setFont(f);
        c.add(label);

        Draw = new JButton("Draw");
        Draw.setBounds(65, 160, 80, 40);
        c.add(Draw);

        Clear = new JButton("Clear");
        Clear.setBounds(150, 160, 80, 40);
        c.add(Clear);

        home=new ImageIcon(getClass().getResource("Home_Btn.png"));
        calc=new ImageIcon(getClass().getResource("Calc.png"));

        Home_Page=new JButton(home);
        Home_Page.setBounds(70,240,140,50);
        c.add(Home_Page);

        Home_Page.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main Demo=new Main();
                Demo.setVisible(true);
                dispose();
            }
        });

        calculation=new JButton(calc);
        calculation.setBounds(70,320,160,50);
        c.add(calculation);

        calculation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParallelogramCalc Demo=new ParallelogramCalc();
                Demo.setVisible(true);
                dispose();
            }
        });

        Parallelogram.ParallelogramPanel parallelogramPanel=new Parallelogram.ParallelogramPanel();
        JPanel drawingPanel=new JPanel();
        drawingPanel.setBounds(250,90,1200,600);
        drawingPanel.setBackground(Color.LIGHT_GRAY);
        drawingPanel.add(parallelogramPanel);
        c.add(drawingPanel);

        Draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1=0;
                int n2=0;
                double A=0;
                try
                {
                    if(b.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You didn't enter Side.");
                    }
                    n1=Integer.parseInt(b.getText());
                    if(n1<0)
                    {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    }

                    if(a.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You didn't enter Base.");
                    }
                    n2=Integer.parseInt(a.getText());
                    if(n2<0)
                    {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    }

                    if(α.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "You didn't enter Base.");
                    }
                    A=Double.parseDouble(α.getText());
                    if(A<0)
                    {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    }



                }catch (NumberFormatException ex)
                {

                }

                Graphics g=drawingPanel.getGraphics();
                int x1 = 0;
                int x2=0;
                int x3=0;
                int x4=0;
                int y1=0;
                int y2=0;
                int y3=0;
                int y4=0;
                parallelogramPanel.setParallelogramDimension(x1,x2,x3,x4,y1,y2,y3,y4,n1,n2,A);
                parallelogramPanel.paintComponent(g);
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("");
                a.setText("");
                α.setText("");
                parallelogramPanel.clearParallelogram();
              drawingPanel.repaint();

            }
        });
    }


    private class ParallelogramPanel extends JPanel
    {
        private int x1,x2,x3,x4,y1,y2,y3,y4,n1,n2;
        double A;

        public void setParallelogramDimension(int x1,int x2,int x3,int x4,int y1,int y2, int y3, int y4,int n1,int n2,double A)
        {
            this.x1=x1;
            this.x2=x2;
            this.x3=x3;
            this.x4=x4;
            this.y1=y1;
            this.y2=y2;
            this.y3=y3;
            this.y4=y4;
            this.n1=n1;
            this.n2=n2;
            this.A=A;

        }


        public void clearParallelogram()
        {
            x1=0;
            x2=0;
            x3=0;
            x4=0;
            y1=0;
            y2=0;
            y3=0;
            y4=0;
            n1=0;
            n2=0;
            A=0;

        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x1,y1;

            // Set the color and draw the rectangle
            g.setColor(Color.BLACK);
            if(n1>400 && n2>700)
            {
                n1=400;
                n2=700;
            }
            else if(n1<100 && n2<100)
            {
                n1=n1+200;
                n2=n2+200;
            }
            else {
                n2=n2;
                n1=n1;
            }

                x1 = 100;
                y1 = 500;


            int x2 = x1 + n2;
            int y2 = y1;

            double angleRad = Math.toRadians(A);
            int x3 = (int) (x2 + n1 * Math.cos(angleRad));
            int y3 = (int) (y2 - n1 * Math.sin(angleRad));

            int x4 = x3 - n2;
            int y4 = y3;

            int[] xPoints = {x1, x2, x3, x4};
            int[] yPoints = {y1, y2, y3, y4};
            g.drawPolygon(xPoints,yPoints,4);
            g.setFont(f1);
            g.drawLine(x1,y1,x3,y3);
            g.drawLine(x2,y2,x4,y4);
            g.drawLine(x4,y4,x4,y1);
            g.drawString("a",x4/2,y4+20);
            g.drawString("h",x4+10,y4+50);
            g.drawString("b",200,550);
            g.drawString("d1",x4+(n2-100),y4+20);
            g.drawString("d2",x4+100,y4+50);
        }
    }

    private void showAreaCalculation() {
        int aa = Integer.parseInt(a.getText());
        int bb = Integer.parseInt(b.getText());
        int cc=Integer.parseInt(α.getText());
        double cr=Math.toRadians(cc);
        double s=Math.toRadians(cr);
        double area = aa * bb * s;

        String calcArea = "Area = b X a X sin α\n"
                + "     = " + bb + " X " + aa+ " X sin "+cc + "\n"
                +"       ="+ bb + " X " + aa+ " X "+s+"\n"
                + "     = " + area;

        JTextArea textArea = new JTextArea(calcArea);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JDialog dialog = new JDialog();
        dialog.setTitle("Calculation Result");
        dialog.setLayout(new BorderLayout());
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.setFont(f1);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showPeriCalculation() {
        int aa = Integer.parseInt(a.getText());
        int bb = Integer.parseInt(b.getText());
        int p =2*(aa+bb);

        String calcPeri = "Perimeter =2 X (b + a)\n"
                + "      = 2 X (" + bb + " + " + aa + ")\n"
                + "      = 2 X" +(aa+bb)+"\n"
                +"       ="+p;


        JTextArea textP = new JTextArea(calcPeri);
        textP.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textP);

        JDialog dialog = new JDialog();
        dialog.setTitle("Calculation Result");
        dialog.setLayout(new BorderLayout());
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.setFont(f1);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    public static void main(String[] args) {
        Parallelogram Demo=new Parallelogram();
        Demo.setVisible(true);
    }
}
