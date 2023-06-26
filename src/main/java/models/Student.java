package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data                       // генерирует геттеры и сеттеры для всех полей класса
@NoArgsConstructor          // генерирует конструктор без параметров
@AllArgsConstructor         // генерирует конструктор, принимающий значения всех полей класса
@EqualsAndHashCode          // генерирует методы equals() и hashCode() на основе всех полей класса
@ToString                    // генерирует метод toString()
@Builder
public class Student {
    @SerializedName("studentName")
    private String fullName;
    @SerializedName("universityId")
    private String universityId;
    @SerializedName("course")
    private int currentCourseNumber;
    @SerializedName("avgScore")
    private float avgExamScore;
}
