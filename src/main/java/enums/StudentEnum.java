package enums;

import models.Student;

import java.util.Comparator;

public enum StudentEnum {
    FULL_NAME(Comparator.comparing(Student::getFullName)),
    ID(Comparator.comparing(Student::getUniversityId)),
    COURSE_NUMBER(Comparator.comparingInt(Student::getCurrentCourseNumber)),
    AVG_EXAM_SCORE(Comparator.comparingDouble(Student::getAvgExamScore));
    private final Comparator<Student> comparator;

    StudentEnum(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Student> getComparator() {
        return comparator;
    }
}

