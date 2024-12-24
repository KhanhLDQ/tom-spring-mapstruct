package org.tommap.springmapstruct.source_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Employee {
    Long id;
    String empFirstName;
    String empLastName;
    Office office;
}
