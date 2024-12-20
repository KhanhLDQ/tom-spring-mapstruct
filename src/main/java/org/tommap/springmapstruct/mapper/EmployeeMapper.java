package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tommap.springmapstruct.source_package.Employee;
import org.tommap.springmapstruct.source_package.Office;
import org.tommap.springmapstruct.target_package.PersonDTO;

@Mapper
public interface EmployeeMapper {
    @Mapping(target = "firstName", source = "employee.empFirstName")
    @Mapping(target = "lastName", source = "employee.empLastName")
    @Mapping(target = "officeName", source = "office.name")
    @Mapping(target = "officeAddress", source = "office.address")
    @Mapping(target = "officeCountry", source = "office.country")
    @Mapping(target = "officeZipCode", source = "office.zipCode")
    PersonDTO toPersonDTO(Employee employee, Office office);
}
