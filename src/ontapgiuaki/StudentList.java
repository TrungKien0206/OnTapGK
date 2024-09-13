
package ontapgiuaki;

import java.util.ArrayList;


class StudentList {
    private ArrayList<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Delete a student by ID
    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    // Find a student by ID
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println("--------------------");
        }
    }

    // Find the student with the highest GPA
    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}