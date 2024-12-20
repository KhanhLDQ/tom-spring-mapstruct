package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Employee;
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
    @DisplayName("mapping - same data type - different name")
    void testDifferentNameMapping() {
        //arrange
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setEmpFirstName("Tom");
        employee.setEmpLastName("Map");

        //act
        PersonDTO personDTO = employeeMapper.toPersonDTO(employee);

        //assert
        assertNotNull(employeeMapper, "employeeMapper is null");
        assertNotNull(personDTO, "personDTO is null");
        assertEquals("Tom", personDTO.getFirstName(), "firstName should be Tom");
        assertEquals("Map", personDTO.getLastName(), "lastName should be Map");
    }
}
