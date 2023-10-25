import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square extends JFrame {
    private Container c;
    private JLabel h_Label, label;
    private JTextField height, width;
    private JTextArea ta;
    private JButton Draw, Cancel,Home_Page,calculation,area,peri,dia;
    private Font f,f1;
    private JPanel panel;
    private ImageIcon calc,home;
    //private JScrollPane scroll;

    Square() {

        initComponents();
    }


    public void initComponents() {
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Square Drawing");
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


        h_Label = new JLabel("Enter the value of a:");
        h_Label.setBounds(10, 50, 150, 30);
        c.add(h_Label);

        label=new JLabel("Square");
        label.setBounds(725,700,200,60);
        label.setFont(f);
        c.add(label);

        height = new JTextField();
        height.setBounds(160, 50, 100, 30);
        c.add(height);


        Home_Page=new JButton("Home Page");
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

        Draw = new JButton("Draw");
        Draw.setBounds(65, 130, 80, 40);
        c.add(Draw);


        Cancel = new JButton("Cancel");
        Cancel.setBounds(150, 130, 80, 40);
        c.add(Cancel);

        calc=new ImageIcon(getClass().getResource("Calc.png"));

        calculation=new JButton(calc);
        calculation.setBounds(60,250,160,50);
        c.add(calculation);

        calculation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SquareCalculation Demo=new SquareCalculation();
                Demo.setVisible(true);
                dispose();
            }
        });

        SquarePanel squarePanel=new SquarePanel();
        JPanel drawingPanel=new JPanel();
        drawingPanel.setBounds(250,90,1200,600);
        drawingPanel.setBackground(Color.LIGHT_GRAY);
        drawingPanel.add(squarePanel);
        c.add(drawingPanel);

        Draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1=0;
                try {
                    if (height.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter Height");
                    }
                    n1 = Integer.parseInt((height.getText()));
                    if (n1 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    }
                }catch (NumberFormatException ex)
                {}


                Graphics g = drawingPanel.getGraphics();
                squarePanel.setSquareDimension(n1);
                squarePanel.paintComponent(g);
            }
        });

        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                height.setText("");
                squarePanel.clearSquare();
                drawingPanel.repaint();

            }
        });


    }

    private class SquarePanel extends JPanel {
        private int n1;

        public void setSquareDimension(int n1) {
            this.n1 = n1;

        }

        public void clearSquare() {
            n1 = 0;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (n1>550) {
                n1=550;
            }
            else if (n1<100) {
                n1=n1+100;
            }
            else
            {
                n1=n1;
            }


            g.setColor(Color.YELLOW);
            g.fillRect(50, 50, n1, n1);
            g.setColor(Color.RED);
            g.drawLine(50, 50, 50 + n1, 50 + n1);

            if (n1 > 0) {
                g.setColor(Color.RED);
                g.setFont(f1);
                g.drawString("a", 50 + n1 / 2, 50 - 5);
                g.drawString("d",50+ n1/2, 50+ n1/2);

            }
        }
    }
    private void showAreaCalculation() {
        int b = Integer.parseInt(height.getText());
        int area = b * b;

        String calcArea = "Area = a^2\n"
                + "    = " + b + "^2"+ "\n"
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
        int b = Integer.parseInt(height.getText());
        int p =4*b;

        String calcPeri = "Perimeter =4 X a\n"
                + "      = 4 X" + b + "\n"
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
        int b = Integer.parseInt(height.getText());
        double d =1.4142*b;


        String calcPeri = "Diagonal =√2 X a\n"
                + "        = √2 X " + b +"\n"
                +"         ="+d;


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
        Square Demo = new Square();
        Demo.setVisible(true);

    }
}