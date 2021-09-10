package org.java.training.autumn.student;

import java.util.Random;

import static org.java.training.autumn.samples.student.StudentGroups.FIRST;
import static org.java.training.autumn.samples.student.StudentGroups.SECOND;
import static org.junit.Assert.assertTrue;

import org.java.training.autumn.samples.student.Student;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class TestStudent
{

    @Test
    public void testEqualStudents(){
        Student a = new Student("a", 16, FIRST);
        Student b = new Student("a", 21, FIRST);
        Assert.assertEquals(a, b);
    }

    @Test
    public void testNotEqualStudents(){
        Student a = new Student("a", 16, FIRST);
        Student b = new Student("a", 21, SECOND);
        Assert.assertNotEquals(a, b);
    }

    @Test
    public void testStudentReflexivity(){
        Student a = new Student("a", 16, FIRST);
        Assert.assertEquals(a, a);
    }

    @Test
    public void testStudentSymmetry(){
        Student a = new Student("a", 16, FIRST);
        Student b = new Student("a", 21, FIRST);
        if(!a.equals(b) || !b.equals(a)){Assert.fail();}
    }

    @Test
    public void testEqualsNull(){
        Student a = new Student("a", 16, FIRST);
        Assert.assertNotNull(a);
    }

    @Test
    public void testHashCode(){
        // get random name
        Random myRandom = new Random();
        byte[] bytes = new byte[10];
        myRandom.nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<10;i++){
            char c = (char)bytes[i];
            sb.append(c);
        }

        Student a = new Student(sb.toString(), myRandom.nextInt(),SECOND);
        Student b = new Student(sb.toString(), myRandom.nextInt(),SECOND);

        Assert.assertEquals(a.hashCode(), b.hashCode());
    }
}
