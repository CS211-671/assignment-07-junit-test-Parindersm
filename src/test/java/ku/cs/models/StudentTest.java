package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore() {
        Student s1 = new Student("6610450269", "Seiya");
        assertEquals(0, s1.getScore());
        s1.addScore(40.5);
        assertEquals(40.5, s1.getScore());
        s1.addScore(10);
        assertEquals(50.5, s1.getScore());
    }
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade() {
        Student s = new Student("6610450269", "Seiya");
        s.addScore(60.5);
        assertEquals("C", s.grade());
    }

    @Test
    void testChangeName() {
        Student s2 = new Student("6610450269", "Seiya");
        s2.changeName("   Tonnam    ");
        assertEquals("Tonnam", s2.getName());
        s2.changeName("        ");
        assertEquals("Tonnam", s2.getName());
    }

    @Test
    void testIsId() {
        Student s2 = new Student("6610450269", "Seiya");
        assertTrue(s2.isId("6610450269"));
        assertFalse(s2.isId("661045111"));
        assertFalse(s2.isId(""));
        assertFalse(s2.isId(null));
    }

    @Test
    void testToString() {
        Student s2 = new Student("6610450269", "Seiya");
        String expected = "{id: '6610450269', name: 'Seiya', score: 0.0}";
        assertEquals(expected, s2.toString());
    }
}