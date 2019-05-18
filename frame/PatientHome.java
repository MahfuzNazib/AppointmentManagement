package frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import entity.*;
import repository.*;

public class PatientHome extends JFrame implements ActionListener
{
	
	JLabel lblSelect, lblReason, lblDate, lblTime,lblBack,pntHomePage;
	JTextField  txtDate,txtDoctor,txtReason,txtTime;
	JButton btnConfirm, btnRefresh, btnHome, btnLogout,btnGetAll,btnSettings;
	//JComboBox cmbTime, cmbDoctor, cmbReason;
	JPanel panel;
    Color backColor;
    JTable docListTable;
    JScrollPane docListSP;
	Font Font, fntmain,fntPage;
	String id;
	User user;
	UserRepo ur;
	PatientHomeRepo drp;
	
	public PatientHome (String id)
	{
		
	    super("Patient");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);//Open Center Screen
		this.setResizable(false);//Cannot Resize;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);

		ur = new UserRepo();
		drp = new PatientHomeRepo();

		this.id = id;

		String data[][] = {{"","","",""}};
		String head[] = {"Name","Degree","Specialist","Fees"};

		docListTable = new JTable(data,head);
		docListSP = new JScrollPane(docListTable);
		docListSP.setBounds(435,97,480,240);
		docListTable.setEnabled(false);
		panel.add(docListSP);
		
		Font = new Font("Consolas", Font.BOLD | Font.BOLD,12);
		fntmain = new Font("Agency FB",Font.BOLD,13);
		
	    backColor = new Color(83, 126, 106);
		
		//All Jlabel
		
		
		
		
		lblSelect = new JLabel("Select Doctor  :");
	    lblSelect.setBounds(60,100,180,30);
		//lblSelect.addMouseListener(this);
		//lblSelect.addActionListener(this);
		lblSelect.setFont(Font);
		panel.add(lblSelect);
		
		lblReason = new JLabel("Reason         :");
	    lblReason.setBounds(60,155,180,30);
		//lblReason.addMouseListener(this);
		//lblReason.addActionListener(this);
		lblReason.setFont(Font);
		panel.add(lblReason);
		
		lblDate = new JLabel("Type Your Date :");
	    lblDate.setBounds(60,215,200,30);
		//lblDate.addMouseListener(this);
		//lblDate.addActionListener(this);
		lblDate.setFont(Font);
		panel.add(lblDate);
		
		
		
		//All Button
		
		btnConfirm = new JButton("Confirm ");
	    btnConfirm.setBounds(80,380,170,40);
		btnConfirm.setFont(Font);
		btnConfirm.setBackground(new Color(31,149,17));
		btnConfirm.setForeground(Color.WHITE);
		//btnConfirm.addMouseListener(this);
		btnConfirm.addActionListener(this);
		panel.add(btnConfirm);
		
		
		btnRefresh = new JButton("Refresh");
	    btnRefresh.setBounds(260,380,160,40);
		btnRefresh.setFont(Font);
		btnRefresh.setBackground(new Color(47,15,174));
		btnRefresh.setForeground(Color.WHITE);
		//btnRefresh.addMouseListener(this);
		//btnRefresh.addActionListener(this);
		panel.add(btnRefresh);


		btnGetAll = new JButton("Get All");
		btnGetAll.setBounds(600,420,80,35);
		btnGetAll.setForeground(Color.BLACK);
		btnGetAll.addActionListener(this);
		panel.add(btnGetAll); 
		
		
		btnHome = new JButton("Home");
	    btnHome.setBounds(740,8,70,27);
	    btnHome.setFont(fntmain);
	    btnHome.setForeground(Color.WHITE);
	    btnHome.setBackground(backColor);
	    btnHome.addActionListener(this);
	    panel.add(btnHome);

	    btnSettings = new JButton("Settings");
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
		
		

		//All JTextField
		
		txtDate = new JTextField();
	    txtDate.setBounds(200,213,190,30);
		txtDate.setFont(Font);
		panel.add(txtDate);
		
		//All ComboBox
		
		txtDoctor = new JTextField();
		txtDoctor.setBounds(200, 97, 190, 30);
		txtDoctor.setFont(Font);
		panel.add(txtDoctor);
		
		
		txtReason = new JTextField();
		txtReason.setBounds(200, 153, 190, 30);
		txtReason.setFont(Font);
		panel.add(txtReason);

		lblBack = new JLabel();
		lblBack.setBounds(0,0,1000,30);
	    lblBack.setBackground(backColor);
		lblBack.setOpaque(true);
		panel.add(lblBack);
		
		this.add(panel);
		
		}
		
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(btnGetAll.getText()))
		{
			String data[][] = drp.getAllDoctor2();
			String head[] = {"Name","Degree","Specialist","Fees"};

			panel.remove(docListSP);

			docListTable = new JTable(data,head);
			docListSP = new JScrollPane(docListTable);
			docListSP.setBounds(435,97,480,240);
			docListTable.setEnabled(false);
			panel.add(docListSP);

			panel.revalidate();
			panel.repaint();
		}

		else if(command.equals(btnConfirm.getText()))
		{
			drp.insertD(id,txtDoctor.getText(),txtDate.getText());
			JOptionPane.showMessageDialog(this,"Booking is Confirmed");
			btnConfirm.setEnabled(false);
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
	}
	
}