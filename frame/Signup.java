package frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import java.sql.*;



import entity.*;
import repository.*;

public class Signup extends JFrame implements ActionListener
{
	private JLabel lblup, lblfname, lbllname, lblgender, lblage, lblcontactinfo, lbladdress,lblimage,lblimgHome,lblBack;
	private JButton btnsubmit, btnreset,btnHome,btnGetAll,btnSettings,btnLogout;
	private JTextField fnamefld, lnamefld, agefld, contactinfofld, addressfld,ganderfld;
	private JPasswordField passfld;
	//private JComboBox combobox;
	private Color colorsubmit, colorreset,backColor;
	private Font gfont, gfont2,txtFont,fntmain;
	private ImageIcon img,imgHome;
	

	Login g1;
	private JPanel panel;

	PatientRepo pr ;//= new PatientRepo();
	UserRepo ur;
	User user;
	NewPatientRepo drp;

	public Signup(Login g1)
	{
	   	super("Appointment System");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);//Open Center Screen
		this.setResizable(false);//Cannot Resize;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.g1 = g1;


		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

        pr = new PatientRepo();
        ur = new UserRepo();
        drp = new NewPatientRepo();


		gfont = new Font("Tahoma", Font.BOLD , 15);
	    gfont2 = new Font("Tahoma", Font.BOLD , 15);
	    fntmain = new Font("Agency FB",Font.BOLD,13);
	    txtFont = new Font("Times Roman New",Font.BOLD,14);

	    backColor = new Color(83, 126, 106);


        lblup = new JLabel("Patient Sign Up");
		lblup.setBounds(10,0,450,30);
		lblup.setForeground(Color.WHITE);
		lblup.setFont(gfont);
		panel.add(lblup);


		lblfname = new JLabel("Full Name");
		lblfname.setBounds(270,80,150,30);
		lblfname.setForeground(Color.BLACK);
		lblfname.setFont(gfont);
		panel.add(lblfname);

		fnamefld = new JTextField();
		fnamefld.setBounds(460,80,250,35);
		fnamefld.setFont(txtFont);
		fnamefld.setBackground(Color.WHITE);
		panel.add(fnamefld);


		lblgender = new JLabel("Gender");
        lblgender.setBounds(270,130,150,30);
        lblgender.setForeground(Color.BLACK);
		lblgender.setFont(gfont);
		panel.add(lblgender);

		ganderfld = new JTextField();
		ganderfld.setBounds(460, 130, 110, 35);
		ganderfld.setFont(txtFont);
		panel.add(ganderfld);

		lblage = new JLabel("Age");
        lblage.setBounds(580,130,60,30);
        lblage.setForeground(Color.BLACK);
		lblage.setFont(gfont);
		panel.add(lblage);

		agefld = new JTextField();
		agefld.setBounds(640,130,60,35);
		agefld.setFont(txtFont);
		agefld.setBackground(Color.WHITE);
		panel.add(agefld);


		lblcontactinfo = new JLabel("Contact No");
        lblcontactinfo.setBounds(270,180,150,30);
        lblcontactinfo.setForeground(Color.BLACK);
		lblcontactinfo.setFont(gfont);
		panel.add(lblcontactinfo);

		contactinfofld = new JTextField();
		contactinfofld.setBounds(460,180,250,35);
		contactinfofld.setFont(txtFont);
		contactinfofld.setBackground(Color.WHITE);
		panel.add(contactinfofld);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(270,230,150,30);
        lbladdress.setForeground(Color.BLACK);
		lbladdress.setFont(gfont);
		panel.add(lbladdress);

		addressfld = new JTextField();
		addressfld.setBounds(460,230,250,35);
		addressfld.setFont(txtFont);
		addressfld.setBackground(Color.WHITE);
		panel.add(addressfld);

		
		btnsubmit = new JButton("Submit");
		btnsubmit.setBounds(460,280,130,45);
		colorsubmit = new Color(16,94,32);
		btnsubmit.setBackground(colorsubmit);
		btnsubmit.setForeground(Color.WHITE);
		btnsubmit.setFont(gfont2);
   		btnsubmit.addActionListener(this);
		panel.add(btnsubmit);

		btnreset = new JButton("Reset");
		btnreset.setBounds(600,280,130,45);
		colorreset = new Color(89,25,25);
		btnreset.setBackground(colorreset);
		btnreset.setForeground(Color.WHITE);
		btnreset.setFont(gfont2);
    	btnreset.addActionListener(this);
		panel.add(btnreset);

		img = new ImageIcon("Patient.jpg");
		lblimage = new JLabel(img);
		lblimage.setBounds(5, 40, 130, 80);
		panel.add(lblimage);

		

	    

	    //Navigation Bar

	    btnHome = new JButton("Home");
	    btnHome.setBounds(740,8,70,27);
	    btnHome.setFont(fntmain);
	    btnHome.setForeground(Color.WHITE);
	    btnHome.setBackground(backColor);
	    btnHome.addActionListener(this);
	    panel.add(btnHome);

	    btnSettings = new JButton("Setting");
	    btnSettings.setBounds(810,8,70,27);
	    btnSettings.setFont(fntmain);
	    btnSettings.setForeground(Color.WHITE);
	    btnSettings.setBackground(backColor);
	    btnSettings.addActionListener(this);
	    panel.add(btnSettings);

	    btnLogout = new JButton("Logout");
	    btnLogout.setBounds(880,8,70,27);
	    btnLogout.setFont(fntmain);
	    btnLogout.setForeground(Color.WHITE);
	    btnLogout.setBackground(backColor);
	    btnLogout.addActionListener(this);
	    panel.add(btnLogout);

	    lblBack = new JLabel();
	    lblBack.setBackground(Color.BLACK);
	    lblBack.setOpaque(true);
	    lblBack.setBounds(0,5,1000,30);
	    panel.add(lblBack);


	


	    this.add(panel);
        this.setVisible(true);


	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(btnreset.getText()))
		{
			fnamefld.setText("");
			agefld.setText("");
			contactinfofld.setText("");
			addressfld.setText("");
			ganderfld.setText("");
		}
		else if(command.equals(btnsubmit.getText()))
		{
        Patient p = new Patient();
        User u = new User();

        Random rd = new Random();

        int x = rd.nextInt(9999999)+10000000;
        String id = "p-"+fnamefld.getText();
        String Password = String.valueOf(x);

        p.setPId(id);
        p.setPName(fnamefld.getText());
        p.setPGander(ganderfld.getText());
        p.setPAge(agefld.getText());
        p.setPAddress(addressfld.getText());
        p.setPContact(contactinfofld.getText());

       

        u.setUserId(id);
  		u.setPassword(x+"");
  		u.setStatus(2);

        pr.insertInDBP(p);
  		ur.insertUser(u);
  		JOptionPane.showMessageDialog(this, "Inserted, Id : "+id+" and Password: "+x);
  		
  		fnamefld.setText("");
		agefld.setText("");
		contactinfofld.setText("");
		addressfld.setText("");
		ganderfld.setText("");
    }

   
    else if(ae.getSource()==btnHome)
    	{
    		Login g1 = new Login();
			this.setVisible(false);
    	}
	}//actionPerformed
}//class
