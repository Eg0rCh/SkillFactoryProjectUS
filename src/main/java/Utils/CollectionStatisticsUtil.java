package Utils;

import models.Statistics;
import models.Student;
import models.University;
import enums.StudyProfile;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionStatisticsUtil {

    public static List<Statistics> createStatistics(List<Student> students,
                                                    List<University> universities) {

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .toList();

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .toList();

            OptionalDouble averageScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();

            BigDecimal bdAverageScore = BigDecimal.valueOf(averageScore.orElse(0))
                    .setScale(2, RoundingMode.HALF_UP);
            float avgScore = bdAverageScore.floatValue();

            String universityNames = universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .collect(Collectors.joining(";"));

            Statistics statistics = Statistics.builder()
                    .profile(profile)
                    .numberOfStudents(profileStudents.size())
                    .numberOfUniversities(profileUniversityIds.size())
                    .universityNames(StringUtils.defaultString(universityNames))
                    .avgExamScore(avgScore)
                    .build();

            statisticsList.add(statistics);
        });

        return statisticsList;
    }
}
