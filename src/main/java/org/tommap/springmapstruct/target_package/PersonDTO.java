package org.tommap.springmapstruct.target_package;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
}
