
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*; 
public class Login extends JFrame implements ActionListener {
    JButton signup,login,clear;
    JTextField cardtxt;
    JPasswordField pintxt;

    Login(){
        setLayout(null);
        setSize(1020, 1020);
        setLocation(450, 0);
        setTitle("ATM");
        getContentPane().setBackground(Color.WHITE);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image=icon.getImage().getScaledInstance(1020, 1050, Image.SCALE_DEFAULT);
        icon=new ImageIcon(image);
        JLabel imagLabel=new JLabel(icon);
        imagLabel.setBounds(0, 0, 1020, 1050);
        add(imagLabel);

        // ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        // Image image1=icon1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        // icon1=new ImageIcon(image1);
        // JLabel label1=new JLabel(icon1);
        // label1.setBounds(100,65,100,100);
        // imagLabel.add(label1);
        JLabel text1=new JLabel("WELCOME TO ATM");
        text1.setBounds(230,360,400,30);
        text1.setFont(new Font("OSWARD",Font.BOLD,30));
        text1.setForeground(Color.WHITE);
        imagLabel.add(text1);

        JLabel cardno=new JLabel("ACC No  :");
        cardno.setBounds(180,440,200,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,25));
        cardno.setForeground(Color.WHITE);
        imagLabel.add(cardno);

        cardtxt=new JTextField();
        cardtxt.setBounds(320, 440, 250, 30);
        cardtxt.setFont(new Font("Arial",Font.BOLD,25));
        imagLabel.add(cardtxt);

        JLabel pin=new JLabel("PIN         :");
        pin.setBounds(180,490,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setForeground(Color.white);
        imagLabel.add(pin);

        pintxt=new JPasswordField();
        pintxt.setBounds(320, 490, 250, 30);
        pintxt.setFont(new Font("Arial",Font.BOLD,25));
        imagLabel.add(pintxt);

        login=new JButton( "LOGIN");
        login.setBounds(175, 570, 100, 30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        imagLabel.add(login);

        clear=new JButton( "CLEAR");
        clear.setBounds(488, 570, 100, 30);
        clear.setBackground(Color.white);
        clear.setForeground(Color.black);
        clear.addActionListener(this);
        imagLabel.add(clear);

        signup=new JButton( "SIGN UP");
        signup.setBounds(488, 610, 100, 30);
        signup.setBackground(Color.white);
        signup.setForeground(Color.black);
        signup.addActionListener(this);
        imagLabel.add(signup);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==login){
            String card=cardtxt.getText();
            String pass=pintxt.getText();
            System.out.println(card);
            System.out.println(pass);
            String Q1="select pin from account_info where acc_no='"+card+"' and pin='"+pass+"'";
            try{
                 Cnction connection=new Cnction();
                 
                ResultSet rs=connection.s.executeQuery(Q1);
                if(rs.next()){
                    setVisible(false);
                    new Atm(card);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid card number or pin");
                    pintxt.setText("");
                    return;
                }
            }
            catch(Exception e){
                System.out.println(e);

            }

        }
        else if(a.getSource()==signup){
            setVisible(false);
            new SignUpOne();
        }
        else if(a.getSource()==clear){
            cardtxt.setText("");
            pintxt.setText("");
        }
    }

    public static void main(String[] args) throws Exception {
       new Login();
    }
}

