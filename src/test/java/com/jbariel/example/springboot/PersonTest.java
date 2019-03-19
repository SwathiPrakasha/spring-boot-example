package com.jbariel.example.springboot;

import com.jbariel.example.springboot.controllers.HelloWorldController;
import com.jbariel.example.springboot.controllers.PersonController;
import com.jbariel.example.springboot.controllers.StudentController;
import com.jbariel.example.springboot.models.Person;
import com.jbariel.example.springboot.models.Student;
import com.jbariel.example.springboot.persistance.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

public class PersonTest{
    @InjectMocks
    private StudentController studentController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void whenPersonFindAllIsCalledReturnAllPersons() throws Exception{
        List<Student> students = new ArrayList<>();

        Student stu = new Student();
        stu.withFirstName("Komal").withLastName("kubsad").withGrade(70);
        students.add(stu);
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        Assert.assertEquals(students, studentController.getAll());
    }


    @Test
    public void whenIdIsGivenReturnPerson() throws Exception {
        Student stu1 = new Student();
        stu1.withId(1).withFirstName("Swathi").withLastName("P").withGrade(80);
        Mockito.when(studentRepository.findById((long)1)).thenReturn(java.util.Optional.of(stu1));
        Assert.assertEquals(stu1,studentController.getById((long)1));
    }

    @Test
    public void whenStudentCreatedShouldReturnStudent() throws Exception {
        Student stu2 = new Student();
        Mockito.when(studentRepository.save(stu2)).thenReturn(stu2);
        System.out.println(stu2.getFirstName());
        Assert.assertEquals(stu2,studentController.create(stu2));
    }
}