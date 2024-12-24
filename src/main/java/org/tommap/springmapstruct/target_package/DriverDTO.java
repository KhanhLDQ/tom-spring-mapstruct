package org.tommap.springmapstruct.target_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class DriverDTO {
    String licenseNumber;
    String name;
    Integer expiresIn;
    String test;
}
