import java.util.Scanner;
import com.student.manage.*;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			menu m=new menu();
			m.Menu();

	}
	public  void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE NAME OF THE STUDENT :: ");
		String stnm=sc.nextLine();
		System.out.print("ENTER THE ENROLLMENT NUMBER OF THE STUDENT :: ");
		String sten=sc.nextLine();
		sten=sten.replaceAll("\\s+","").toLowerCase();
		String[] enrolls=ConnectionMethods.enrollsArray();
		int flag=0; 
		for(int i=0;i<enrolls.length;i++) {
			String temp=enrolls[i].replaceAll("\\s+","").toLowerCase();
			if(sten.equals(temp)) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
		System.out.print("ENTER THE REGISTRATION NUMBER OF THE STUDENT :: ");
		String strg=sc.nextLine();
		strg=strg.replaceAll("\\s+","").toLowerCase();
		String[] rgnos=ConnectionMethods.regnosArray();
		int flag2=0;
		for(int i=0;i<rgnos.length;i++) {
			String temp=rgnos[i].replaceAll("\\s+","").toLowerCase();
			if(strg.equals(temp)) {
				flag2=1;
				break;
			}
		}
		if(flag2==0) {
			System.out.print("ENTER THE PHONE NUMBER OF THE STUDENT :: ");
			String stph=sc.nextLine();
			System.out.print("ENTER THE CITY OF THE STUDENT :: ");
			String stcity=sc.nextLine();
			Student st=new Student(stnm,sten,strg,stph,stcity);
			boolean result=ConnectionMethods.InsertStudentToDB(st);
			if(result) {
				System.out.println("STUDENT RECORD ADDED SUCCESSFULLY.....");
			}
			else {
				System.out.println("Something Went Wrong.......");
			}
		}
		else {
			System.out.println("THIS REGISTRATION NUMBER IS ALREADY REGISTERED....");
		}

		}
		else {
			System.out.println("THIS ENROLLMENT NUMBER IS ALREADY REGISTERED....");
		}
		
		
	}
	public void displayStudents() {
		ConnectionMethods.ShowAll();
	}
	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER YOUR ENROLLMENT NUMBER :: ");
		String Enrollstr=sc.nextLine();
		ConnectionMethods.searchRecord(Enrollstr);
	}
	public void delete(int id) {
	ConnectionMethods.delete(id);
	}
}

/***************************************************MENU****************************************************************************************************************/
class menu extends Start{
	public void Menu() {
		Scanner sc = new Scanner(System.in);
		int input;
        do {
  		  System.out.println("********************************************************************************************************************************************************");
            System.out.println("STUDENTS RECORDS ADMIN PANEL");
  		  System.out.println("********************************************************************************************************************************************************");
            System.out.println("PRESS 1 : ADD STUDENT");
            System.out.println("PRESS 2 : DELETE STUDENT");
            System.out.println("PRESS 3 : DISPLAY STUDENTS");
            System.out.println("PRESS 4 : SEARCH STUDENT");
            System.out.println("PRESS 5 : EXIT");
  		  System.out.println("********************************************************************************************************************************************************");
            System.out.print("ENTER YOUR CHOICE :: ");
            input = sc.nextInt();
            switch (input) {
                case 1: addStudent();
                    break;
                case 2: System.out.print("Enter the student id to delete :: ");
                		int id=sc.nextInt();
                		delete(id);
                    break;
                case 3: displayStudents();
                    break;
                case 4: search();
                		break;
                case 5: System.exit(0);
                case 6: ;
                		
                		break;
                default:
                    System.out.print("The entered value is unrecognized!\n");
                    break;
            }
        } while (true);
	}
}
/***********************************************************************************************************************************************************************/
