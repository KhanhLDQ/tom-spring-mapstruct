package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tommap.springmapstruct.source_package.Employee;
import org.tommap.springmapstruct.target_package.PersonDTO;

@Mapper
public interface EmployeeMapper {
    @Mapping(target = "firstName", source = "empFirstName")
    @Mapping(target = "lastName", source = "empLastName")
    PersonDTO toPersonDTO(Employee employee);
}
