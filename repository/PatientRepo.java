package repository;

import java.lang.*;
import java.util.ArrayList;
import java.sql.*;
import entity.*;
import interfaces.*;

public class PatientRepo implements IPatientRepo
{
    DatabaseConnection dbc;

    public PatientRepo()
    {
        dbc = new DatabaseConnection();
    }

    public void insertInDBP(Patient p)
    {
      
      String query = "INSERT INTO patientinfo VALUES ('"+p.getPId()+"','"+p.getPName()+"','"+p.getPAge()+"','"+p.getPGander()+"','"+p.getPContact()+"','"+p.getPAddress()+"','"+0+"','"+0+"')";
      //String query = "INSERT INTO pinfo2 VALUES ('"+p.getPId()+"','"+p.getPName()+"','"+p.getPAge()+"','"+p.getPGander()+"','"+p.getPContact()+"','"+p.getPAddress()+"')";
      try
      {
        dbc.openConnection();
        dbc.st.execute(query);
        dbc.closeConnection();
      }
      catch(Exception ex){System.out.println(ex.getMessage());}
    }


  	public void deleteInDB(String pId)
    {
      String query = "DELETE from patientinfo WHERE patientid='"+pId+"';";
      try
      {
        dbc.openConnection();
        dbc.st.execute(query);
        dbc.closeConnection();
      }
      catch(Exception e){System.out.println(e.getMessage());}

      /*String uquery = "DELETE from login WHERE userId='"+pId+"';";
      try
      {
        dbc.openConnection();
        dbc.st.execute(uquery);
        dbc.closeConnection();
      }
      catch(Exception e){System.out.println(e.getMessage());}*////

    }

  	public void updateInDB(Patient p)
    {
      String query = "UPDATE patientinfo SET patientname='"+p.getPName()+"', age = '"+p.getPAge()+"', gender = '"+p.getPGander()+"', contact = '"+p.getPContact()+"', address = '"+p.getPAddress()+"' WHERE patientid='"+p.getPId()+"'";

      try
      {
        dbc.openConnection();
        dbc.st.executeUpdate(query);
        dbc.closeConnection();
      }
      catch(Exception ex){System.out.println(ex.getMessage());}
    }
  	public Patient searchPatient(String pId)
    {
        Patient p =null;
        String query="SELECT `patientid`,`patientname`,`age`,`gender`,`contact`,`address` FROM `patientinfo` WHERE `patientid`='"+pId+"';";
        
    try
    {
      System.out.println(query);
      dbc.openConnection();
      dbc.result = dbc.st.executeQuery(query);

      while(dbc.result.next())
      {
          String name = dbc.result.getString("patientname");
          String age = dbc.result.getString("age");
          String gender = dbc.result.getString("gender");
          String contact = dbc.result.getString("contact");
          String address = dbc.result.getString("address");

          p = new Patient();

          p.setPName(name);
          p.setPAge(age);
          p.setPGander(gender);
          p.setPContact(contact);
          p.setPAddress(address);
      }
    }
    catch(Exception ex){System.out.println(ex.getMessage());}
    dbc.closeConnection();

    return p;
    }
  	
    public String[][] getAllPatient()
    {
      ArrayList<Patient> ar = new ArrayList<Patient>();
     String query = "SELECT `patientid`,`patientname`,`age`,`gender`,`contact`,`address` FROM patientinfo;";

    try
    {
      dbc.openConnection();
      dbc.result = dbc.st.executeQuery(query);

      while(dbc.result.next())
      {
        String id = dbc.result.getString("patientid");
        String name = dbc.result.getString("patientname");
        String age = dbc.result.getString("age");
        String gander = dbc.result.getString("gender");
        String contact = dbc.result.getString("contact");
        String address = dbc.result.getString("address");
        
        
        Patient p = new Patient(id,name,age,gander,contact,address);
        ar.add(p);
      }
    }

    catch(Exception e){System.out.println(e.getMessage());}
    dbc.closeConnection();

    Object obj[] = ar.toArray();
    String data[][] = new String [ar.size()][6];

    for(int i=0;i<obj.length;i++)
    {
      data[i][0] = ((Patient)obj[i]).getPId();
      data[i][1] = ((Patient)obj[i]).getPName();
      data[i][2] = ((Patient)obj[i]).getPAge();
      data[i][3] = ((Patient)obj[i]).getPGander();
      data[i][4] = ((Patient)obj[i]).getPContact();
      data[i][5] = ((Patient)obj[i]).getPAddress();
      
      
    }

    return data;
    }
}//class
