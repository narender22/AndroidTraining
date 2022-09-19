package com.example.mockexample;

public class StudentClass {

    StudentService studentService;

    public StudentClass(StudentService studentService) {
        this.studentService = studentService;
    }

    public int getAverageMarksOfStudent(){

        return studentService.getStudentMarks()/studentService.getTotalNumberOfStudents();
    }
}
