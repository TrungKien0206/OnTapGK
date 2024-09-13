
package ontapgiuaki;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    private static StudentList studentList = new StudentList();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    updateStudentById();
                    break;
                case 3:
                    deleteStudentById();
                    break;
                case 4:
                    studentList.displayAllStudents();
                    break;
                case 5:
                    findTopStudent();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add a new student
    public static void addNewStudent() throws ParseException {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        String dobStr = scanner.nextLine();
        Date dateOfBirth = dateFormat.parse(dobStr);
        System.out.print("Enter GPA: ");
        float gpa = scanner.nextFloat();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Major: ");
        String major = scanner.nextLine();

        Student student = new Student(id, fullName, dateOfBirth, gpa, major);
        studentList.addStudent(student);
    }

    // Update a student by ID
    public static void updateStudentById() throws ParseException {
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();
        Student student = studentList.findStudentById(id);

        if (student != null) {
            System.out.print("Enter new Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
            String dobStr = scanner.nextLine();
            Date dateOfBirth = dateFormat.parse(dobStr);
            System.out.print("Enter new GPA: ");
            float gpa = scanner.nextFloat();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter new Major: ");
            String major = scanner.nextLine();

            student.setFullName(fullName);
            student.setDateOfBirth(dateOfBirth);
            student.setGpa(gpa);
            student.setMajor(major);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete a student by ID
    public static void deleteStudentById() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        studentList.deleteStudentById(id);
    }

    // Find the top student by GPA
    public static void findTopStudent() {
        Student topStudent = studentList.findTopStudent();
        if (topStudent != null) {
            System.out.println("Top Student:");
            topStudent.displayInfo();
        } else {
            System.out.println("No students found.");
        }
    }
}

