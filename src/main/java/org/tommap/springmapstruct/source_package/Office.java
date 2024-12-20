package org.tommap.springmapstruct.source_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Office {
    Long id;
    String name;
    String address;
    String country;
    Long zipCode;
}
