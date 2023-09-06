import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Atm extends JFrame implements ActionListener{
    String acc_no;
    JButton depositButton,withdrawButton,ministatementButton,balanceButton,exiButton,FastCashButton,pinButton;
    Atm(String acc_no){
        setLayout(null);
        this.acc_no=acc_no;
        setSize(1020, 1020);
        setLocation(450, 0);;
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image=icon.getImage().getScaledInstance(1020, 1050, Image.SCALE_DEFAULT);
        icon=new ImageIcon(image);
        JLabel imagLabel=new JLabel(icon);
        imagLabel.setBounds(0, 0, 1020, 1050);
        add(imagLabel);

        JLabel text=new JLabel("Please Select Your Transaction");
        text.setBounds(230, 360, 700, 30);
        text.setFont(new Font("arial",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        imagLabel.add(text);

        withdrawButton=new JButton("Withdraw Cash");
        withdrawButton.setBackground(Color.white);
        withdrawButton.setBounds(185, 490, 150, 30);
        withdrawButton.setFont(new Font("arial",Font.BOLD,16));
        withdrawButton.addActionListener(this);
        imagLabel.add(withdrawButton);
        
        depositButton=new JButton("Deposit Cash");
        depositButton.setBackground(Color.white);
        depositButton.setBounds(425, 490, 150, 30);
        depositButton.setFont(new Font("arial",Font.BOLD,16));
        depositButton.addActionListener(this);
        imagLabel.add(depositButton);
        

        FastCashButton=new JButton("Fast Cash");
        FastCashButton.setBackground(Color.white);
        FastCashButton.setBounds(185, 530, 150, 30);
        FastCashButton.setFont(new Font("arial",Font.BOLD,16));
        FastCashButton.addActionListener(this);
        imagLabel.add(FastCashButton);

        ministatementButton=new JButton("Mini Statement");
        ministatementButton.setBackground(Color.white);
        ministatementButton.setBounds(425,530, 150, 30);
        ministatementButton.setFont(new Font("arial",Font.BOLD,16));
        ministatementButton.addActionListener(this);
        imagLabel.add(ministatementButton);

        pinButton=new JButton("Pin Change");
        pinButton.setBackground(Color.white);
        pinButton.setBounds(185, 570, 150, 30);
        pinButton.setFont(new Font("arial",Font.BOLD,16));
        pinButton.addActionListener(this);
        imagLabel.add(pinButton);

        balanceButton=new JButton("Balance Enquiry");
        balanceButton.setBackground(Color.white);
        balanceButton.setBounds(425, 570, 150, 30);
        balanceButton.setFont(new Font("arial",Font.BOLD,15));
        balanceButton.addActionListener(this);
        imagLabel.add(balanceButton);

        exiButton=new JButton("Exit");
        exiButton.setBackground(Color.white);
        exiButton.setBounds(425, 610, 150, 30);
        exiButton.setFont(new Font("arial",Font.BOLD,16));
        exiButton.addActionListener(this);
        imagLabel.add(exiButton);




        setVisible(true);

        



    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        if(e.getSource()==exiButton){
            System.exit(0);
        }
        else if(e.getSource()==withdrawButton){
            new Withdraw(acc_no);
        }
        else if(e.getSource()==depositButton){
            new Deposit(acc_no);

        }
        else if(e.getSource()==balanceButton){
            setVisible(false);
            new Balance(acc_no);
            Cnction con=new Cnction();
            int currbal=0;
            try{
                con.c.setAutoCommit(false);
                    String Q1="select total_bal from account_info where acc_no='"+acc_no+"'";
                    ResultSet rs=con.s.executeQuery(Q1);            
                    rs.next();
                    currbal=rs.getInt(1);
            }
            catch(Exception a){
                System.out.println(a);
                JOptionPane.showMessageDialog( null, "Server error Plaese Try again");
                setVisible(false);
                new Login();
                return;
            }
            JOptionPane.showMessageDialog( null, "Your current balance is "+currbal); 

        }
        else if(e.getSource()==ministatementButton){

        }

    }
    public static void main(String[] args) {
        new Atm("123");
    }
    
}
