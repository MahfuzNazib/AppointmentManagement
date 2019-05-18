package frame;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;



public class DoctorHome extends JFrame implements ActionListener
{
 
 	JLabel lblBack,lblDocotorHome;
	JButton btnAll,btnHome,btnLogout,btnSettings,btnCheckout,btnClearAll;
	JPanel panel;
	JTable docTable1;
	Color backColor;
	Font fntmain,gfont;
	JScrollPane docTableSP1;

	String d;
	User user;
	UserRepo ur;
	DoctorRepo dr;
	
	public DoctorHome(String d)
	{
		super("Welcom Doctor");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);//Open Center Screen
		this.setResizable(false);//Cannot Resize;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	    panel = new JPanel();
		panel.setLayout(null);
		
		ur = new UserRepo();
		dr = new DoctorRepo();

		this.d = d;
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Patient Name", "Age", "ContactNo", "Address"};
		
		docTable1 = new JTable(data,head);
		docTableSP1 = new JScrollPane(docTable1);
		docTableSP1.setBounds(200, 100, 500, 350);
		docTable1.setEnabled(false);
		panel.add(docTableSP1);

		gfont = new Font("Tahoma", Font.BOLD , 15);

		lblDocotorHome = new JLabel("Docotr Home");
		lblDocotorHome.setBounds(10,0,450,30);
		lblDocotorHome.setForeground(Color.WHITE);
		lblDocotorHome.setFont(gfont);
		panel.add(lblDocotorHome);


		fntmain = new Font("Agency FB",Font.BOLD,13);
		backColor = new Color(83, 126, 106);


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

	
	    btnAll = new JButton("GetAll");
		btnAll.setBounds(300,460,120,40);
	    btnAll.addActionListener(this);
		panel.add(btnAll);

		btnCheckout = new JButton("CheckOut");
		btnCheckout.setBounds(450,460,120,40);
	    btnCheckout.addActionListener(this);
		panel.add(btnCheckout);
		
		lblBack = new JLabel();
		lblBack.setBounds(10,5,960,35);
		lblBack.setBackground(Color.GRAY);
		lblBack.setOpaque(true);
		panel.add(lblBack);
		
	    this.add(panel);
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(btnAll.getText()))
		{
			String data[][] = dr.getP(d);
			String head[] = {"Patient Name", "Age", "ContactNo", "Address"};

			panel.remove(docTableSP1);

			docTable1 = new JTable(data,head);
			docTableSP1 = new JScrollPane(docTable1);
			docTableSP1.setBounds(200, 100, 500, 350);
			docTable1.setEnabled(false);
			panel.add(docTableSP1);

			panel.revalidate();
			panel.repaint();
		}
		else if(ae.getSource()==btnLogout)
		{
			Login g1 = new Login();
			this.setVisible(false);
		}

		else if(ae.getSource()==btnHome)
		{
			Home h = new Home();
			h.setVisible(true);
			this.setVisible(false);
		}

	}
	
	
 }
		
