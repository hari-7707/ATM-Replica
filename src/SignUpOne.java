import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.*;
import javax.swing.*;

public class SignUpOne extends JFrame implements  ActionListener {
    JTextField nameTextField ,fnameTextField,emailTextField,pincodeTextField,districtTextField,stateTextField,cityTextField,mobileTextField,streetTextField;
    JButton next;
    JRadioButton marriedButton,singleButton,othersButton,femaleButton,maleButton; 
    JDateChooser dob;
    long random;
    SignUpOne(){
        setLayout(null);
        setTitle("application form one");
        setSize(820, 950);
        setLocation(600,50);
        getContentPane().setBackground(Color.WHITE);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L))+1000L;
        System.out.println(random);

        JLabel appno=new JLabel("Form No. "+random);
        appno.setBounds(640, 10, 200, 30);
        appno.setFont(new Font("OSWARD",Font.BOLD,20));
        add(appno);

        JLabel head=new JLabel("APPLICATION FORM");
        head.setBounds(190, 50, 400, 30);
        head.setFont(new Font("OSWARD",Font.BOLD,40));
        add(head);

        JLabel name=new JLabel("Name");
        name.setBounds(100, 150, 300, 30);
        name.setFont(new Font("arial",Font.BOLD,25));
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(350, 150, 300, 30);
        nameTextField.setFont(new Font("arial", Font.PLAIN,20));
        add(nameTextField);

        JLabel fathername=new JLabel("Father's Name");
        fathername.setBounds(100, 200, 300, 30);
        fathername.setFont(new Font("arial",Font.BOLD,25));
        add(fathername);

        fnameTextField=new JTextField();
        fnameTextField.setBounds(350, 200, 300, 30);
        fnameTextField.setFont(new Font("arial", Font.PLAIN,20));
        add(fnameTextField);

        JLabel dateOfBirth=new JLabel("Date Of Birth");
        dateOfBirth.setBounds(100, 250, 300, 30);
        dateOfBirth.setFont(new Font("arial",Font.BOLD,25));
        add(dateOfBirth);

        dob=new JDateChooser();
        dob.setBounds(350, 250, 300, 30);
        dob.setForeground(new Color(105, 105, 105, 105));
        dob.setFont(new Font("arial",Font.PLAIN,20));
        add(dob);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(100, 300, 300, 30);
        gender.setFont(new Font("arial",Font.BOLD,25));
        add(gender);

        maleButton=new JRadioButton("Male");
        maleButton.setBounds(350,300,100,30);
        maleButton.setFont(new Font("arial", Font.BOLD,20));
        maleButton.setBackground(Color.white);
        add(maleButton);

        femaleButton=new JRadioButton("Female");
        femaleButton.setBounds(450,300,100,30);
        femaleButton.setFont(new Font("arial", Font.BOLD,20));
        femaleButton.setBackground(Color.white);
        add(femaleButton);

        othersButton=new JRadioButton("Others");
        othersButton.setBounds(565,300,100,30);
        othersButton.setFont(new Font("arial", Font.BOLD,20));
        othersButton.setBackground(Color.white);
        add(othersButton);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(othersButton);
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel Email=new JLabel("Email");
        Email.setBounds(100, 350, 300, 30);
        Email.setFont(new Font("arial",Font.BOLD,25));
        add(Email);

        emailTextField=new JTextField();
        emailTextField.setBounds(350, 350, 300, 30);
        emailTextField.setFont(new Font("arial", Font.PLAIN,20));
        add(emailTextField);

        JLabel phoneNum=new JLabel("Mobile Number");
        phoneNum.setBounds(100, 400, 300, 30);
        phoneNum.setFont(new Font("arial",Font.BOLD,25));
        add(phoneNum);

        mobileTextField=new JTextField();
        mobileTextField.setBounds(350, 400, 300, 30);
        mobileTextField.setFont(new Font("arial", Font.PLAIN,20));
        add(mobileTextField);


        JLabel MartialStatus=new JLabel("Martial Status");
        MartialStatus.setBounds(100, 450, 300, 30);
        MartialStatus.setFont(new Font("arial",Font.BOLD,25));
        add(MartialStatus);

        singleButton=new JRadioButton("Single");
        singleButton.setBounds(350, 450,100,30);
        singleButton.setFont(new Font("arial", Font.BOLD,20));
        singleButton.setBackground(Color.white);
        add(singleButton);

        marriedButton=new JRadioButton("Married");
        marriedButton.setBounds(550,450,100,30);
        marriedButton.setFont(new Font("arial", Font.BOLD,20));
        marriedButton.setBackground(Color.white);
        add(marriedButton);

        ButtonGroup MartialStatusGroup=new ButtonGroup();
        MartialStatusGroup.add(marriedButton);
        MartialStatusGroup.add(singleButton);

        JLabel Address=new JLabel("Address");
        Address.setBounds(100, 500, 300, 30);
        Address.setFont(new Font("arial",Font.BOLD,35));
        add(Address);

        JLabel Street=new JLabel("Street");
        Street.setBounds(100, 550, 300, 30);
        Street.setFont(new Font("arial",Font.BOLD,25));
        add(Street);

        streetTextField=new  JTextField();
        streetTextField.setBounds(350, 550, 300, 30);
        streetTextField.setFont(new Font("arial", Font.PLAIN,20));
        add(streetTextField);
        
        JLabel City=new JLabel("City");
        City.setBounds(100, 600, 300, 30);
        City.setFont(new Font("arial",Font.BOLD,25));
        add(City);

        cityTextField=new JTextField();
        cityTextField.setBounds(350, 600, 300, 30);
        cityTextField.setFont(new Font("arial", Font.PLAIN,20));
        add(cityTextField);
        
        JLabel State=new JLabel("State");
        State.setBounds(100, 650, 300, 30);
        State.setFont(new Font("arial",Font.BOLD,25));
        add(State);

        stateTextField=new JTextField();
        stateTextField.setBounds(350, 650, 300, 30);
        stateTextField.setFont(new Font("arial", Font.PLAIN,20));
        add(stateTextField);

        JLabel district=new JLabel("District");
        district.setBounds(100, 700, 300, 30);
        district.setFont(new Font("arial",Font.BOLD,25));
        add(district);


        districtTextField=new JTextField();
        districtTextField.setBounds(350, 700, 300, 30);
        districtTextField.setFont(new Font("arial",Font.PLAIN,20));
        add(districtTextField);
        

        JLabel PinCode=new JLabel("Pin Code");
        PinCode.setBounds(100, 750, 300, 30);
        PinCode.setFont(new Font("arial",Font.BOLD,25));
        add(PinCode);
    

        pincodeTextField=new JTextField();
        pincodeTextField.setBounds(350, 750, 300, 30);
        pincodeTextField.setFont(new Font("arial", Font.ITALIC,20));
        add(pincodeTextField);
        

        next=new JButton("Next");
        next.setBounds(545, 820, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("arial",Font.BOLD,20));
        add(next);
        next.addActionListener(this);
        


        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String formnum=new String(random+""),
        name=nameTextField.getText(),
        fname=fnameTextField.getText(),
        gender =null,
        martialStatus=null,
        Dob=dob.getDate()+"",
        email=emailTextField.getText(),
        mobile=mobileTextField.getText(),
        street=streetTextField.getText(),
        city=cityTextField.getText(),
        state=stateTextField.getText(),
        district=districtTextField.getText(),
        pin=pincodeTextField.getText();

        if(name.length()<3){
            JOptionPane.showMessageDialog(null, "Invalid Name");
            return;
        }
        fname=fnameTextField.getText();
        if(fname.length()<3){
            JOptionPane.showMessageDialog(null, "Invalid nameFather's Name");
            return;
        }

        if(Dob.equals("null")){
            JOptionPane.showMessageDialog(null, "select DOB in from the calender");
            return;
        }
        String[] s=Dob.split(" ");
        Dob=s[1]+"-"+s[2]+"-"+s[5];
        
        if(maleButton.isSelected()){
            gender="Male";
        }
        else if(femaleButton.isSelected()){
            gender="Female";
        }
        else if(othersButton.isSelected()){
            gender="Others";
        }
        else{
            JOptionPane.showMessageDialog(null, "select your gender");
            return;
        }
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; 
        if(!email.matches(regex)){
            JOptionPane.showMessageDialog(null, "invalid Email address");
            return;
        }
        System.out.println(mobile.length());
        if(mobile.length()!=10||!mobile.matches("\\d+")){
            JOptionPane.showMessageDialog(null, "invalid Mobile Number");
            return;

        }

        if(singleButton.isSelected()){
            martialStatus="Single";
        }
        else if(marriedButton.isSelected()){
            martialStatus="Married";
        }
        else{
            JOptionPane.showMessageDialog(null, "select your Martial Status");
            return;
        }
        
        
        if(street.length()<5){
             JOptionPane.showMessageDialog(null, "street requries minimum 3 characters"); 
             return;  
        }
        if(city.length()<3){
            JOptionPane.showMessageDialog(null, "City requires minimum 3 characters"); 
             return;  
        }
        if(state.length()<3){
            JOptionPane.showMessageDialog( null, "State requires minimum 3 characters"); 
             return; 
        }
        if(district.length()<3){
            JOptionPane.showMessageDialog( null, "district requires minimum 3 characters"); 
             return;
        }
        if(!pin.matches("\\d+")||pin.length()!=6){
            JOptionPane.showMessageDialog( null, "invalid PinCode"); 
            return;
        }
        setVisible(false);
        new SignUpTwo(formnum,name,fname,gender,martialStatus,Dob,email,mobile,street,city,state,district,pin);



        


        

    }
    
 
// public static void main(String[] args) {
//     new SignUpOne();
    
//     }
}



       
