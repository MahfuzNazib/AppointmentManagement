package interfaces;
import java.lang.*;
import entity.*;

public interface IPatientRepo
{
	public void insertInDBP(Patient p);
	public void deleteInDB(String pId);
	public void updateInDB(Patient p);
	public Patient searchPatient(String pId);
	public String[][] getAllPatient();
}
