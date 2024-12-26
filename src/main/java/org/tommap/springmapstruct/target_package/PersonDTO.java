package org.tommap.springmapstruct.target_package;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.tommap.springmapstruct.source_package.PersonType;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    String firstName;
    String lastName;
    String officeName;
    String officeAddress;
    String officeCountry;
    Long officeZipCode;
    PersonType type;
    String occupation;
    String employmentStatus;
    Integer numOfChildren;
}
