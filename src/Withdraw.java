import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class Withdraw extends JFrame implements ActionListener {
    JButton withdrawButton,canButton;
    JTextField Jamount;
    String acc_no;
    Withdraw(String acc_no){
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
        JLabel text=new JLabel("Please Enter Amount To Withdraw");
        text.setBounds(230, 400, 700, 30);
        text.setFont(new Font("arial",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        imagLabel.add(text);

        Jamount=new JTextField();
        Jamount.setBounds(280, 480, 200, 40);
        Jamount.setFont(new Font("arial", Font.BOLD, 30));
        imagLabel.add(Jamount);
        Jamount.addActionListener(this);

        withdrawButton=new JButton("Withdraw");
        withdrawButton.setBackground(Color.white);
        withdrawButton.setBounds(425, 570, 150, 30);
        withdrawButton.setFont(new Font("arial",Font.BOLD,15));
        withdrawButton.addActionListener(this);
        imagLabel.add(withdrawButton);

        canButton=new JButton("Cancel");
        canButton.setBackground(Color.white);
        canButton.setBounds(425, 610, 150, 30);
        canButton.setFont(new Font("arial",Font.BOLD,16));
        canButton.addActionListener(this);
        imagLabel.add(canButton);
        setVisible(true);

    }
    // public static void main(String[] args) {
    //     new Withdraw("112");
    // }
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==withdrawButton){
            int money=0,currbal=0;
            try{
                money=Integer.parseInt(Jamount.getText());

            }
            catch(Exception exp){
                JOptionPane.showMessageDialog( null, "invalid amount"); 
                return;
            }
            if(money<1){
                JOptionPane.showMessageDialog( null, "amount should be greater than 1"); 
            }
            
            else{
                Cnction con=new Cnction();
                
                try{
                    con.c.setAutoCommit(false);
                    String Q1="select total_bal from account_info where acc_no='"+acc_no+"'";
                    ResultSet rs=con.s.executeQuery(Q1);            
                    rs.next();
                    currbal=rs.getInt(1);
                   
                    if(money>=currbal){
                        JOptionPane.showMessageDialog( null, "insufficient funds");
                        setVisible(false);
                        new Atm(acc_no);
                        return ;
                    }
                    currbal-=money;
                    String Q2=" update account_info  set total_bal='"+currbal+"' where acc_no='"+acc_no+"' ";
                    con.s.executeUpdate(Q2);
                    String Q3="insert into  transcation_info values('"+acc_no+"','"+money+"','"+0+"','"+new Date()+"','"+currbal+"')";
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
                         
                    JOptionPane.showMessageDialog( null, "amount withdrawed successfully \n current balance  "+currbal);
                    setVisible(false);
                    new Login();
                    return;


                }
            }
        
        else if(e.getSource()==canButton){
          
            setVisible(false);
            new Atm(acc_no);
            return;
            
        }
        
    }

    
}
