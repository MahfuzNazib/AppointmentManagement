package repository;
import java.lang.*;
import java.util.ArrayList;
import interfaces.*;
import entity.*;
import java.sql.*;

public class PatientHomeRepo implements IPatientHomeRepo
{
	DatabaseConnection dbc;

	public PatientHomeRepo()
	{
		dbc = new DatabaseConnection();
	}

  public void insertD(String pid,String name,String bdate)
  {
      String query = "UPDATE patientinfo SET doctorId= (SELECT `doctorId` FROM doctorinfo WHERE `fullName`='"+name+"'), date='"+bdate+"' WHERE patientid='"+pid+"';";
    //String query = "UPDATE patientinfo SET doctorId=("SELECT";)";
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

	public String[][] getAllDoctor2()
    {
      ArrayList<PatientHome> ar = new ArrayList<PatientHome>();
     String query = "SELECT `fullname`,`degree`,`specialist`,`visitingFee` FROM doctorinfo;";

    try
    {

      dbc.openConnection();
      dbc.result = dbc.st.executeQuery(query);

      while(dbc.result.next())
      {

        
        String name = dbc.result.getString("fullname");
        String degree = dbc.result.getString("degree");
        String specialist = dbc.result.getString("specialist");
        String visitingFee = dbc.result.getString("visitingFee");
        
        
        
        PatientHome ph = new PatientHome(name,degree,specialist,visitingFee);
        ar.add(ph);
      }
    }

    catch(Exception e){System.out.println(e.getMessage());}
    dbc.closeConnection();

    Object obj[] = ar.toArray();
    String data[][] = new String [ar.size()][4];

    for(int i=0;i<obj.length;i++)
    {
      data[i][0] = ((PatientHome)obj[i]).getDocName();
      data[i][1] = ((PatientHome)obj[i]).getDocDegree();
      data[i][2] = ((PatientHome)obj[i]).getDocSpecialist();
      data[i][3] = ((PatientHome)obj[i]).getDocVisitingFee();
      
    }

    return data;
    }
}