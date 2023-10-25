import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Triangle extends JFrame {
    private Container c;
    private JButton Draw,Clear,Home_Page,area,peri;
    private JTextField x1,y1,x2,y2,x3,y3;
    private JLabel x1_y1_label,  x2_y2_label, x3_y3_label, label,label1,label2;

    private Font f,f1;

    Triangle()
    {

        initComponents();
    }

    public void initComponents() {
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Triangle Drawing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f = new Font("Arial", Font.BOLD, 25);
        f1=new Font("Arial", Font.BOLD, 15);

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

        x1_y1_label = new JLabel("Enter the value of x1,y1: ");
        x1_y1_label.setBounds(5, 80, 180, 30);
        c.add(x1_y1_label);

        x2_y2_label = new JLabel("Enter the value of x2, y2: ");
        x2_y2_label.setBounds(5, 115, 180, 30);
        c.add(x2_y2_label);

        x3_y3_label = new JLabel("Enter the value of x3, y3: ");
        x3_y3_label.setBounds(5, 150, 180, 30);
        c.add(x3_y3_label);

        label=new JLabel("Triangle");
        label.setBounds(725,700,100,60);
        label.setFont(f);
        c.add(label);

        TrianglePanel trianglePanel = new TrianglePanel();
        JPanel drawingPanel = new JPanel();
        drawingPanel.setBounds(350, 90, 1100, 600);
        drawingPanel.setBackground(Color.LIGHT_GRAY);
        drawingPanel.add(trianglePanel);
        c.add(drawingPanel);

        x1 = new JTextField();
        x1.setBounds(190, 80, 60, 30);
        c.add(x1);

        y1 = new JTextField();
        y1.setBounds(250, 80, 60, 30);
        c.add(y1);

        x2 = new JTextField();
        x2.setBounds(190, 115, 60, 30);
        c.add(x2);

        y2 = new JTextField();
        y2.setBounds(250, 115, 60, 30);
        c.add(y2);

        x3 = new JTextField();
        x3.setBounds(190, 150, 60, 30);
        c.add(x3);

        y3 = new JTextField();
        y3.setBounds(250, 150, 60, 30);
        c.add(y3);

        Home_Page=new JButton("Home Page");
        Home_Page.setBounds(70,250,100,40);
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
        Draw.setBounds(65, 190, 80, 40);
        c.add(Draw);

        Clear = new JButton("Clear");
        Clear.setBounds(155, 190, 80, 40);
        c.add(Clear);

        Draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x_1 = 0;
                int y_1 = 0;
                int x_2 = 0;
                int y_2 = 0;
                int x_3 = 0;
                int y_3 = 0;
                try {
                    if (x1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter x1");
                    } else if (y1.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter x2");
                    } else if (x2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter x3");
                    } else if (y2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter y1");
                    } else if (x3.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter y2");
                    } else if (y3.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter y3");
                    }

                    x_1 = Integer.parseInt((x1.getText()));
                    y_1 = Integer.parseInt((y1.getText()));
                    x_2 = Integer.parseInt((x2.getText()));
                    y_2 = Integer.parseInt((y2.getText()));
                    x_3 = Integer.parseInt((x3.getText()));
                    y_3 = Integer.parseInt((y3.getText()));


                    if (x_1 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    } else if (y_1 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    } else if (x_2 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    } else if (y_2 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    } else if (x_3 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    } else if (y_3 < 0) {
                        JOptionPane.showMessageDialog(null, "Enter positive integer value");
                    }
                } catch (NumberFormatException ex) {

                }

                Graphics g = drawingPanel.getGraphics();
                trianglePanel.setTriangleDimension(x_1, y_1, x_2, y_2, x_3, y_3);
                trianglePanel.paintComponent(g);
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x1.setText("");
                x2.setText("");
                x3.setText("");
                y1.setText("");
                y2.setText("");
                y3.setText("");
                trianglePanel.clearTriangle();
                drawingPanel.repaint();
            }
        });


    }

        private class TrianglePanel extends JPanel {
            private int x_1, y_1, x_2, y_2, x_3, y_3;

            public void setTriangleDimension(int x_1, int y_1, int x_2, int y_2, int x_3, int y_3) {
                this.x_1 = x_1;
                this.y_1 = y_1;
                this.x_2 = x_2;
                this.y_2 = y_2;
                this.x_3 = x_3;
                this.y_3 = y_3;
            }

        public void clearTriangle()
        {
            x_1=0;
            x_2=0;
            x_3=0;
            y_1=0;
            y_2=0;
            y_3=0;
        }

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                if ( x_1 > 900 && x_2 > 900 && x_3 > 900){
                    x_1=x_2=x_3=850;
                }
                 else if( y_1>500 && y_2>500 && y_3>500)
                {
                    y_1=500;
                    y_2=500;
                    y_3=500;
                }

                 else if((Math.abs(x_1-x_2)<200) )
                {
                    if(Math.max(x_1,x_2)==x_2)
                    {
                        x_2=x_2+200;
                    }
                    else
                        x_1=x_1+200;
                } else if ((Math.abs(x_1-x_3)<200) ) {
                    if(Math.max(x_1,x_3)==x_3)
                    {
                        x_3=x_3+200;
                    }
                    else
                        x_1=x_1+200;
                }
                 else if((Math.abs(x_3-x_2)<200) )
                {
                    if(Math.max(x_3,x_2)==x_2)
                    {
                        x_2=x_2+200;
                    }
                    else
                        x_3=x_3+200;
                }
                else if((Math.abs(y_1-y_2)<200) )
                {
                    if(Math.max(y_1,y_2)==y_2)
                    {
                        y_2=y_2+200;
                    }
                    else
                        y_1=y_1+200;
                }  else if ((Math.abs(y_1-y_3)<200) ) {
                    if(Math.max(y_1,y_3)==y_3)
                    {
                        y_3=y_3+200;
                    }
                    else
                        y_1=y_1+200;
                }

                 else if ((Math.abs(y_3-y_2)<200)) {
                    if(Math.max(y_3,y_2)==y_2)
                    {
                        y_2=y_2+200;
                    }
                    else
                        y_3=y_3+200;

                }
//                 else
//                {
//                    x_1=x_1;
//                    x_2=x_2;
//                    x_3=x_3;
//                    y_1=y_1;
//                    y_2=y_2;
//                    y_3=y_3;
//                }
                g.setFont(f1);
                // Set the color and draw the rectangle
                g.setColor(Color.BLACK);
                g.drawLine(x_1, y_1, x_2, y_2);
                //g.drawString("a",(x_1+x_2)/2,((y_1+y_2)/2)+50);
                g.setColor(Color.RED);
                g.drawLine(x_2, y_2, x_3, y_3);
                //g.drawString("b",((x_3+x_2)/2)+50,((y_3+y_2)/2)+50);
                g.setColor(Color.BLUE);
                g.drawLine(x_3, y_3, x_1, y_1);
                //g.drawString("c",((x_1+x_3)/2)-50,((y_1+y_3)/2)+50);
//                try {
//                    g.drawLine(x_1, y_1, ((x_1 - x_2) / (x_2 - x_3)), ((y_1 - y_2) / (y_2 - y_3)));
//                }catch (ArithmeticException ex)
//                {}
//                g.drawString("a",(x_1+x_2)/2,((y_1+y_2)/2)+50);
//                g.drawString("b",((x_3+x_2)/2)+50,((y_3+y_2)/2)+50);
//                g.drawString("c",((x_1+x_3)/2)-50,((y_1+y_3)/2)+50);
            }

        }
    private void showAreaCalculation() {
        int x_1 = Integer.parseInt((x1.getText()));
        int y_1 = Integer.parseInt((y1.getText()));
        int x_2 = Integer.parseInt((x2.getText()));
        int y_2 = Integer.parseInt((y2.getText()));
        int x_3 = Integer.parseInt((x3.getText()));
        int y_3 = Integer.parseInt((y3.getText()));

        int b1 = (x_3-x_1)^2;
        int b2=(y_3-y_1)^2;
        int b3=(b1+b2);
        double b=Math.sqrt(b3);

        double h=10;
        double area =0.5 * h * b;

        String calc_b="a = √(((x2 - x3)^2)+((y2-y3)^2))\n" +
                "   =√((("+x_2+" - "+x_3+")^2) + (("+y_2+" - "+y_3+")^2))\n" +
                "   =√("+b1+" + "+b2+")\n" +
                "   =√"+b3+"\n"
                +"   = "+b;

        String calcArea = "Area =0.5 X b × h\n"
                + "    = " + b + " X " + h + "\n"
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
        int x_1 = Integer.parseInt((x1.getText()));
        int y_1 = Integer.parseInt((y1.getText()));
        int x_2 = Integer.parseInt((x2.getText()));
        int y_2 = Integer.parseInt((y2.getText()));
        int x_3 = Integer.parseInt((x3.getText()));
        int y_3 = Integer.parseInt((y3.getText()));

        int a1 = Math.abs((x_2-x_1)^2);
        int a2=Math.abs((y_2-y_1)^2);
        int a3=Math.abs(a1+a2);
        double a=Math.sqrt(a3);
        int b1 = Math.abs((x_3-x_1)^2);
        int b2=Math.abs((y_3-y_1)^2);
        int b3=Math.abs(b1+b2);
        double b=Math.sqrt(b3);
        int c1 =Math.abs ((x_2-x_3)^2);
        int c2=Math.abs((y_2-y_3)^2);
        int c3=Math.abs(c1+c2);
        double c=Math.sqrt(c3);

        String calc_a="a = √(((x2 - x1)^2)+((y2-y1)^2))\n" +
                "   =√((("+x_2+" - "+x_1+")^2) + (("+y_2+" - "+y_1+")^2))\n" +
                "   =√("+a1+" + "+a2+")\n" +
                "   =√"+a3+"\n"
                +"   = "+a;

        String calc_b="b = √(((x2 - x3)^2)+((y2-y3)^2))\n" +
                "   =√((("+x_2+" - "+x_3+")^2) + (("+y_2+" - "+y_3+")^2))\n" +
                "   =√("+b1+" + "+b2+")\n" +
                "   =√"+b3+"\n"
                +"   = "+b;


        String calc_c="c = √(((x3 - x1)^2)+((y3-y1)^2))\n" +
                "   =√((("+x_3+" - "+x_1+")^2) + (("+y_3+" - "+y_1+")^2))\n" +
                "   =√("+c1+" + "+c2+")\n" +
                "   =√"+c3+"\n"
                +"   = "+c;


        String calcPeri = "Perimeter =a + b + c\n"
                + "      = " + a + " + " + b + " + " + c + "\n"
                +"       ="+(a+b+c);

        JTextArea textArea = new JTextArea(calc_a + "\n" + calc_b + "\n" + calc_c + "\n" + calcPeri);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

//        JTextArea texta = new JTextArea(calc_a);
//        JTextArea textb = new JTextArea(calc_b);
//        JTextArea textc = new JTextArea(calc_c);
//        JTextArea textP = new JTextArea(calcPeri);
//        textP.setEditable(false);
//        texta.setEditable(false);
//        textb.setEditable(false);
//        textc.setEditable(false);
//
//        JScrollPane scrollPane = new JScrollPane(textP);

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
        Triangle Demo=new Triangle();
        Demo.setVisible(true);
    }
}
