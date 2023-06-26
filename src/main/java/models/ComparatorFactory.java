package models;


import enums.StudentEnum;
import enums.UniversityEnum;

import java.util.Comparator;

public class ComparatorFactory {
    public static Comparator<Student> getStudentComparator(StudentEnum studentEnum) {
        return studentEnum.getComparator();
    }

    public static Comparator<University> getUniversityComparator(UniversityEnum universityEnum) {
        return universityEnum.getComparator();
    }
}
