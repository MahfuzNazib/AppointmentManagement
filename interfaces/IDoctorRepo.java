package interfaces;

import java.lang.*;
import entity.*;

public interface IDoctorRepo
{
	public void insertInDB(Doctor d);
	public void deleteFromDB(String docId);
	public void updateInDB(Doctor d);
	public Doctor searchDoctor(String docId);
	public String[][] getAllDoctor();
	public String[][] getP(String id);

}