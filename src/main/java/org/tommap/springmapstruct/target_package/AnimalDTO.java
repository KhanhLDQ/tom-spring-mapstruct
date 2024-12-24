package org.tommap.springmapstruct.target_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class AnimalDTO {
    String name;
    String type;
    Integer age;
    String animalColor;
}
