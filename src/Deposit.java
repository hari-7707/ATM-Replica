
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
public class Deposit extends JFrame implements ActionListener {
    JTextField Jamount;
    JButton deposit,cancel;
    String acc_no;
    Deposit(String acc_no){
         this.acc_no=acc_no;
        setLayout(null);
        setSize(1020, 1020);
        setLocation(450, 0);;
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image=icon.getImage().getScaledInstance(1020, 1050, Image.SCALE_DEFAULT);
        icon=new ImageIcon(image);
        JLabel imagLabel=new JLabel(icon);
        imagLabel.setBounds(0, 0, 1020, 1050);
        add(imagLabel);

        JLabel text=new JLabel("Please Enter Amount To Deposit");
        text.setBounds(230, 400, 700, 30);
        text.setFont(new Font("arial",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        imagLabel.add(text);

        Jamount=new JTextField();
        Jamount.setBounds(280, 480, 200, 40);
        Jamount.setFont(new Font("arial", Font.BOLD, 30));
        imagLabel.add(Jamount);
        Jamount.addActionListener(this);

        deposit=new JButton("Deposit");
        deposit.setBackground(Color.white);
        deposit.setBounds(425, 570, 150, 30);
        deposit.setFont(new Font("arial",Font.BOLD,15));
        deposit.addActionListener(this);
        imagLabel.add(deposit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.white);
        cancel.setBounds(425, 610, 150, 30);
        cancel.setFont(new Font("arial",Font.BOLD,16));
        cancel.addActionListener(this);
        imagLabel.add(cancel);




        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            String money=Jamount.getText();
            if((!money.matches("\\d+")||money.length()<1)){
                JOptionPane.showMessageDialog( null, "amount should be only numericals"); 
            }
            else{
                int x=Integer.parseInt(money);
                if(x<1){

                    JOptionPane.showMessageDialog( null, "amount should be greater than 1"); 
                }
                else{
                    Cnction con=new Cnction();
                    
                    try{
                        con.c.setAutoCommit(false);
                        String Q1="select total_bal from account_info where acc_no='"+acc_no+"'";
                        ResultSet rs=con.s.executeQuery(Q1);
                        rs.next();
                            System.out.println(x=rs.getInt(1));
                        
                        
                        x+=Integer.parseInt(money);
                        String Q2=" update account_info  set total_bal='"+x+"' where acc_no='"+acc_no+"' ";
                        con.s.executeUpdate(Q2);
                        String Q3="insert into  transcation_info values('"+acc_no+"','0','"+money+"','"+new Date()+"','"+x+"')";
                        con.s.executeUpdate(Q3);
                        try{
                            con.c.commit();
                        }
                        catch(Exception ex){
                        }
                    }
                    catch(Exception a){
                        System.out.print(a);
                        try{
                            con.c.rollback();
                        }
                        catch(Exception ex){
                            System.out.println(ex);

                        }
                        

                        JOptionPane.showMessageDialog( null, "Server error Plaese Try again");
                        setVisible(false);
                        new Login();
                        return;
                    }
                         
                    JOptionPane.showMessageDialog( null, "amount Deposited successfully \n current balance  "+x);
                    setVisible(false);
                    new Login();
                    return ;


                }
            }
        }
        else if(e.getSource()==cancel){
          
            setVisible(false);
            new Login();
            return;
            
        }
    }
  
    
    
    
}
