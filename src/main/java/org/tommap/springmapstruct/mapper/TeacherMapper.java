package org.tommap.springmapstruct.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.tommap.springmapstruct.source_package.Teacher;
import org.tommap.springmapstruct.target_package.FemaleTeacherDTO;
import org.tommap.springmapstruct.target_package.MaleTeacherDTO;
import org.tommap.springmapstruct.target_package.TeacherDTO;
import org.tommap.springmapstruct.util.FemaleDTOFactory;
import org.tommap.springmapstruct.util.TeacherOperations;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Mapper(
        uses = {TeacherOperations.class, FemaleDTOFactory.class},
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
//        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, //default value - NullValueCheckStrategy.ON_IMPLICIT_CONVERSION
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
public interface TeacherMapper {
    /*
        - mapstruct conversion
            + date to string format = 9/2/97, 12:00 AM
            + double to string format = 12345.6789
     */
    @Mapping(target = "dob", source = "dob", dateFormat = "dd-MM-yyyy") //implicit conversion
    @Mapping(target = "salary", source = "salary", numberFormat = "#.00") //implicit conversion
    @Mapping(target = "age", source = "dob", qualifiedByName = "toAge", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "serviceInYears", source = "dob", qualifiedByName = "toServiceInYears")
    @Mapping(target = "unemployedInYears", source = "dob", qualifiedByName = "toUnemployedInYears")
//    @Mapping(target = "numOfYearsGraduated", source = "graduatedAt", qualifiedByName = "toNumOfYearsGraduated")
    TeacherDTO toTeacherDTO(Teacher teacher);

    @BeanMapping(resultType = MaleTeacherDTO.class)
    TeacherDTO toMale(Teacher teacher);

    @BeanMapping(resultType = FemaleTeacherDTO.class, qualifiedByName = "init")
    TeacherDTO toFemale(Teacher teacher);

    @Named("toAge")
    default int toAge(Date dob) {
        long diffInMillis = Math.abs(new Date().getTime() - dob.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        return (int) (diffInDays / 365);
    }

    @Named("toServiceInYears")
    default int toServiceInYears(Date dob) {
        return 5;
    }

//    @BeforeMapping //before creating TeacherDTO instance
//    default void beforeMapping() {
//
//    }

    @BeforeMapping //after creating TeacherDTO instance
    default void beforeMapping(@MappingTarget TeacherDTO teacherDTO, Teacher teacher) {
        if (null == teacherDTO.getUnknown()) {
            teacherDTO.setUnknown("unknown");
        }
    }

//    @BeforeMapping //order of two beforeMapping methods in impl classes by default is same as in interface
//    default void beforeMappingSecondPhase(@MappingTarget TeacherDTO teacherDTO, Teacher teacher) {
//
//    }

    @AfterMapping
    default void afterMapping(@MappingTarget TeacherDTO teacherDTO, Teacher teacher) {
        if (null == teacherDTO.getFullName()) {
            teacherDTO.setFullName("KhanhLQD");
        }
    }

//    @Named("toNumOfYearsGraduated")
//    default int toNumOfYearsGraduated(Date graduatedAt) throws IllegalArgumentException {
//        throw new IllegalArgumentException();
//    }
}
