package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ValueMapping;
import org.tommap.springmapstruct.source_package.Person;
import org.tommap.springmapstruct.source_package.PersonType;
import org.tommap.springmapstruct.source_package.SalaryType;
import org.tommap.springmapstruct.target_package.PersonSalaryDTO;

@Mapper
public interface PersonSalaryMapper {
    /* - first option:
        @Mapping(target = "salaryType", source = "personType")
        PersonSalaryDTO toPersonSalaryDTO(Person person);

        @ValueMapping(target = "HIGH_SALARY", source = "CEO")
        @ValueMapping(target = "HIGH_SALARY", source = "MANAGER")
        @ValueMapping(target = "LOW_SALARY", source = "EMPLOYEE")
        SalaryType toSalaryType(PersonType personType);
     */

    //second option:
    @Mapping(target = "salaryType", source = "personType", qualifiedByName = "mapToSalaryType")
    PersonSalaryDTO toPersonSalaryDTO(Person person);

    @Named("mapToSalaryType")
    default SalaryType toSalaryType(PersonType personType) {
        if (PersonType.EMPLOYEE == personType) {
            return SalaryType.LOW_SALARY;
        } else if (PersonType.MANAGER == personType || PersonType.CEO == personType) {
            return SalaryType.HIGH_SALARY;
        } else {
            throw new IllegalArgumentException("Unexpected enum constant: " + personType);
        }
    }
}
