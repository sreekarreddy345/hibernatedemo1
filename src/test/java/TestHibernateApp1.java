import com.sreekar.hibernate.HibernateApp1;
import com.sreekar.hibernate.pojo.Person;
import com.sreekar.hibernate.pojo.Student;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHibernateApp1 {
    static long studentID = 0;
    static long personID = 0;
    static long personID1 = 0;

    private HibernateApp1 app1 = new HibernateApp1();

    @Test
    @Ignore
    public void testSessionFactory() {
        SessionFactory sf = app1.getSessionFactory();
        assertNotNull("SessionFactory should not be null", sf);
    }

    @Test
    public void test1SaveStudent() {

        Student student = new Student("sreekar", 99);
        studentID = app1.saveStudent(student);
        System.out.println("studentID - " + studentID);
        assertNotEquals(0, studentID);
    }

    @Test
    public void test2GetStudent() {
        System.out.println("studentID - " + studentID);
        Student stu = app1.getStudent(studentID);
        System.out.println("stu " + stu);
        if (stu == null) {
            test1SaveStudent();
            stu = app1.getStudent(studentID);
        }
        assertNotNull(stu);
        assertEquals(studentID, stu.getStudentId());
    }

    @Test
    public void test3UpdateStudent() {
        System.out.println("studentID - " + studentID);
        Student stu = app1.getStudent(studentID);
        if (stu == null) {
            test1SaveStudent();
            stu = app1.getStudent(studentID);
        }
        stu.setStudentName("Reddy");
        boolean isUpdated = app1.updateStudent(stu);
        assertTrue(isUpdated);
    }

    @Test
    public void test4DeleteStudent() {


        System.out.println(studentID);
//        Student stu = app1.getStudent(studentID);
        Student student = new Student(studentID);
        boolean isDeleted = app1.deleteStudent(student);
        assertTrue(isDeleted);
    }

    @Test
    public void test5SavePerson() {
        personID = 0;
        Person person = new Person("suchin", 2);
        Person person4 = new Person("suchin", 2);

        personID = app1.savePerson(person);
        personID1 = app1.savePerson(person4);
        System.out.println("personID - " + personID);
        System.out.println("personID1 - " + personID1);
        assertNotEquals(0, personID);
        assertNotEquals(0, personID1);


    }

    @Test
    @Ignore
    public void test2GetPerson() {
        System.out.println("personID - " + personID1);
        Person per = app1.getPerson(personID1);
        System.out.println("per " + per);
        if (per == null) {
            test5SavePerson();
            per = app1.getPerson(personID1);
        }
        assertNotNull(per);
        assertEquals(personID1, per.getId());
    }

    @Before
    public void init() {
        System.out.println("init - " + studentID);
    }

}
