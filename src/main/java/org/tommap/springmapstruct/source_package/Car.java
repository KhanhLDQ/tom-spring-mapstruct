package org.tommap.springmapstruct.source_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Car {
    String registerNumber;
    String modelNumber;
    String company;
    Driver driver;
}
