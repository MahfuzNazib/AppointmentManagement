package interfaces;
import java.lang.*;
import entity.*;

public interface IPatientHomeRepo
{
	public void insertD(String pid,String name,String bdate);
	public String[][] getAllDoctor2();
}