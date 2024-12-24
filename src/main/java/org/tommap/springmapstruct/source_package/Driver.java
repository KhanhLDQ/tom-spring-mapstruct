package org.tommap.springmapstruct.source_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString
public class Driver {
    String licenseNumber;
    String name;
    Date licenseExpiryDate;
}
