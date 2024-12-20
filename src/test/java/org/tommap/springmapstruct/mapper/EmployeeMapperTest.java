package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Employee;
import org.tommap.springmapstruct.source_package.Office;
import org.tommap.springmapstruct.target_package.PersonDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeMapperTest {
    EmployeeMapper employeeMapper;

    @BeforeEach
    void init() {
        employeeMapper = Mappers.getMapper(EmployeeMapper.class);
    }

    @Test
    @DisplayName("mapping - multiple sources")
    void testDifferentNameMapping() {
        //arrange
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setEmpFirstName("Tom");
        employee.setEmpLastName("Map");

        Office office = new Office();
        office.setId(1L);
        office.setName("office");
        office.setAddress("address");
        office.setCountry("country");
        office.setZipCode(12345L);

        //act
        PersonDTO personDTO = employeeMapper.toPersonDTO(employee, office);

        //assert
        assertNotNull(employeeMapper, "employeeMapper is null");
        assertNotNull(personDTO, "personDTO is null");

        assertEquals("Tom", personDTO.getFirstName(), "firstName should be Tom");
        assertEquals("Map", personDTO.getLastName(), "lastName should be Map");
        assertEquals("office", personDTO.getOfficeName(), "officeName should be office");
        assertEquals("address", personDTO.getOfficeAddress(), "officeAddress should be address");
        assertEquals("country", personDTO.getOfficeCountry(), "officeCountry should be country");
        assertEquals(12345L, personDTO.getOfficeZipCode(), "officeZipCode should be 12345");
    }
}
