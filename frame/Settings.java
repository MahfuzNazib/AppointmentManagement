package frame;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import repository.*;
import entity.*;

public class Settings extends JFrame implements ActionListener

{
	private JLabel lblSettings,lblCurrent, lblContact, lblNew, lblBack;
	private JButton btnConfirm, btnRefresh, btnHome, btnLogout, btnSettings;
	private Font fntmain;
	private JTextField txtCurrent, txtNew, txtContact;
	private JPanel panel;
	private Color backColor;
	

		
		public Settings()
		
	{
		super("Appointment System");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);//Open Center Screen
		this.setResizable(false);//Cannot Resize;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
	    fntmain = new Font("Agency FB",Font.BOLD,16);
		
	    backColor = new Color(83, 126, 106);
	
	    //All btn
		
		btnHome = new JButton("Home");
	    btnHome.setBounds(730,2,70,27);
	    btnHome.setFont(fntmain);
	    btnHome.setForeground(Color.WHITE);
	    btnHome.setBackground(backColor);
	    panel.add(btnHome);
		
		
		btnSettings = new JButton("Settings");
	    btnSettings.setBounds(800,2,80,27);
		btnSettings.setFont(fntmain);
		btnSettings.setForeground(Color.WHITE);
		btnSettings.setBackground(backColor);
		//btnSettings.addMouseListener(this);
		//btnSettings.addActionListener(this);
		panel.add(btnSettings);
		
		btnLogout = new JButton("Logout");
	    btnLogout.setBounds(880,2,70,27);
		btnLogout.setFont(fntmain);
		btnLogout.setBackground(backColor);
		btnLogout.setForeground(Color.WHITE);
		//btnLogout.addMouseListener(this);
		//btnLogout.addActionListener(this);
		panel.add(btnLogout);
		
		btnConfirm = new JButton("Confirm ");
	    btnConfirm.setBounds(380,340,100,30);
		btnConfirm.setFont(fntmain);
		btnConfirm.setBackground(new Color(31,149,17));
		btnConfirm.setForeground(Color.WHITE);
		//btnConfirm.addMouseListener(this);
		//btnConfirm.addActionListener(this);
		panel.add(btnConfirm);
		
		
		btnRefresh = new JButton("Refresh");
	    btnRefresh.setBounds(500,340,100,30);
		btnRefresh.setFont(fntmain);
		btnRefresh.setBackground(new Color(47,15,174));
		btnRefresh.setForeground(Color.WHITE);
		//btnRefresh.addMouseListener(this);
		//btnRefresh.addActionListener(this);
		panel.add(btnRefresh);
		
		
		//all txt
		
		txtCurrent = new JTextField();
		txtCurrent.setBounds(420,130,260,30);
		txtCurrent.setFont(fntmain);
		panel.add(txtCurrent);
		
		txtNew = new JTextField();
		txtNew.setBounds(420,180,260,30);
		txtNew.setFont(fntmain);
		panel.add(txtNew);
		
		
		txtContact = new JTextField();
		txtContact.setBounds(420,230,260,30);
		txtContact.setFont(fntmain);
		panel.add(txtContact);
		
		
		
	//all lbl
	
	    lblSettings = new JLabel(" General Account Settings ");
		lblSettings.setBounds(430,55,250,30);
		lblSettings.setForeground(Color.BLACK);
		lblSettings.setFont(fntmain);
		panel.add(lblSettings);
		
		
	    lblCurrent = new JLabel("Current Password");
		lblCurrent.setBounds(270,130,150,30);
		lblCurrent.setForeground(Color.BLACK);
		lblCurrent.setFont(fntmain);
		panel.add(lblCurrent);
		
		lblNew = new JLabel("New Password");
		lblNew.setBounds(270,180,150,30);
		lblNew.setForeground(Color.BLACK);
		lblNew.setFont(fntmain);
		panel.add(lblNew);
		
		lblContact = new JLabel("Contact Password");
		lblContact.setBounds(270,230,150,30);
		lblContact.setForeground(Color.BLACK);
		lblContact.setFont(fntmain);
		panel.add(lblContact);
	
	
	
	    lblBack = new JLabel();
	    lblBack.setBackground(backColor);
	    lblBack.setOpaque(true);
	    lblBack.setBounds(0,0,1000,30);
	    panel.add(lblBack);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		
		String command = ae.getActionCommand();

		if(command.equals(btnHome.getText()))
		{
			Home h = new Home();
			h.setVisible(true);
			this.setVisible(false);
		}

		else if(command.equals(btnLogout.getText()))
		{
			Login l = new Login();
			//l.setVisible(true);
			this.setVisible(false);
		}
		else{} 
	}
}