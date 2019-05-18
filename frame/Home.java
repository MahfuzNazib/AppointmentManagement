package frame;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import entity.*;
import repository.*;

public class Home extends JFrame implements ActionListener
{
	JButton btnHome,btnDept,btnLogin,btnContactUs;
	JLabel lblMain,lblAddress,lblImgLogo,lblImgBackend,lblNavigation;
	Font mainFont,myFont,btnFont;
	ImageIcon imgLogo,imgBackend;
	JComboBox cmboDeptList;
	Color clrButton;
	JPanel panel;

	public Home()
	{
		super("Appointment Management System-(Home)");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);//Open Center Screen
		this.setResizable(false);//Cannot Resize;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myFont = new Font("Tekton Pro Ext",Font.BOLD,20);
		clrButton = new Color(31,78,120);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		//panel.setResizable(false);

		imgLogo = new ImageIcon("appointment.png");
		lblImgLogo = new JLabel(imgLogo);
		lblImgLogo.setBounds(30,5,100,100);
		panel.add(lblImgLogo);

		lblMain = new JLabel("Appointment Management System");
		lblMain.setBounds(250,5,500,70);
		lblMain.setForeground(Color.BLACK);
		lblMain.setFont(myFont);
		panel.add(lblMain);

		btnHome = new JButton("Home");
		btnHome.setBounds(180,120,100,35);
		btnHome.setBackground(clrButton);
		btnHome.setForeground(Color.WHITE);
		panel.add(btnHome);


		String list[] = {"Departments","Dental","Neourology","Medicine","Kidny","Heart","Others"};
		cmboDeptList = new JComboBox(list);
		cmboDeptList.setBounds(340,120,100,35);
		cmboDeptList.setBackground(clrButton);
		cmboDeptList.setForeground(Color.WHITE);
		panel.add(cmboDeptList);

		btnContactUs = new JButton("ContactUs");
		btnContactUs.setBounds(480,120,100,35);
		btnContactUs.setBackground(clrButton);
		btnContactUs.setForeground(Color.WHITE);
		panel.add(btnContactUs);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(640,120,100,35);
		btnLogin.setBackground(clrButton);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(this);
		panel.add(btnLogin);



		lblNavigation = new JLabel();
		lblNavigation.setBounds(0,120,1000,35);
		lblNavigation.setBackground(Color.GRAY);
		lblNavigation.setOpaque(true);
		panel.add(lblNavigation);


		imgBackend = new ImageIcon("Screenshot_1.png");
		lblImgBackend = new JLabel(imgBackend);
		lblImgBackend.setBounds(160,120,700,600);
		panel.add(lblImgBackend);

		//Center Open Code//

		//setLocation(dim.width/2-this.getPreferredSize().width/2,dim.height/2-this.getPreferredSize().height/2);


		this.add(panel);

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		{
			if(command.equals(btnLogin.getText()))
			{
				Login l = new Login();
				l.setVisible(true);
				this.setVisible(false);
			}
		}
	}
}