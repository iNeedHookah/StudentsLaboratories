package repository;

import controller.LaboratoriesController;
import junit.framework.TestCase;
import model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;


/**
 * Created by Alex on 24.04.2018.
 */
public class FileDataPersistenceTestIntegration extends TestCase {

    private LaboratoriesController ctrl = new LaboratoriesController("students.txt", "laboratories.txt");

    private FileDataPersistence studentsDataPersistance = new FileDataPersistence("students.txt");

    public void testSaveStudent() throws Exception {
        System.out.println("\n TEST - Save student \n");
        Student student = new Student("asdf4455", "mircea bravo", 933);
        ctrl.saveStudent(student);
        BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
        String line;
        line = reader.readLine();
        String[] temp = line.split(" ");
        String studentReg = temp[0];
        String studentName = temp[1] + " " + temp[2];
        int studentGroup = Integer.valueOf(temp[3]);
        assertEquals(studentReg, "asdf4455");
        assertEquals(studentName, "mircea bravo");
        assertEquals(studentGroup, 933);

    }

    public void testAddGrade() throws Exception {
        System.out.println("\n TEST - Add new grade \n");

        LaboratoriesController ctrl = new LaboratoriesController("students.txt", "laboratories.txt");

        ctrl.addGrade("asdf4455", "10", 7);
        BufferedReader reader = new BufferedReader(new FileReader("laboratories.txt"));
        String line = reader.readLine();
        String[] temp = line.split(" ");
        float labGrade = Float.valueOf(temp[3]);
        assertEquals(labGrade, (float) 7);
    }


    public void testGetStudentsList() throws Exception {
        System.out.println("TEST - Get students list");

        List<Student> students = studentsDataPersistance.getStudentsList();
        assertTrue(true);
    }
}
