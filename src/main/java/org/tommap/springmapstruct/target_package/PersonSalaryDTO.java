package org.tommap.springmapstruct.target_package;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.tommap.springmapstruct.source_package.SalaryType;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonSalaryDTO {
    String firstName;
    String lastName;
    SalaryType salaryType;
}
