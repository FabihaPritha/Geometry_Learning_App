import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {
    public Container c;
    private JLabel userLabel,passLabel;
    private JTextField tf;
    private JPasswordField pf;
    private JButton logInBtn,clrBtn;
    private Font f;
    LogIn()

    {
        initComponents();
    }
    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.YELLOW);

        f=new Font("Arial",Font.BOLD,18);


        userLabel=new JLabel("Username: ");
        userLabel.setBounds(50,50,150,50);
        userLabel.setFont(f);
        c.add(userLabel);

        tf=new JTextField();
        tf.setBounds(170,50,200,50);
        c.add(tf);

        passLabel=new JLabel("Password: ");
        passLabel.setBounds(50,120,150,50);
        passLabel.setFont(f);
        c.add(passLabel);

        pf=new JPasswordField();
        pf.setBounds(170,120,200,50);
        pf.setFont(f);
        c.add(pf);


        logInBtn=new JButton("Login");
        logInBtn.setBounds(170,190,90,50);
        logInBtn.setFont(f);
        c.add(logInBtn);

        clrBtn=new JButton("Clear");
        clrBtn.setBounds(280,190,90,50);
        clrBtn.setFont(f);
        c.add(clrBtn);

        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tf.setText("");
                pf.setText("");
            }
        });

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName=tf.getText();
                String password=pf.getText();

                if(userName.equals("Nowshin") && password.equals("1234"))
                {
                    JOptionPane.showMessageDialog(null,"You're Successfully log in");
                    dispose();
                    Main Demo=new Main();
                    Demo.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please enter correct name or password ");
                }
            }
        });

    }
    public static void main(String[] args) {
        LogIn Demo=new LogIn();
        Demo.setVisible(true);
        Demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Demo.setSize(500,500);
        Demo.setTitle("Log In Form");
    }
}
