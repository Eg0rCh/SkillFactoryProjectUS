package models;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class University {

    @SerializedName("universityId")
    private String id;
    @SerializedName("universityName")
    private String fullName;
    @SerializedName("universityShortName")
    private String shortName;
    @SerializedName("foundation")
    private int yearOfFoundation;
    @SerializedName("profile")
    private StudyProfile mainProfile;

}
