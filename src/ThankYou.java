import javax.swing.*;
import java.awt.*;

public class ThankYou extends JFrame{
    ThankYou() throws InterruptedException{
        setLayout(null);
        
        setSize(1020, 1020);
        setLocation(450, 0);;
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image=icon.getImage().getScaledInstance(1020, 1050, Image.SCALE_DEFAULT);
        icon=new ImageIcon(image);
        JLabel imagLabel=new JLabel(icon);
        imagLabel.setBounds(0, 0, 1020, 1050);
        add(imagLabel);
        

        JLabel text=new JLabel("Your Trancation Completed");
        text.setBounds(250, 460, 700, 30);
        text.setFont(new Font("arial",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        imagLabel.add(text);

        JLabel txt=new JLabel("Thank You !!!");
        txt.setBounds(320, 490, 700, 30);
        txt.setFont(new Font("arial",Font.BOLD,20));
        txt.setForeground(Color.WHITE);
        imagLabel.add(txt);

        setVisible(true);

        Thread.sleep(3000);
        setVisible(false);
        new Login();

    }
    public static void main(String[] args) throws InterruptedException {
        new ThankYou();
    }
}
