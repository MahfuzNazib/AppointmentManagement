package repository;

import java.lang.*;
import java.util.ArrayList;
import java.sql.*;
import entity.*;
import interfaces.*;

public class DoctorRepo implements IDoctorRepo
{

	DatabaseConnection dbc;
	
	public DoctorRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Doctor d)
	{
		String query = "INSERT INTO doctorinfo VALUES ('"+d.getDocId()+"','"+d.getDocName()+"','"+d.getDocAge()+"','"+d.getDocDepartment()+"','"+d.getDocDegree()+"','"+d.getDocSpecialist()+"','"+d.getDocVisitingFee()+"','"+d.getDocMail()+"','"+d.getDocContact()+"','"+d.getDocAddress()+"','"+d.getDocGander()+"')";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception is Occure : "+ex.getMessage());
		}
	}

	public void deleteFromDB(String docId)
	{
		String query = "DELETE from doctorinfo WHERE doctorId='"+docId+"';";

		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception is Occure : "+ex.getMessage());
		}
	}

	public void updateInDB(Doctor d)
	{
		String query = "UPDATE doctorinfo SET fullName='"+d.getDocName()+"', age='"+d.getDocAge()+"', department='"+d.getDocDepartment()+"', degree='"+d.getDocDegree()+"', specialist='"+d.getDocSpecialist()+"', visitingFee='"+d.getDocVisitingFee()+"', email='"+d.getDocMail()+"',contactNo='"+d.getDocContact()+"', address='"+d.getDocAddress()+"',gander='"+d.getDocGander()+"' WHERE doctorId='"+d.getDocId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Exception is Occure : "+ex.getMessage());
		}
	}

	public Doctor searchDoctor(String docId)
	{
		Doctor doc = null;
		//String query = "SELECT `fullName`,`age`,`department`,`degree`,`specialist`,`visitingFee`,`email`,`contactNo`,`address`,`gander` WHERE `doctorId`='"+docId+"';";
		String query = "SELECT * FROM doctorinfo WHERE doctorId='"+docId+"';";
		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				String name = dbc.result.getString("fullName");
				String age = dbc.result.getString("age");
				String department = dbc.result.getString("department");
				String degree = dbc.result.getString("degree");
				String specialist = dbc.result.getString("specialist");
				String visitingFee = dbc.result.getString("visitingFee");
				String email = dbc.result.getString("email");
				String contactNo = dbc.result.getString("contactNo");
				String address = dbc.result.getString("address");
				String gander = dbc.result.getString("gander");
				

				doc = new Doctor();
				//doc.setDocId(docId);
				doc.setDocName(name);
				doc.setDocAge(age);
				doc.setDocDepartment(department);
				doc.setDocDegree(degree);
				doc.setDocSpecialist(specialist);
				doc.setDocVisitingFee(visitingFee);
				doc.setDocMail(email);
				doc.setDocContact(contactNo);
				doc.setDocAddress(address);
				doc.setDocGander(gander);

			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception is Occure : "+ex.getMessage());
		}
		dbc.closeConnection();
		return doc;
	} 

	public String[][]getAllDoctor()
	{
		ArrayList<Doctor> ar = new ArrayList<Doctor>();
		String query = "SELECT * FROM doctorinfo;";

		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);

			while(dbc.result.next())
			{
				String id = dbc.result.getString("doctorId");
				String name = dbc.result.getString("fullName");
				String age = dbc.result.getString("age");
				String department = dbc.result.getString("department");
				String degree = dbc.result.getString("degree");
				String specialist = dbc.result.getString("specialist");
				String visitingFee = dbc.result.getString("visitingFee");
				String email = dbc.result.getString("email");
				String contactNo = dbc.result.getString("contactNo");
				String address = dbc.result.getString("address");
				String gander = dbc.result.getString("gander");
				
				Doctor d = new Doctor(id,name,age,department,degree,specialist,visitingFee,email,contactNo,address,gander);
				ar.add(d);
			}
		}

		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();

		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][11];

		for(int i=0;i<obj.length;i++)
		{
			data[i][0] = ((Doctor)obj[i]).getDocId();
			data[i][1] = ((Doctor)obj[i]).getDocName();
			data[i][2] = ((Doctor)obj[i]).getDocAge();
			data[i][3] = ((Doctor)obj[i]).getDocDepartment();
			data[i][4] = ((Doctor)obj[i]).getDocDegree();
			data[i][5] = ((Doctor)obj[i]).getDocSpecialist();
			data[i][6] = ((Doctor)obj[i]).getDocVisitingFee();
			data[i][7] = ((Doctor)obj[i]).getDocMail();
			data[i][8] = ((Doctor)obj[i]).getDocContact();
			data[i][9] = ((Doctor)obj[i]).getDocAddress();
			data[i][10] = ((Doctor)obj[i]).getDocGander();
			
		}

		return data;
	}

	public String[][] getP(String id)
    {
      ArrayList<Patient> ar = new ArrayList<Patient>();
     String query = "SELECT `patientName`,`age`,`contact`,`address` FROM patientinfo WHERE doctorId='"+id+"';";

    try
    {

      dbc.openConnection();
      dbc.result = dbc.st.executeQuery(query);

      while(dbc.result.next())
      {

        
        String name = dbc.result.getString("patientName");
        String age = dbc.result.getString("age");
        String contact = dbc.result.getString("contact");
        String address = dbc.result.getString("address");
        
        
        
        
        Patient ph = new Patient();
        ph.setPName(name);
        ph.setPAge(age);
        ph.setPContact(contact);
        ph.setPAddress(address);
        ar.add(ph);
      }
    }

    catch(Exception e){System.out.println(e.getMessage());}
    dbc.closeConnection();

    Object obj[] = ar.toArray();
    String data[][] = new String [ar.size()][4];

    for(int i=0;i<obj.length;i++)
    {
      data[i][0] = ((Patient)obj[i]).getPName();
      data[i][1] = ((Patient)obj[i]).getPAge();
      data[i][2] = ((Patient)obj[i]).getPContact();
      data[i][3] = ((Patient)obj[i]).getPAddress();
      
    }

    return data;
    }
}

