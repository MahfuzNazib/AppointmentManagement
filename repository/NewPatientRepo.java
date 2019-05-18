package repository;
import java.lang.*;
import java.util.ArrayList;
import interfaces.*;
import entity.*;
import java.sql.*;

public class NewPatientRepo //implements INewPatientRepo
{
	DatabaseConnection dbc;

	public NewPatientRepo()
	{
		dbc = new DatabaseConnection();
	}

	public String[][] getAllDoctorList()
	{
		ArrayList<NewPatient> ar = new ArrayList<NewPatient>();
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
        
        
        
         NewPatient np = new NewPatient(name,degree,specialist,visitingFee);
         ar.add(np);
      		}
		}

		catch(Exception e){System.out.println(e.getMessage());}
       dbc.closeConnection();

       Object obj[] = ar.toArray();
       String data[][] = new String [ar.size()][4];

    for(int i=0;i<obj.length;i++)
    {
      data[i][0] = ((NewPatient)obj[i]).getDocName();
      data[i][1] = ((NewPatient)obj[i]).getDocDegree();
      data[i][2] = ((NewPatient)obj[i]).getDocSpecialist();
      data[i][3] = ((NewPatient)obj[i]).getDocVisitingFee();
      
    }

    return data;
    }

}
