import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RhombusDrawing extends JFrame {
    private Container c;
    private JLabel a_Label, α_Label, label;
    private JTextField a, α;
    private JButton Draw, Clear, Home_Page,calculation,area,peri;
    private Font f,f1;
    private JPanel panel;
    private ImageIcon calc,home;

    RhombusDrawing() {
        initComponents();
    }

    public void initComponents() {
        this.setBounds(0, 0, 1550, 850);
        this.setTitle("Rhombus Drawing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 20);

        peri=new JButton("Calculate Perimeter");
        peri.setBounds(20,430,200,50);
        c.add(peri);

        peri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPeriCalculation();
            }
        });

        a_Label = new JLabel("Enter the Side:");
        a_Label.setBounds(10, 50, 110, 30);
        c.add(a_Label);

        a = new JTextField();
        a.setBounds(120, 50, 100, 30);
        c.add(a);

        α_Label = new JLabel("Enter the Angle:");
        α_Label.setBounds(10, 80, 110, 30);
        c.add(α_Label);

        α = new JTextField();
        α.setBounds(120, 80, 100, 30);
        c.add(α);

        label = new JLabel("Rhombus");
        label.setBounds(725, 700, 200, 60);
        label.setFont(f);
        c.add(label);

        Draw = new JButton("Draw");
        Draw.setBounds(65, 130, 80, 40);
        c.add(Draw);

        Clear = new JButton("Clear");
        Clear.setBounds(150, 130, 80, 40);
        c.add(Clear);

        calc=new ImageIcon(getClass().getResource("Calc.png"));
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

        calculation=new JButton(calc);
        calculation.setBounds(60,250,160,50);
        c.add(calculation);

        calculation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RhombusCalc Demo=new RhombusCalc();
                Demo.setVisible(true);
                dispose();
            }
        });

        RhombusPanel rhombusPanel = new RhombusPanel();
        JPanel drawingPanel = new JPanel();
        drawingPanel.setBounds(250, 90, 1200, 600);
        drawingPanel.setBackground(Color.LIGHT_GRAY);
        drawingPanel.add(rhombusPanel);
        c.add(drawingPanel);

        Draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sideLength = 0;
                double angle = 0;
                try {
                    if (a.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter Side.");
                    }
                    sideLength = Integer.parseInt(a.getText());
                    if (sideLength < 0) {
                        JOptionPane.showMessageDialog(null, "Enter a positive integer value");
                    }

                    if (α.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You didn't enter Angle.");
                    }
                    angle = Double.parseDouble(α.getText());
                    if (angle < 0) {
                        JOptionPane.showMessageDialog(null, "Enter a positive angle value");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input format");
                }

                Graphics g = drawingPanel.getGraphics();
                rhombusPanel.setRhombusDimensions(sideLength, angle);
                rhombusPanel.paintComponent(g);
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.setText("");
                α.setText("");
                rhombusPanel.clearRhombus();
                drawingPanel.repaint();
            }
        });
    }

    private class RhombusPanel extends JPanel {
        private int sideLength;
        private double angle;

        public void setRhombusDimensions(int sideLength, double angle) {
            this.sideLength = sideLength;
            this.angle = Math.toRadians(angle);
        }

        public void clearRhombus() {
            sideLength = 0;
            angle = 0;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            int centerX = 300;
            int centerY = 300;

            int[] xPoints = {
                    centerX,
                    (int) (centerX + sideLength * Math.cos(angle)),
                    centerX,
                    (int) (centerX - sideLength * Math.cos(angle))
            };

            int[] yPoints = {
                    (int) (centerY - sideLength * Math.sin(angle)),
                    centerY,
                    (int) (centerY + sideLength * Math.sin(angle)),
                    centerY
            };

            g.drawPolygon(xPoints, yPoints, 4);
            g.setFont(f1);
            g.drawString("a ="+sideLength, (int) (centerX + sideLength * Math.cos(angle)),240);
            g.drawLine(300,(int) (centerY - sideLength * Math.sin(angle)),centerX,(int) (centerY + sideLength * Math.sin(angle)));
            g.drawLine((int) (centerX + sideLength * Math.cos(angle)),300,(int) (centerX - sideLength * Math.cos(angle)),300);
            g.drawString("d1",(int) (centerX + sideLength * Math.cos(angle))-50,300);
            g.drawString("d2",300,(int) (centerY - sideLength * Math.sin(angle))+150);
        }
    }

    private void showPeriCalculation() {
        int l = Integer.parseInt(a.getText());
        int p =4*(l);

        String calcPeri = "Perimeter =4 X a\n"
                + "      = 4 X" + l + " + " + "\n"
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
        RhombusDrawing demo1 = new RhombusDrawing();
        demo1.setVisible(true);
    }
}
