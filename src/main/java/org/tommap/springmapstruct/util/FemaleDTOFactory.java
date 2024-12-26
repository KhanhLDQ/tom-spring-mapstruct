package org.tommap.springmapstruct.util;

import org.mapstruct.Named;
import org.tommap.springmapstruct.target_package.FemaleTeacherDTO;

public class FemaleDTOFactory {
    @Named("init")
    public FemaleTeacherDTO init() {
        FemaleTeacherDTO femaleTeacherDTO = new FemaleTeacherDTO();
        femaleTeacherDTO.setGender("Tom_Female_DTO");
        femaleTeacherDTO.setCreateBy("Factory");

        return femaleTeacherDTO;
    }

    public FemaleTeacherDTO init_second_option() {
        FemaleTeacherDTO femaleTeacherDTO = new FemaleTeacherDTO();
        femaleTeacherDTO.setGender("Tom_Female_DTO");
        femaleTeacherDTO.setCreateBy("Factory_second_option");

        return femaleTeacherDTO;
    }
}
