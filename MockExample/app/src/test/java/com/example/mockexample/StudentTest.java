package com.example.mockexample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class StudentTest {
//    @Mock
//    StudentService studentService;
//    OR
    StudentService studentService = Mockito.mock(StudentService.class);
    StudentClass studentClass;

    @Before
    public void setUp(){
        studentClass = new StudentClass(studentService);
    }

    @Test
    public void TestAverage(){

//       create dummy data..
        Mockito.when(studentService.getStudentMarks()).thenReturn(500);
        Mockito.when(studentService.getTotalNumberOfStudents()).thenReturn(10);

        Assert.assertEquals(50, studentClass.getAverageMarksOfStudent());
    }

}
