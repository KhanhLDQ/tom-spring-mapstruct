package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.tommap.springmapstruct.source_package.Teacher;
import org.tommap.springmapstruct.target_package.TeacherDTO;
import org.tommap.springmapstruct.util.TeacherOperations;

import java.util.Date;

@Mapper(uses = {TeacherOperations.class})
public interface TeacherMapper {
    /*
        - mapstruct conversion
            + date to string format = 9/2/97, 12:00 AM
            + double to string format = 12345.6789
     */
    @Mapping(target = "dob", source = "dob", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "salary", source = "salary", numberFormat = "#.00")
    @Mapping(target = "age", source = "dob", qualifiedByName = "toAge")
    @Mapping(target = "serviceInYears", source = "dob", qualifiedByName = "toServiceInYears")
    @Mapping(target = "unemployedInYears", source = "dob", qualifiedByName = "toUnemployedInYears")
    TeacherDTO toTeacherDTO(Teacher teacher);

    @Named("toAge")
    default int toAge(Date dob) {
        return 27;
    }

    @Named("toServiceInYears")
    default int toServiceInYears(Date dob) {
        return 5;
    }
}
