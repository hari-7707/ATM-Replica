import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionListener;
import java.math.*;
import java.util.*;
import java.awt.event.ActionEvent;

public class SignUpTwo extends JFrame implements ActionListener{
    String custId,name,fname,gender,martialStatus,Dob,email,mobileNum,street,city,state,district,pin;
    JComboBox<String> religioncombox,categorycombox,incomecomBox,educomboBox,ocptncomBox;
    JTextField adharTextField,panTextField;
    JRadioButton svngsButton,currButton,FxedButton,recurngButton,decButton,atmYes,atmNo;

    SignUpTwo(String formnum,String name,String fname,String gender,String martialStatus,String Dob,String email,String mobileNum,String street,String city,String state,String district,String pin){

    custId=formnum;this.name=name;this.fname=fname;this.gender=gender;this.martialStatus=martialStatus;this.Dob=Dob;
    this.email=email;this.street=street;this.city=city;this.state=state;this.district=district;this.pin=pin;this.mobileNum=mobileNum;
    setLayout(null);
    setTitle("application form Two");
    setSize(820, 950);
    setLocation(600,50);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel appno=new JLabel("Form No. "+formnum);
    appno.setBounds(640, 10, 200, 30);
    appno.setFont(new Font("OSWARD",Font.BOLD,20));
    add(appno);

    JLabel head=new JLabel("ADDITIONALS DETAILS");
    head.setBounds(180, 50, 500, 30);
    head.setFont(new Font("OSWARD",Font.BOLD,40));
    add(head);

    JLabel religion=new JLabel("Religion");
    religion.setBounds(100, 150, 300, 30);
    religion.setFont(new Font("arial",Font.BOLD,25));
    add(religion);

    String religionVal[]={"select","Hindu","Muslim","Christain","Sikh","Others"};
    religioncombox=new JComboBox<>(religionVal);
    religioncombox.setBounds(350, 150, 300, 30);
    religioncombox.setFont(new Font("arial", Font.PLAIN,20));
    religioncombox.setForeground(Color.BLACK);
    religioncombox.setBackground(Color.WHITE);
    add(religioncombox);

    JLabel category=new JLabel("Catergory");
    category.setBounds(100, 200+10, 300, 30);
    category.setFont(new Font("arial",Font.BOLD,25));
    add(category);
    
    String categoryVal[]={"select","General","OBC","BC","SC","ST","Others"};
    categorycombox=new JComboBox<>(categoryVal);
    categorycombox.setBounds(350, 200+10, 300, 30);
    categorycombox.setFont(new Font("arial", Font.PLAIN,20));
    categorycombox.setForeground(Color.BLACK);
    categorycombox.setBackground(Color.WHITE);
    add(categorycombox);

    JLabel income=new JLabel("Income");
    income.setBounds(100, 250+20, 300, 30);
    income.setFont(new Font("arial",Font.BOLD,25));
    add(income);
    
    String incomeVal[]={"select","<1,00,000","<2,50,000","<5,00,000",">5,00,000+"};
    incomecomBox=new JComboBox<>(incomeVal);
    incomecomBox.setBounds(350, 250+20, 300, 30);
    incomecomBox.setForeground(new Color(105, 105, 105, 105));
    incomecomBox.setFont(new Font("arial",Font.PLAIN,20));
    incomecomBox.setForeground(Color.BLACK);
    incomecomBox.setBackground(Color.WHITE);
    add(incomecomBox);

    JLabel education=new JLabel("Education");
    education.setBounds(100, 300+30, 300, 30);
    education.setFont(new Font("arial",Font.BOLD,25));
    add(education);

    String eduVal[]={"select","Non Graduate","Under Graduate","Graduate","Post Graduate"};
    educomboBox=new JComboBox<>(eduVal);
    educomboBox.setBounds(350,300+30,300,30);
    educomboBox.setFont(new Font("arial", Font.PLAIN,20));
    educomboBox.setBackground(Color.white);
    incomecomBox.setForeground(Color.BLACK);
    add(educomboBox);

    JLabel occupation=new JLabel("Occupation");
    occupation.setBounds(100, 350+40, 300, 30);
    occupation.setFont(new Font("arial",Font.BOLD,25));
    add(occupation);
   
    String ocptionVal[]={"select","Student","Salaried","Self-Employed","Bussiness","Retired"};
    ocptncomBox=new JComboBox<>(ocptionVal);
    ocptncomBox.setBounds(350,350+40,300,30);
    ocptncomBox.setFont(new Font("arial", Font.PLAIN,20));
    ocptncomBox.setBackground(Color.white);
    ocptncomBox.setForeground(Color.BLACK);
    add(ocptncomBox);

    JLabel adharnum=new JLabel("Adhar Number");
    adharnum.setBounds(100, 400+50, 300, 30);
    adharnum.setFont(new Font("arial",Font.BOLD,25));
    add(adharnum);

    adharTextField=new JTextField();
    adharTextField.setBounds(350, 450, 300, 30);
    adharTextField.setFont(new Font("arial", Font.ITALIC,20));
    add(adharTextField);

    JLabel pannum=new JLabel("PAN Number");
    pannum.setBounds(100, 450+60, 300, 30);
    pannum.setFont(new Font("arial",Font.BOLD,25));
    add(pannum);

    panTextField=new JTextField();
    panTextField.setBounds(350, 450+60, 300, 30);
    panTextField.setFont(new Font("arial", Font.ITALIC,20));
    add(panTextField);

    JLabel AccType=new JLabel("Account Type");
    AccType.setBounds(100, 500+70, 300, 30);
    AccType.setFont(new Font("arial",Font.BOLD,25));
    add(AccType);
    svngsButton=new JRadioButton("Savings Account");
    svngsButton.setBounds(100,600+10,300,30);
    svngsButton.setFont(new Font("arial", Font.BOLD,20));
    svngsButton.setBackground(Color.white);
    add(svngsButton);

    currButton=new JRadioButton("Current Account");
    currButton.setBounds(400,600+10,300,30);
    currButton.setFont(new Font("arial", Font.BOLD,20));
    currButton.setBackground(Color.white);
    add(currButton);

    FxedButton=new JRadioButton("Fixed Deposit Account");
    FxedButton.setBounds(100,650,300,30);
    FxedButton.setFont(new Font("arial", Font.BOLD,20));
    FxedButton.setBackground(Color.white);
    add(FxedButton);

    recurngButton=new JRadioButton("Recurring Deposit Account");
    recurngButton.setBounds(400,650,300,30);
    recurngButton.setFont(new Font("arial", Font.BOLD,20));
    recurngButton.setBackground(Color.white);
    add(recurngButton);

    ButtonGroup accGroup=new  ButtonGroup();
    accGroup.add(FxedButton);
    accGroup.add(currButton);
    accGroup.add(svngsButton);
    accGroup.add(recurngButton);

    JLabel debitcard=new JLabel("Avail Debit card and ATM services");
    debitcard.setBounds(100, 700, 500, 30);
    debitcard.setFont(new Font("arial",Font.BOLD,20));
    add(debitcard);

    atmYes=new JRadioButton("YES");
    atmYes.setBounds(450,700,80,30);
    atmYes.setFont(new Font("arial", Font.BOLD,15));
    atmYes.setBackground(Color.white);
    add(atmYes);

    atmNo=new JRadioButton("NO");
    atmNo.setBounds(530,700,100,30);
    atmNo.setFont(new Font("arial", Font.BOLD,15));
    atmNo.setBackground(Color.white);
    add(atmNo);

    ButtonGroup atmGroup=new  ButtonGroup();
    atmGroup.add(atmNo);
    atmGroup.add(atmYes);


    decButton=new JRadioButton("I hereby declare that the above entered details are correct to the best of my knowledge ");
    decButton.setBounds(90, 750, 700, 30);
    decButton.setBackground(Color.WHITE);
    decButton.setForeground(Color.BLACK);
    decButton.setFont(new Font("arial",Font.BOLD,15));
    add(decButton);


    JButton submit=new JButton("Submit");
    submit.setBounds(630, 800, 100, 30);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.white);
    submit.setFont(new Font("arial",Font.BOLD,20));
    add(submit);
    submit.addActionListener(this);
    
    

    setVisible(true);
} 

public void actionPerformed(ActionEvent e){
    String religion=religioncombox.getSelectedItem()+"",
    category=categorycombox.getSelectedItem()+"",
    income=incomecomBox.getSelectedItem()+"",
    education=educomboBox.getSelectedItem()+"",
    occupation=ocptncomBox.getSelectedItem()+"",
    adhar=adharTextField.getText(),
    pan=panTextField.getText(),
    acctype=null;
    
    if(adhar.length()!=12||!adhar.matches("\\d+")){
        JOptionPane.showMessageDialog(null, "invalid Adhar Number");
        return;
    }
    if(pan.length()!=10||!pan.substring(5,10).matches("\\d+")||!pan.substring(0,5).matches("^[A-Z]*$")||!(pan.charAt(3)=='P'||pan.charAt(3)=='C'||pan.charAt(3)=='A'||pan.charAt(3)=='F'||pan.charAt(3)=='H'||pan.charAt(3)=='T')){
        JOptionPane.showMessageDialog(null, "invalid PAN Number");
        return;
    }
    if(svngsButton.isSelected()){
        acctype=svngsButton.getText();
    }
    else if(currButton.isSelected()){
        acctype=currButton.getText();

    }
    else if(FxedButton.isSelected()){
        acctype=FxedButton.getText();
    }
    else if(recurngButton.isSelected()){
        acctype=recurngButton.getText();
    }
    else {
        JOptionPane.showMessageDialog(null,"please select Account Type");
        return;
    }
    if(!decButton.isSelected()){
        JOptionPane.showMessageDialog(null,"please click Declaration button");
    }
    Cnction connnetion=new Cnction();
    try{
        
        connnetion.c.setAutoCommit(false);
        String Q1="insert into customer_info values('"+custId+"','"+name+"','"+Dob+"','"+street+"','"+city+"','"+state+"','"+pin+"','"+email+"','"+mobileNum+"','"+fname+"','"+adhar+"','"+pan+"')";
        String Q2="insert into additional_details values('"+custId+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"')";
        adhar+="0000";
        BigInteger bigInteger=new BigInteger(adhar);
        long random=new Random().nextInt(10000)+63;
        bigInteger=bigInteger.add(new BigInteger(random+""));
        
        String accno=bigInteger+"";
        String pass=new Random().nextInt( 10000)+1234+"";
        String date=new Date()+"";

        String Q3="insert into account_info values('"+accno+"','"+acctype+"','"+custId+"','active','"+date+"','0','"+pass+"')";
        connnetion.s.executeUpdate(Q1);
        connnetion.s.executeUpdate(Q2);
        connnetion.s.executeUpdate(Q3);
        try{
            connnetion.c.commit();
        }
         catch (Exception ex) {
            
        }
       
        JOptionPane.showMessageDialog(null," Your Account successfully created with"+"\nAccoount Number : "+accno+" and"+"\nPin Number : "+pass);
        setVisible(false);
        new Deposit(accno);
        return;

    }
 
    catch(Exception exception){
        System.out.println("In Try Block to Execute SQL  "+exception);
        JOptionPane.showMessageDialog(null,"Server Error please try again");
        try {
            connnetion.c.rollback();

        } catch (Exception ex) {
            
        }

    }
    setVisible(false);
    new Login();
    
}
    public static void main(String[] args) {
       new SignUpTwo(null, null, null, null, null, null, null, null, null, null, null, null, null);
    // new Login();



    }
    
    
       
}
   

