package org.tommap.springmapstruct.target_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class TeacherDTO {
    String firstName;
    String lastName;
    String dob;
    String salary;
    int age;
    int serviceInYears;
    int unemployedInYears;
    int numOfYearsGraduated;
    String fullName;
    String unknown;
}
