package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่")
    void testAddNewStudent() {
        StudentList list = new StudentList();
        list.addNewStudent("6610450269", "Seiya");
        assertEquals(1, list.getStudents().size());
        assertEquals("Seiya", list.getStudents().get(0).getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่ด้วยคะแนน")
    void testAddNewStudentWithScore() {
        StudentList list = new StudentList();
        list.addNewStudent("6610450269", "Seiya", 75.0);
        assertEquals(1, list.getStudents().size());
        assertEquals(75.0, list.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการหา Student ด้วย ID")
    void testFindStudentById() {
        StudentList list = new StudentList();
        list.addNewStudent("6610450269", "Seiya");
        assertNotNull(list.findStudentById("6610450269"));
        assertNull(list.findStudentById("6610450111"));
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนนักเรียน")
    void testGiveScoreToId() {
        StudentList list = new StudentList();
        list.addNewStudent("6610450269", "Seiya");
        list.giveScoreToId("6610450269", 20.0);
        assertEquals(20.0, list.findStudentById("6610450269").getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของนักเรียน")
    void testViewGradeOfId() {
        StudentList list = new StudentList();
        list.addNewStudent("6610450269", "Seiya", 85.0);
        assertEquals("A", list.viewGradeOfId("6610450269"));
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนที่มี ID ซ้ำ")
    void testAddDuplicateStudent() {
        StudentList list = new StudentList();
        list.addNewStudent("6610450269", "Seiya");
        list.addNewStudent("6610450269", "Oat");
        assertEquals(1, list.getStudents().size());
        assertEquals("Seiya", list.getStudents().get(0).getName());
    }

}