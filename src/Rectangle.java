import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rectangle extends JFrame {
    private Container c;
    private JLabel h_Label, w_Label,label;
    private JTextField height, width;
    private JTextArea ta;
    private JButton Draw, Cancel,Home_Page,calculation,area,peri,dia;
    private Font f,f1;
    private JDialog d1,d2,d3;
    private ImageIcon home,back,calc;
    private boolean areaPanelAdded = false;
    //private JScrollPane scroll;

    Rectangle() {

        initComponents();
    }


    public void initComponents() {
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Rectangle Drawing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f=new Font("Arial",Font.BOLD,25);
        f1 = new Font("Arial", Font.BOLD, 20);

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

        h_Label = new JLabel("Enter the Width:");
        h_Label.setBounds(10, 50, 110, 30);
        c.add(h_Label);

        w_Label = new JLabel("Enter the Height:");
        w_Label.setBounds(10, 80, 110, 30);
        c.add(w_Label);

        label=new JLabel("Rectangle");
        label.setBounds(725,700,200,60);
        label.setFont(f);
        c.add(label);

        height = new JTextField();
        height.setBounds(120, 50, 100, 30);
        c.add(height);

        width = new JTextField();
        width.setBounds(120, 80, 100, 30);
        c.add(width);

        home=new ImageIcon(getClass().getResource("Home_Btn.png"));

        Home_Page=new JButton(home);
        Home_Page.setBounds(70,180,100,40);
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
                RectangleCalculation Demo=new RectangleCalculation();
                Demo.setVisible(true);
                dispose();
            }
        });


        Draw = new JButton("Draw");
        Draw.setBounds(65, 130, 80, 40);
        c.add(Draw);


        Cancel = new JButton("Cancel");
        Cancel.setBounds(150, 130, 80, 40);
        c.add(Cancel);



        RectanglePanel rectanglePanel=new RectanglePanel();
        JPanel drawingPanel=new JPanel();
        drawingPanel.setBounds(250,90,1200,600);
        drawingPanel.setBackground(Color.LIGHT_GRAY);
        drawingPanel.add(rectanglePanel);
        c.add(drawingPanel);

        Draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1 = 0;
                int n2 = 0;
                try {

                    if (width.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter Width");
                    }
                    n2 = Integer.parseInt(width.getText());
                if(n2 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    }
                    if (height.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter Height");
                    }
                    n1 = Integer.parseInt((height.getText()));
                    if (n1 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    }
                } catch (NumberFormatException ex) {

                }


                Graphics g = drawingPanel.getGraphics();
                rectanglePanel.setRectangleDimension(n1, n2);
                rectanglePanel.paintComponent(g);
            }
        });
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                height.setText("");
                width.setText("");
                rectanglePanel.clearRectangle();
                drawingPanel.repaint();

            }
        });


    }

    private class RectanglePanel extends JPanel {
        private int n1, n2;

        public void setRectangleDimension(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        public void clearRectangle() {
         n1 = 0;
           n2 = 0;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (n1>500 && n2>800) {
                n1=500;
                n2=1100;
            }
            if (n1<100 && n2<100) {
                n1=n1+100;
                n2=n2+100;

            }
//            else
//            {
//                n1=n1;
//                n2=n2;
//            }

            // Set the color and draw the rectangle
            g.setColor(Color.YELLOW);
            g.fillRect(90, 90, n1, n2);
            g.setColor(Color.RED);
            g.drawLine(90,90,90+n1,90+n2);

            if (n1 > 0 && n2 > 0) {
                g.setColor(Color.RED);
                g.setFont(f1);
                g.drawString("a(Width)", 90 + n1 / 2, 90 - 5);
                g.drawString("b(Height)", 0, 90 + (n2 / 2));
                g.drawString("d",80+ n1/2, 80+ n2/2);
            }
        }
    }
    private void showAreaCalculation() {
        int a = Integer.parseInt(width.getText());
        int b = Integer.parseInt(height.getText());
        int area = a * b;

        String calcArea = "Area = Height × Width\n"
                + "    = " + a + " × " + b + "\n"
                + "    = " + area;

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
        int a = Integer.parseInt(width.getText());
        int b = Integer.parseInt(height.getText());
        int p =2*(a+b);

        String calcPeri = "Perimeter =2 X (Height + Width)\n"
                + "      = 2 X" + a + " + " + b + "\n"
                + "      = 2 X" +(a+b)+"\n"
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

    private void showDiaCalculation() {
        int a = Integer.parseInt(width.getText());
        int b = Integer.parseInt(height.getText());
        double d =Math.sqrt((a*a)+(b*b));
        double add=(a*a)+(b*b);

        String calcPeri = "Diagonal =√ (a^2 + b^2)\n"
                + "      = √(" + a +"^2"+ " + " + b +"^2"+ ")\n"
                + "      = √(" +(a*a)+"+"+(b*b)+")\n"
                +"      =√("+add+")\n"
                +"      ="+d;


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




    public static void main (String[]args){
            Rectangle Demo = new Rectangle();
            Demo.setVisible(true);

        }
    }