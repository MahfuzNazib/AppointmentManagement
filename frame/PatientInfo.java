package frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import repository.*;
import entity.*;

public class PatientInfo extends JFrame implements ActionListener,MouseListener
{
	JLabel lblName,lblAge,lblGander,lblContact,lblAdress,lblBack,lblAllPatientList,lblID;
	JTextField txtName,txtAge,txtGander,txtContact,txtAdress,txtID;
	JButton btnSearch,btnDelete,btnDoctor,btnPatient,btnGetAll,btnHome,btnLogout,btnSettings;
	Font myFont,txtFont,btnFont,patientListFont,fntmain;
	JComboBox cmboGander;
	Color clrDoctor,clrPatient,clrSelect,clrDelete,clrSearch,backColor;
	JTable patientTable;
	JScrollPane patientSP;
	Admin a;
	JPanel panel;

	PatientRepo pr;
	UserRepo ur;
	User user;

	public PatientInfo(Admin a)
	{
		super("Appointment Managment System-(Admin)");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);//Open Center Screen
		this.setResizable(false);//Cannot Resize;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.a = a;

		panel = new JPanel();
		panel.setLayout(null);

		pr = new PatientRepo();
		ur = new UserRepo();

		String data[][] = {{"","","","","",""}};
		String head[] = {"ID","Name","Age","Gender","Contact.","Address"};

		patientTable = new JTable(data,head);
		patientSP = new JScrollPane(patientTable);
		patientSP.setBounds(375,100,590,300);
		patientTable.setEnabled(false);
		panel.add(patientSP);

		txtFont = new Font("Times Roman New",Font.BOLD,12);
		clrSelect = new Color(18,144,54); //selected Color
		clrDoctor = new Color(114,85,162); // Doctor Button Color
		myFont = new Font("Adobe Fan Heiti Std B",Font.BOLD,15);
		btnDoctor = new JButton("Doctor Info");  //Button Doctor Info
		btnDoctor.setBounds(10,5,130,35);
		btnDoctor.setFont(myFont);
		btnDoctor.setBackground(clrDoctor);
		btnDoctor.setForeground(Color.WHITE);
		btnDoctor.addMouseListener(this);
		btnDoctor.addActionListener(this);
		panel.add(btnDoctor);

		clrPatient = new Color(25,17,81);
		btnPatient = new JButton("Patient Info");  //Button Patient Info
		btnPatient.setBounds(140,5,130,35);
		btnPatient.setFont(myFont);
		btnPatient.setBackground(clrPatient);
		btnPatient.setForeground(Color.WHITE);
		btnPatient.addMouseListener(this);
		btnPatient.addActionListener(this);
		panel.add(btnPatient);


		
		lblID = new JLabel("ID "); //Label for Name///
		lblID.setBounds(25,60,60,35);
		panel.add(lblID);

		txtID = new JTextField();
		txtID.setBounds(120,60,190,30);
		txtID.setFont(txtFont);
		panel.add(txtID);////
 



		lblName = new JLabel("Full Name"); //Label for Name
		lblName.setBounds(25,100,60,35);
		panel.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(120,100,190,30);
		txtName.setFont(txtFont);
		panel.add(txtName);
 
		lblAge = new JLabel("Age");  //Label for Age
		lblAge.setBounds(25,140,60,35);
		panel.add(lblAge);

		txtAge = new JTextField();
		txtAge.setBounds(120,140,40,30);
		txtAge.setFont(txtFont);
		panel.add(txtAge);

		lblGander = new JLabel("Gander"); //Label for Gander
		lblGander.setBounds(165,140,60,35);
		panel.add(lblGander);

		//String gander[] = {"Male","FeMale","Others"};
		txtGander = new JTextField();
		txtGander.setBounds(220,140,90,30);
		panel.add(txtGander);


		lblContact = new JLabel("Contact No");
		lblContact.setBounds(25,180,70,35);
		panel.add(lblContact);

		txtContact = new JTextField();
		txtContact.setBounds(120,180,190,30);
		txtContact.setFont(txtFont);
		panel.add(txtContact);

		lblAdress = new JLabel("Address");
		lblAdress.setBounds(25,220,70,35);
		panel.add(lblAdress);

		txtAdress = new JTextField();
		txtAdress.setBounds(120,220,190,50);
		txtAdress.setFont(txtFont);
		panel.add(txtAdress);


		clrDelete = new Color(109,35,21);
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(100,300,80,35);
		btnDelete.setBackground(clrDelete);
		btnDelete.setFont(btnFont);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.addMouseListener(this);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);

		clrSearch = new Color(1,71,71);
		btnSearch = new JButton("Search");
		btnSearch.setBounds(200,300,80,35);
		btnSearch.setBackground(clrSearch);
		btnSearch.setFont(btnFont);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.addMouseListener(this);
		btnSearch.addActionListener(this);
		panel.add(btnSearch); 

		clrSearch = new Color(1,71,71);
		btnGetAll = new JButton("Get All");
		btnGetAll.setBounds(600,420,80,35);
		btnGetAll.setBackground(clrSearch);
		btnGetAll.setFont(btnFont);
		btnGetAll.setForeground(Color.WHITE);
		btnGetAll.addMouseListener(this);
		btnGetAll.addActionListener(this);
		panel.add(btnGetAll); 

		patientListFont = new Font("Arial Black",Font.ITALIC,17);
		lblAllPatientList = new JLabel("ALL PATIENT LIST");
		lblAllPatientList.setBounds(600,60,250,40);
		lblAllPatientList.setFont(patientListFont);
		panel.add(lblAllPatientList);

		//Nevigation Bar

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

		lblBack = new JLabel();
		lblBack.setBounds(10,5,960,35);
		lblBack.setBackground(Color.GRAY);
		lblBack.setOpaque(true);
		panel.add(lblBack);

		btnDelete.setEnabled(false);

		

		this.add(panel);
		
	}

	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == btnDoctor)
		{
			btnDoctor.setBackground(clrSelect);

		}
		else if(me.getSource() == btnPatient)
		{
			btnPatient.setBackground(clrSelect);
		}
		else if(me.getSource() == btnDelete)
		{
			btnDelete.setBackground(Color.BLACK);
		}
		else if(me.getSource() == btnSearch)
		{
			btnSearch.setBackground(Color.BLACK);
		}
		else 
		{}
	}

	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == btnDoctor)
		{
			btnDoctor.setBackground(clrDoctor);
		}
		else if(me.getSource() == btnPatient)
		{
			btnPatient.setBackground(clrPatient);
		}
		else if(me.getSource() == btnDelete)
		{
			btnDelete.setBackground(clrDelete);
		}

		else if(me.getSource() == btnSearch)
		{
			btnSearch.setBackground(clrSearch);
		}
		else
		{}
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(btnDoctor.getText()))
		{
			//PatientInfo p = new PatientInfo(this);
			a.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(btnSearch.getText()))
		{
			btnDelete.setEnabled(true);
			if(!txtID.getText().equals("") || !txtID.getText().equals(null))
			{
				Patient p = pr.searchPatient(txtID.getText());
				if(p != null)
				{
					txtName.setText(p.getPName());
					txtAge.setText(p.getPAge());
					txtGander.setText(p.getPGander());
					txtContact.setText(p.getPContact());
					txtAdress.setText(p.getPAddress());
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}

		else if(command.equals(btnDelete.getText()))
		{
			
			pr.deleteInDB(txtID.getText());
			ur.deleteUser(txtID.getText());

			JOptionPane.showMessageDialog(this,"Deleted");

			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			txtGander.setText("");
			txtContact.setText("");
			txtAdress.setText("");
		}

		else if(command.equals(btnGetAll.getText()))
		{
			String data[][] = pr.getAllPatient();
			String head[] = {"ID","Name","Age","Gender","Contact.","Address"};

			panel.remove(patientSP);

			patientTable = new JTable(data,head);
			patientSP = new JScrollPane(patientTable);
			patientSP.setBounds(375,100,590,300);
			patientTable.setEnabled(false);
			panel.add(patientSP);

			panel.revalidate();
			panel.repaint();
	

		}
		else if(command.equals(btnLogout.getText()))
		{
			Login g1 = new Login();
			this.setVisible(false);
		}

		else if(command.equals(btnHome.getText()))
		{
			Home h = new Home();
			h.setVisible(true);
			this.setVisible(false);
		}

		/*else if(command.equals(btnSettings.getText()))
		{
			Setting s = new Setting();
			s.setVisible(true);
			this.setVisible(false);
		}*/


	}

}