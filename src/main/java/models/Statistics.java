package models;

import enums.StudyProfile;
import lombok.*;

@Data                       // генерирует геттеры и сеттеры для всех полей класса
@NoArgsConstructor          // генерирует конструктор без параметров
@AllArgsConstructor         // генерирует конструктор, принимающий значения всех полей класса
@ToString                   // генерирует метод toString()
@Builder
public class Statistics {

    private StudyProfile profile;
    private float avgExamScore;
    private int numberOfStudents;
    private int numberOfUniversities;
    private String universityNames;

//    public StudyProfile getProfile() {
//        return profile;
//    }
//
//    public Statistics setProfile(StudyProfile profile) {
//        this.profile = profile;
//        return this;
//    }
//
//    public float getAvgExamScore() {
//        return avgExamScore;
//    }
//
//    public Statistics setAvgExamScore(float avgExamScore) {
//        this.avgExamScore = avgExamScore;
//        return this;
//    }
//
//    public int getNumberOfStudents() {
//        return numberOfStudents;
//    }
//
//    public Statistics setNumberOfStudents(int numberOfStudents) {
//        this.numberOfStudents = numberOfStudents;
//        return this;
//    }
//
//    public int getNumberOfUniversities() {
//        return numberOfUniversities;
//    }
//
//    public Statistics setNumberOfUniversities(int numberOfUniversities) {
//        this.numberOfUniversities = numberOfUniversities;
//        return this;
//    }
//
//    public String getUniversityNames() {
//        return universityNames;
//    }
//
//    public Statistics setUniversityNames(String universityNames) {
//        this.universityNames = universityNames;
//        return this;
//    }
}
