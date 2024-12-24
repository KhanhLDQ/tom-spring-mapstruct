package org.tommap.springmapstruct.target_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CarDTO {
    String registerNumber;
    String modelNumber;
    String company;
    DriverDTO driver;
}
