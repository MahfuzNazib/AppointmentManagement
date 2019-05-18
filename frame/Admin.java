package frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class Admin extends JFrame implements ActionListener,MouseListener
{
	JButton btnDoctor,btnPatient,btnInsert,btnUpdate,btnDelete,btnSearch,btnHome,btnGetAll,btnSettings,btnLogout;
	JLabel lblBack,lblName,lblID,lblAge,lblGander,lblDept,lblDegree,lblSpecialist,lblConsulting,lblMail,lblContact,lblAdress,lblTo,lblFee,lblAllDoctorList;
	JTextField txtID,txtName,txtAge,txtDegree,txtSpecialist,txtConsulting,txtConsulting2,txtMail,txtContact,txtAdress,txtFee,txtGander,txtDept;
	//JComboBox cmboGander,cmboDept,cmboTime1,cmboTime2;
	Color clrDoctor,clrPatient,clrSelect,clrInsert,clrUpdate,clrDelete,clrSearch,backColor;
	Font myFont,txtFont,btnFont,doctorListFont,fntmain;
	JTable doctorTable;
	JScrollPane doctorSP;
	JPanel panelDoctor,panelPatient;

	 User user;
	 DoctorRepo dr;
	 UserRepo ur;

	public Admin()
	{
		super("Appointment Management System-(Admin)");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);//Open Center Screen
		this.setResizable(false);//Cannot Resize;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//this.user = user;

		dr = new DoctorRepo();
		ur = new UserRepo();

		panelDoctor = new JPanel();
		panelDoctor.setLayout(null);


		String data[][] = {{"","","","","","","","","","",""}};
		String head[] = {"Dept","ID","Contact","Age","Address","Degree","Gender","Specialist","Visiting","Mail","Name"};

		doctorTable = new JTable(data,head);
		doctorSP = new JScrollPane(doctorTable);
		doctorSP.setBounds(375,100,590,300);
		doctorTable.setEnabled(false);
		panelDoctor.add(doctorSP);


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
		panelDoctor.add(btnDoctor);

		clrPatient = new Color(25,17,81);
		btnPatient = new JButton("Patient Info");  //Button Patient Info
		btnPatient.setBounds(140,5,130,35);
		btnPatient.setFont(myFont);
		btnPatient.setBackground(clrPatient);
		btnPatient.setForeground(Color.WHITE);
		btnPatient.addMouseListener(this);
		btnPatient.addActionListener(this);
		panelDoctor.add(btnPatient);

		lblID = new JLabel("Doctor ID");  //Label for Doctor ID
		lblID.setBounds(25,60,60,35);
		panelDoctor.add(lblID);

		txtID = new JTextField();
		txtID.setBounds(120,60,190,30);
		txtID.setFont(txtFont);
		panelDoctor.add(txtID);

		lblName = new JLabel("Full Name"); //Label for Name
		lblName.setBounds(25,100,60,35);
		panelDoctor.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(120,100,190,30);
		txtName.setFont(txtFont);
		panelDoctor.add(txtName);
 
		lblAge = new JLabel("Age");  //Label for Age
		lblAge.setBounds(25,140,60,35);
		panelDoctor.add(lblAge);

		txtAge = new JTextField();
		txtAge.setBounds(120,140,40,30);
		txtAge.setFont(txtFont);
		panelDoctor.add(txtAge);

		lblGander = new JLabel("Gander"); //Label for Gander
		lblGander.setBounds(165,140,60,35);
		panelDoctor.add(lblGander);

		//String gander[] = {"Male","FeMale","Others"};
		txtGander = new JTextField();
		txtGander.setBounds(220,140,90,30);
		panelDoctor.add(txtGander);

		lblDept = new JLabel("Department"); //Label for Department
		lblDept.setBounds(25,180,70,35);
		panelDoctor.add(lblDept);

		//String dept[] = {"Neourologist","Dentist","Gynologist","ABC","DEF"};
		txtDept = new JTextField();
		txtDept.setBounds(120,180,190,30);
		panelDoctor.add(txtDept);

		lblDegree = new JLabel("Degree"); //Label for Degree
		lblDegree.setBounds(25,220,70,35);
		panelDoctor.add(lblDegree);

		txtDegree = new JTextField();
		txtDegree.setBounds(120,220,190,30);
		txtDegree.setFont(txtFont);
		panelDoctor.add(txtDegree);

		lblSpecialist = new JLabel("Specialist"); //Label for Specialist
		lblSpecialist.setBounds(25,260,70,35);
		panelDoctor.add(lblSpecialist);

		txtSpecialist = new JTextField();
		txtSpecialist.setBounds(120,260,190,30);
		txtSpecialist.setFont(txtFont);
		panelDoctor.add(txtSpecialist);

		

		lblFee = new JLabel("Visiting Fee");
		lblFee.setBounds(25,300,70,35);
		panelDoctor.add(lblFee);

		txtFee = new JTextField();
		txtFee.setBounds(120,300,190,30);
		txtFee.setFont(txtFont);
		panelDoctor.add(txtFee);



		lblMail = new JLabel("E-Mail");
		lblMail.setBounds(25,340,70,35);
		panelDoctor.add(lblMail);

		txtMail = new JTextField();
		txtMail.setBounds(120,340,190,30);
		txtMail.setFont(txtFont);
		panelDoctor.add(txtMail);

		lblContact = new JLabel("Contact No");
		lblContact.setBounds(25,380,70,35);
		panelDoctor.add(lblContact);

		txtContact = new JTextField();
		txtContact.setBounds(120,380,190,30);
		txtContact.setFont(txtFont);
		panelDoctor.add(txtContact);

		lblAdress = new JLabel("Address");
		lblAdress.setBounds(25,420,70,35);
		panelDoctor.add(lblAdress);

		txtAdress = new JTextField();
		txtAdress.setBounds(120,420,190,50);
		txtAdress.setFont(txtFont);
		panelDoctor.add(txtAdress);

		btnFont = new Font("Tahome",Font.BOLD,13);
		clrInsert = new Color(5,124,39);
		btnInsert = new JButton("Insert");
		btnInsert.setBounds(25,480,80,35);
		btnInsert.setBackground(clrInsert);
		btnInsert.setFont(btnFont);
		btnInsert.setForeground(Color.WHITE);
		btnInsert.addMouseListener(this);
		btnInsert.addActionListener(this);
		panelDoctor.add(btnInsert);

		clrUpdate = new Color(13,50,155);
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(110,480,80,35);
		btnUpdate.setBackground(clrUpdate);
		btnUpdate.setFont(btnFont);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.addMouseListener(this);
		btnUpdate.addActionListener(this);
		panelDoctor.add(btnUpdate);

		clrDelete = new Color(109,35,21);
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(200,480,80,35);
		btnDelete.setBackground(clrDelete);
		btnDelete.setFont(btnFont);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.addMouseListener(this);
		btnDelete.addActionListener(this);
		panelDoctor.add(btnDelete);

		clrSearch = new Color(1,71,71);
		btnSearch = new JButton("Search");
		btnSearch.setBounds(290,480,80,35);
		btnSearch.setBackground(clrSearch);
		btnSearch.setFont(btnFont);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.addMouseListener(this);
		btnSearch.addActionListener(this);
		panelDoctor.add(btnSearch); 

		clrSearch = new Color(1,71,71);
		btnGetAll = new JButton("Get All");
		btnGetAll.setBounds(600,420,80,35);
		btnGetAll.setBackground(clrSearch);
		btnGetAll.setFont(btnFont);
		btnGetAll.setForeground(Color.WHITE);
		btnGetAll.addMouseListener(this);
		btnGetAll.addActionListener(this);
		panelDoctor.add(btnGetAll); 

		//All Doctor List

		doctorListFont = new Font("Arial Black",Font.ITALIC,17);
		lblAllDoctorList = new JLabel("ALL DOCTOR LIST");
		lblAllDoctorList.setBounds(600,60,250,40);
		lblAllDoctorList.setFont(doctorListFont);
		panelDoctor.add(lblAllDoctorList);


		

		//**********Navigation
		fntmain = new Font("Agency FB",Font.BOLD,13);
		
		backColor = new Color(83, 126, 106);
		
		
		
		
		btnHome = new JButton("Home");
	    btnHome.setBounds(740,8,70,27);
	    btnHome.setFont(fntmain);
	    btnHome.setForeground(Color.WHITE);
	    btnHome.setBackground(backColor);
	    btnHome.addActionListener(this);
	    panelDoctor.add(btnHome);

	    btnSettings = new JButton("Setting");
	    btnSettings.setBounds(810,8,70,27);
	    btnSettings.setFont(fntmain);
	    btnSettings.setForeground(Color.WHITE);
	    btnSettings.setBackground(backColor);
	    btnSettings.addActionListener(this);
	    panelDoctor.add(btnSettings);

	    btnLogout = new JButton("Logout");
	    btnLogout.setBounds(880,8,70,27);
	    btnLogout.setFont(fntmain);
	    btnLogout.setForeground(Color.WHITE);
	    btnLogout.setBackground(backColor);
	    btnLogout.addActionListener(this);
	    panelDoctor.add(btnLogout);
	    

	    lblBack = new JLabel();
		lblBack.setBounds(10,5,960,35);
		lblBack.setBackground(Color.GRAY);
		lblBack.setOpaque(true);
		panelDoctor.add(lblBack);
		
		
		
		this.add(panelDoctor);
		//this.setVisible(true);
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

		else if(me.getSource() == btnInsert)
		{
			btnInsert.setBackground(Color.BLACK);
		}
		else if(me.getSource() == btnUpdate)
		{
			btnUpdate.setBackground(Color.BLACK);
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

		else if(me.getSource() == btnInsert)
		{
			btnInsert.setBackground(clrInsert);
		}

		else if(me.getSource() == btnUpdate)
		{
			btnUpdate.setBackground(clrUpdate);
		}

		else if(me.getSource() == btnDelete)
		{
			btnDelete.setBackground(clrDelete);
		}

		else if(me.getSource() == btnSearch)
		{
			btnSearch.setBackground(clrSearch);
		}

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(btnPatient.getText()))
		{
			PatientInfo p = new PatientInfo(this);
			p.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(btnInsert.getText()))
		{
			Doctor d = new Doctor();
			User u = new User();
			Random rd = new Random();

			int x = rd.nextInt(9999999)+10000000;

			d.setDocId(txtID.getText());
			d.setDocName(txtName.getText());
			d.setDocAge(txtAge.getText());
			d.setDocGander(txtGander.getText());
			d.setDocDepartment(txtDept.getText());
			d.setDocDegree(txtDegree.getText());
			d.setDocSpecialist(txtSpecialist.getText());
			d.setDocVisitingFee(txtFee.getText());
			d.setDocMail(txtMail.getText());
			d.setDocContact(txtContact.getText());
			d.setDocAddress(txtAdress.getText());


			u.setUserId(txtID.getText());
			u.setPassword(x+"");
			u.setStatus(1);

			dr.insertInDB(d);
			ur.insertUser(u);
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+txtID.getText()+"and Password: "+x);

			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			txtGander.setText("");
			txtDept.setText("");
			txtDegree.setText("");
			txtSpecialist.setText("");
			txtFee.setText("");
			txtMail.setText("");
			txtContact.setText("");
			txtAdress.setText("");
		}	

		else if(command.equals(btnSearch.getText()))
		{
			if(!txtID.getText().equals("") || !txtID.getText().equals(null))
			//if(!txtID.getText().equals("") || !txtID.getText().equals(null))
			{
				Doctor d = dr.searchDoctor(txtID.getText());
				if(d != null)
				{
					txtName.setText(d.getDocName());
					txtAge.setText(d.getDocAge());
					txtGander.setText(d.getDocGander());
					txtDept.setText(d.getDocDepartment());
					txtDegree.setText(d.getDocDegree());
					txtSpecialist.setText(d.getDocSpecialist());
					txtFee.setText(d.getDocVisitingFee());
					txtMail.setText(d.getDocMail());
					txtContact.setText(d.getDocContact());
					txtAdress.setText(d.getDocAddress());
				}
				/*else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}*/
			}
		}

		else if(command.equals(btnUpdate.getText()))
		{
			Doctor d = new Doctor();
			
			d.setDocId(txtID.getText());
			d.setDocName(txtName.getText());
			d.setDocAge(txtAge.getText());
			d.setDocDepartment(txtDept.getText());
			d.setDocDegree(txtDegree.getText());
			d.setDocSpecialist(txtSpecialist.getText());
			d.setDocVisitingFee(txtFee.getText());
			d.setDocMail(txtMail.getText());
			d.setDocContact(txtContact.getText());
			d.setDocAddress(txtAdress.getText());
			d.setDocGander(txtGander.getText());
			
			

			dr.updateInDB(d);

			JOptionPane.showMessageDialog(this, "Updated");

			txtName.setText("");
			txtAge.setText("");
			txtGander.setText("");
			txtDept.setText("");
			txtDegree.setText("");
			txtSpecialist.setText("");
			txtFee.setText("");
			txtMail.setText("");
			txtContact.setText("");
			txtAdress.setText("");
		}

		else if(command.equals(btnDelete.getText()))
		{
			dr.deleteFromDB(txtID.getText());
			ur.deleteUser(txtID.getText());

			JOptionPane.showMessageDialog(this,"Deleted");

			txtID.setText("");
			txtName.setText("");
			txtAge.setText("");
			txtGander.setText("");
			txtDept.setText("");
			txtDegree.setText("");
			txtSpecialist.setText("");
			txtFee.setText("");
			txtMail.setText("");
			txtContact.setText("");
			txtAdress.setText("");
		}

		else if(command.equals(btnGetAll.getText()))
		{
			String data[][] = dr.getAllDoctor();
			String head[] = {"Dept","ID","Contact","Age","Address","Degree","Gender","Specialist","Visiting","Mail","Name"};

			panelDoctor.remove(doctorSP);

			doctorTable = new JTable(data,head);
			doctorSP = new JScrollPane(doctorTable);
			doctorSP.setBounds(375,100,590,300);
			doctorTable.setEnabled(false);
			panelDoctor.add(doctorSP);

			panelDoctor.revalidate();
			panelDoctor.repaint();
	

		}

		else if(command.equals(btnHome.getText()))
		{
			Login g1 = new Login();
			this.setVisible(false);
			//g1.setVisible(true);
		}


		
	}
}
