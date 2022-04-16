import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.InputMismatchException;

public class Main {
    static List<Student> student = new ArrayList<>();
    static Scanner inputString = new Scanner(System.in);
    static Scanner inputInt = new Scanner(System.in);

    public void showOperation() {
        System.out.println("-----------");
        System.out.println("[1] INSERT");
        System.out.println("[2] DISPLAY");
        System.out.println("[3] SEARCH");
        System.out.println("[4] DELETE");
        System.out.println("[5] UPDATE");
        System.out.println("[6] EXIT");
        System.out.print("Enter your choice: ");
    }

    // addStudent method adds a student to the List
    public void addStudent() {
        int studentID;

        try {
            System.out.print("Enter student ID: ");
            studentID = inputInt.nextInt();

            System.out.print("Enter first name: ");
            String firstName = inputString.nextLine();

            System.out.print("Enter last name: ");
            String lastName = inputString.nextLine();

            System.out.print("Enter course: ");
            String course = inputString.nextLine();

            student.add(new Student(studentID, firstName, lastName, course));
        } catch(InputMismatchException e) {
            System.out.println("Invalid Input!");
            inputInt.next();
        }
    }

    public void displayStudent(){
        Iterator<Student> i = student.iterator();
        while(i.hasNext()){
            Student e = i.next();
            System.out.println(e);
        }
    }

    /* searchStudent method search a student from the List
       base from its studentID */
    public void searchStudent() {
        Iterator<Student> i = student.iterator();
        boolean found = false;
        int studentID = 0;

        try {
            System.out.print("Enter studentID to Search: ");
            studentID = inputInt.nextInt();

            while(i.hasNext()){
                Student e = i.next();
                if(e.getStudentID() == studentID) {
                    System.out.println(e);
                    found = true;
                }
            }

            if(!found) {
                System.out.println("Record Not Found");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input!");
            inputInt.next();
        }
    }
    
    // updateStudent method update a student's name and course 
    public void updateStudent(){
        ListIterator<Student> li = student.listIterator();
        boolean found = false;
        int studentID;

        try {
            System.out.print("Enter studentID to Update: ");
            studentID = inputInt.nextInt();

            while(li.hasNext()){
                Student e = li.next();
                if(e.getStudentID() == studentID) {

                    System.out.print("Enter new first name: ");
                    String firstName = inputString.nextLine();

                    System.out.print("Enter new last name: ");
                    String lastName = inputString.nextLine();

                    System.out.print("Enter new course: ");
                    String course = inputString.nextLine();

                    li.set(new Student(studentID, firstName, lastName, course));
                    found = true;
                }
            }
            if(!found) {
                System.out.println("Record Not Found");
            } else {
                System.out.println("Record is Updated Sucessfully...!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input!");
            inputInt.next();
        }
    }

    // deleteStudent method removes a student from the List
    public void deleteStudent(){
            Iterator<Student> i = student.iterator();
            boolean found = false;

            try {
                System.out.print("Enter studentID to Delete: ");
                int studentID = inputInt.nextInt();

                while(i.hasNext()){
                    Student e = i.next();
                    if(e.getStudentID() == studentID) {
                        i.remove();
                        found = true;
                    }
                }
    
                if(!found) {
                    System.out.println("Record Not Found");
                } else {
                    System.out.println("Record is Deleted Sucessfully...!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                inputInt.next();
            }
    }


    public static void main(String[] args) {
        student.add(new Student(1101, "Reyjel", "Tabucanon", "BSIT"));
        student.add(new Student(1102, "Francene", "Lagajino", "BSIT"));
        student.add(new Student(1103, "Rommel", "Bailon", "BSIT"));        
        student.add(new Student(1104, "Danielle", "Gealone", "BSIT"));
        student.add(new Student(1105, "Lois", "Gonzales", "BSIT"));
        student.add(new Student(1106, "Christelle", "Badal", "BSIT"));
        student.add(new Student(1107, "Ceilo", "Gabotero", "BSIT"));

        Main mainObj = new Main();
        String ch;

        do{
            mainObj.showOperation();
            ch = inputString.nextLine();
            System.out.println("-----------");

            switch(ch) {
                case "1":
                    mainObj.addStudent();
                break;

                case "2":
                    mainObj.displayStudent();
                break;
                
                case "3":
                    mainObj.searchStudent();
                break;

                case "4":
                    mainObj.deleteStudent();
                break;

                case "5":
                    mainObj.updateStudent();
                break;

                case "6":
                    System.out.println("Program terminated");
                    System.exit(0);
                break;
            }

        }while(ch != "6");
        
    }   
}
