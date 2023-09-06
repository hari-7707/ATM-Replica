import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Balance extends JFrame implements ActionListener {
    String acc_no;
    JButton ok;
    Balance(String acc_no){
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

        ok=new JButton("OK");
        ok.setBackground(Color.white);
        ok.setBounds(480, 490, 100, 30);
        ok.setFont(new Font("arial",Font.BOLD,16));
        ok.addActionListener(this);
        imagLabel.add(ok);

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
            JLabel text=new JLabel("Unable to check your balance" );
            text.setBounds(230, 400, 800, 25);
            text.setFont(new Font("arial",Font.BOLD,20));
            text.setForeground(Color.WHITE);
            imagLabel.add(text);
            JLabel txt=new JLabel("Please Try Again" );
            txt.setBounds(290, 430, 800, 25);
            txt.setFont(new Font("arial",Font.BOLD,20));
            txt.setForeground(Color.WHITE);
            imagLabel.add(txt);
            setVisible(true);
            return;
        }
        JLabel text=new JLabel("Total Balance "+currbal);
        text.setBounds(230, 420, 700, 30);
        text.setFont(new Font("arial",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        imagLabel.add(text);
        
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok){
            setVisible(false);
            new Login();
            return;
        }
       
    }
    public static void main(String[] args) {
        new Balance("123");
    }
    
}
