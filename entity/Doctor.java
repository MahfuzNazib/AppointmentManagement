package entity;
import java.lang.*;

public class Doctor
{
	private String docName, docGander, docDepartment, docId, docSpecialist, docMail, docContact, docAddress,docDegree,docAge,docVisitingFee;
	
	
	
	public Doctor(){}
	
	public Doctor(String docName, String docGander, String docDepartment, String docId, String docSpecialist, String docMail, String docContact, String docAddress,String docAge, String docDegree,String docVisitingFee)

   {
		//this.dId = dId;
		this.docName = docName;
		this.docGander = docGander;
		this.docDepartment = docDepartment;
		this.docId = docId;
		this.docSpecialist = docSpecialist;
		this.docMail = docMail;
		this.docAddress = docAddress;
		this.docContact = docContact;
		this.docAge = docAge;
		this.docDegree = docDegree;
		this.docVisitingFee = docVisitingFee;
		
	}
	
	/*public void setDId(String dId)
	{
		this.dId = dId;
	}*/
	public void setDocName(String docName)
	{
		this.docName = docName;
	}
	
	public void setDocGander(String docGander)
	{
		this.docGander = docGander;
	}
	
	public void setDocDepartment(String docDepartment)
	{
		this.docDepartment = docDepartment;
	}
	
	public void setDocId(String docId)
	{
		this.docId = docId;
	}
	
	public void setDocSpecialist(String docSpecialist)
	{
	   this.docSpecialist = docSpecialist;
	}
	
	public void setDocMail(String docMail)
	{
	   this.docMail = docMail;
	}
	
	public void setDocAddress(String docAddress)
	{
	   this.docAddress = docAddress;
	}
	
	public void setDocContact(String docContact)
	{
	 this.docContact = docContact;
	}
	
	public void setDocAge(String docAge)
	{
	 this.docAge = docAge;
	}
	
	public void setDocDegree(String docDegree)
	{
	 this.docDegree = docDegree;
	}

	public void setDocVisitingFee(String docVisitingFee)
	{
	 this.docVisitingFee = docVisitingFee;
	}
	
	//public String getDId(){return dId;}
	public String getDocName(){return docName;}
	public String getDocGander(){return docGander;}
	public String getDocDepartment(){return docDepartment;}
	public String getDocId(){return docId;}
	public String getDocSpecialist(){return docSpecialist;}
	public String getDocMail(){return docMail;}
	public String getDocAddress(){return docAddress;}
	public String getDocContact(){return docContact;}
	public String getDocAge(){return docAge;}
	public String getDocDegree(){return docDegree;}
	public String getDocVisitingFee(){return docVisitingFee;}
	
	
}