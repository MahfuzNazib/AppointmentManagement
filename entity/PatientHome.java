package entity;
import java.lang.*;

public class PatientHome
{
	private String dname,dspecialist,ddegree,dfrees;

	public PatientHome(){}
	public PatientHome(String dname,String ddegree, String dspecialist,String dfrees)
	{
		this.dname = dname;
		this.ddegree = ddegree;
		this.dspecialist = dspecialist;
		this.dfrees = dfrees;
	}

	public void setDocName(String dname){this.dname = dname;}
	public void setDocDegree(String ddegree){this.ddegree = ddegree;}
	public void setDocSpecialist(String dspecialist){this.dspecialist = dspecialist;}
	public void setDocVisitingFee(String dfrees){this.dfrees = dfrees;}

	public String getDocName(){return dname;}
	public String getDocDegree(){return ddegree;}
	public String getDocSpecialist(){return dspecialist;}
	public String getDocVisitingFee(){return dfrees;}
}