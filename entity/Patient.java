package entity;
import java.lang.*;

public class Patient
{
	private String pId,pName,pAge,pGander,pContact,pAddress,pPassword;

	public Patient(){}

	public Patient(String pId,String pName, String pAge, String pGander, String pContact,String pAddress)
	{
		this.pId = pId;
		this.pName = pName;
		this.pAge = pAge;
		this.pGander = pGander;
		this.pContact = pContact;
		this.pAddress = pAddress;
		
	}

	public void setPId(String pId)
	{
		this.pId = pId;
	}

	public void setPPassword(String pPassword)
	{
		this.pPassword = pPassword;
	}

	public void setPName(String pName)
	{
		this.pName = pName;
	}
	public void setPAge(String pAge)
	{
		this.pAge = pAge;
	}
	public void setPGander(String pGander)
	{
		this.pGander = pGander;
	}
	public void setPContact(String pContact)
	{
		this.pContact = pContact;
	}
	public void setPAddress(String pAddress)
	{
		this.pAddress = pAddress;
	}
	

	public String getPId(){return pId;}
	public String getPPassword(){return pPassword;}
	public String getPName(){return pName;}
	public String getPAge(){return pAge;}
	public String getPGander(){return pGander;}
	public String getPContact(){return pContact;}
	public String getPAddress(){return pAddress;}
}
	
