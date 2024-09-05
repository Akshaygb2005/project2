import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Maps{
    Map<String,Map<String, Double>> studentinfo = new HashMap<>();
    Map<String, Double> subjectsInfo = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    
        protected void addStudent(){ //adding student name
            System.out.println("Enter Student name : ");
            String Studentname = sc.nextLine();
            studentinfo.put(Studentname, new HashMap<>());
            System.out.println();
            System.out.println("Name added Successfully!!.......................");
            System.out.println();
        }
        protected void addSubGrade() { // adding subject and marks 
            System.out.println("Enter student name: ");
            String studentName = sc.nextLine();
            if (studentinfo.containsKey(studentName)) {
                Map<String, Double> subjectsInfo = studentinfo.get(studentName);
                System.out.println("Enter number of subjects: ");
                int numSubjects = sc.nextInt();
                sc.nextLine();
        
                for (int i = 0; i < numSubjects; i++) {
                    System.out.println("Enter Subject and marks separated by a space:");
                    String[] info = sc.nextLine().split(" ");
                    
                    if (info.length == 2) { // Ensure there are exactly two elements
                        String subject = info[0];
                        try {
                            double marks = Double.parseDouble(info[1]);
                            subjectsInfo.put(subject, marks);
                            System.out.println();
                            System.out.println("Subject and marks added successfully!...................");
                            System.out.println();
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid marks format. Please enter a valid number............");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid input format. Please enter subject and marks separated by a space...................");
                        System.out.println();
                    }
                }
                studentinfo.put(studentName, subjectsInfo); 
            } else {
                System.out.println("Student not found!");
                System.out.println();
            }
        }
        protected void updategrade(){ //to change subject marks
            System.out.println("Enter student name: ");
            String studentName = sc.nextLine();
            
                if (studentinfo.containsKey(studentName)){
                    Map<String, Double> subjectsInfo = studentinfo.get(studentName);
                    System.out.println("Enter subject name");
                    String subjname = sc.nextLine();
                    if (subjectsInfo.containsKey(subjname)){
                        System.out.println("Enter new marks");
                        double newmarks = sc.nextDouble();
                        sc.nextLine();
                        subjectsInfo.put(subjname,newmarks);
                        System.out.println("Grade updated successfully!..................");
                        System.out.println();
                    } else {
                        System.out.println("Invalid Subject name.........");
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid student name........");
                    System.out.println();
                } 
        }
        protected void deletesub(){ //delete subject
            if (studentinfo.isEmpty()){
                System.out.println(" No Data found...........");
                System.out.println();
            }
            else{
                    System.out.println("Enter Student name : ");
                    String studentname = sc.nextLine();
                    if(studentinfo.containsKey(studentname)){
                        Map<String, Double> subjectsInfo = studentinfo.get(studentname);
                        System.out.println("Enter Subject name to delete :");
                        String subname = sc.nextLine();
                        if(subjectsInfo.containsKey(subname)){
                            subjectsInfo.remove(subname);
                            System.out.println(" Subject deleted Successfully!...................");
                            System.out.println();
                        } else {System.out.println("Subject not found..............");
                            System.out.println();
                        }
                    } else {
                        System.out.println(" Student not found..............");
                        System.out.println();
                    }
            }
        }
        protected void displayinfo(){
            if (studentinfo.isEmpty()){
                System.out.println(" No Data found...........");
                System.out.println();
            }
            else{
            for(Map.Entry< String, Map< String, Double>> OuterMapEntry : studentinfo.entrySet()){
                String name = OuterMapEntry.getKey();
                Map< String, Double> duplicate = OuterMapEntry.getValue();
                System.out.println("Student name : "+name);
                if (duplicate != null && !duplicate.isEmpty()) { 
                    double total = 0;
                    for(Map.Entry<String, Double> InnerMapEntry : duplicate.entrySet()){
                        String subject = InnerMapEntry.getKey();
                        double marks = InnerMapEntry.getValue();
                        System.out.println("Subject = "+subject+" : "+"Marks = "+marks);
                        total += marks;                       
                    }
                    double avg = total/duplicate.size();
                    System.out.println("Average : "+avg);
                    System.out.println();
                } else {
                    System.out.println("No Subject found for this Student...............");
                    System.out.println();
                }
            }    
        }  
    }
}
public class StudentGrade {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dff = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("a");
        String date = d.format(dff);
        String s = dt.format(df);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(date);
        if(s.equals("am")){
            System.out.println("GOOD MORNING!!........");
            System.out.println();} else {
            System.out.println("GOOD EVENING!!.........");
            System.out.println();}

        Maps m = new Maps();
        int option;
        do{
            
            System.out.println("Students grade manager Menu");
            System.out.println("1. Add Student\n2. Add Subject and grade\n3. Update grade\n4. Delete subject\n5. Display information\n6. Exit");
            Scanner sc = new Scanner(System.in);
            System.out.println("Select options : ");
            option = sc.nextInt();
            System.out.println();    
            switch (option) {
                case 1:
                    m.addStudent();
                    break;
                case 2:
                    m.addSubGrade();
                    break;
                case 3:
                    m.updategrade();
                    break;
                case 4:
                    m.deletesub();
                    break;
                case 5:
                    m.displayinfo();
                    break;
                case 6:
                System.out.println("......................... Thank You.............................");
                    break;
                default:
                    System.out.println("Invalid option. Please select valid option.........");
                    System.out.println();
                    break;
            }
        }while (option !=6);         
    }
}
