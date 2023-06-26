package enums;

import models.University;

import java.util.Comparator;

public enum UniversityEnum {
    ID(Comparator.comparing(University::getId)),
    FULL_NAME(Comparator.comparing(University::getFullName)),
    SHORT_NAME(Comparator.comparing(University::getShortName)),
    YEAR_OF_FOUNDATION(Comparator.comparing(University::getYearOfFoundation)),
    STUDY_PROFILE(Comparator.comparing(University::getMainProfile));

    private final Comparator<University> comparator;

    UniversityEnum(Comparator<University> comparator) {
        this.comparator = comparator;
    }

    public Comparator<University> getComparator() {
        return comparator;
    }
}
