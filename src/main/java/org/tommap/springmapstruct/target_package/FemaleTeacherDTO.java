package org.tommap.springmapstruct.target_package;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class FemaleTeacherDTO extends TeacherDTO{
    String createBy;

    public FemaleTeacherDTO() {
        super();
        setGender("Tom_Female_DTO");
    }
}
