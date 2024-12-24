package org.tommap.springmapstruct.source_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString
public class Animal {
    String name;
    String type;
    Date dob;
    String color;
}
