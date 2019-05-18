package frame;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import entity.*;
import repository.*;


public class Login extends JFrame implements ActionListener
{
	private JLabel lblupper, lblupper2, lbllower, lblun, lblpass, lblimg,lblimgshow;
	private JTextField txtfld;
	private JPasswordField passfld;
	private JButton btnlgn, btnsgnup;
	private ImageIcon img,imgshow;
	private Font gfont, gfont2;
	private Color colorlgn, colorsgnup;
	//private CheckBox show;
	private JPanel panel;
	Signup g2;


	
	public Login()
	{
		super("Appointment System");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);//Open Center Screen
		this.setResizable(false);//Cannot Resize;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		gfont = new Font("Tahoma", Font.BOLD ,14);
		
		gfont2 = new Font("Tahoma", Font.BOLD , 10);
		
		lblupper = new JLabel("Login with your");
		lblupper.setBounds(500,150,360,60);
		lblupper.setForeground(Color.BLACK);
		lblupper.setFont(gfont2);
		panel.add(lblupper);
		
		lblupper2 = new JLabel("Desire UserName & Password");
		lblupper2.setBounds(480,170,330,60);
		lblupper2.setForeground(Color.BLACK);
		lblupper2.setFont(gfont2);
		panel.add(lblupper2);
		
		
		lblun = new JLabel("Username");
		lblun.setBounds(290,230,180,30);
		lblun.setForeground(Color.BLACK);
		lblun.setFont(gfont);
		panel.add(lblun);
		
		lblpass = new JLabel("Password");
		lblpass.setBounds(290,290,180,30);
		lblpass.setForeground(Color.BLACK);
		lblpass.setFont(gfont);
		panel.add(lblpass);
		
		
		txtfld = new JTextField();
		txtfld.setBounds(420,230,260,35);
		txtfld.setBackground(Color.WHITE);
		txtfld.setFont(gfont);
		panel.add(txtfld);
		
		passfld = new JPasswordField();
		passfld.setBounds(420,290,260,35);
		passfld.setFont(gfont);
		passfld.setEchoChar('*');
		panel.add(passfld);

		btnlgn = new JButton("Login");
		btnlgn.setBounds(420,350,110,40);
		colorlgn = new Color(71,6,114);
		btnlgn.setBackground(colorlgn);
		btnlgn.setForeground(Color.WHITE);
		btnlgn.setFont(gfont);
		btnlgn.addActionListener(this);
		panel.add(btnlgn);
		
		btnsgnup = new JButton("SignUp");
		btnsgnup.setBounds(570,350,110,40);
		colorsgnup = new Color(18,107,101);
		btnsgnup.setBackground(colorsgnup);
		btnsgnup.setForeground(Color.WHITE);
		btnsgnup.setFont(gfont);
		btnsgnup.addActionListener(this);
		panel.add(btnsgnup);
		
		img = new ImageIcon("UserIcon.jpg");
		lblimg = new JLabel(img);
		lblimg.setBounds(370, 100, 130, 150);
		panel.add(lblimg);
		
		this.add(panel);
		this.setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		

		if(command.equals(btnlgn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(txtfld.getText(),passfld.getText());

			/*if(user.getStatus() == 0)
			{
				Admin ad = new Admin();
				ad.setVisible(true);
				this.setVisible(false);
			}*/

			 

			//admin Longin

			//doctor Login

			if(user.getStatus() == 1)
			{
				DoctorHome dh = new DoctorHome(txtfld.getText());
				dh.setVisible(true);
				this.setVisible(false);
			}

			else if(user.getStatus() == 0)
			{
				Admin ad = new Admin();
				ad.setVisible(true);
				this.setVisible(false);
			}

			else if(user.getStatus() == 2)
			{
				PatientHome ph = new PatientHome(txtfld.getText());
				ph.setVisible(true);
				this.setVisible(false);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
		}
		else if(command.equals(btnsgnup.getText()))
		{
			g2 = new Signup(this);
			this.setVisible(false);
			
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Invalid UserId or Password");
		}


		
		
	}
	
}