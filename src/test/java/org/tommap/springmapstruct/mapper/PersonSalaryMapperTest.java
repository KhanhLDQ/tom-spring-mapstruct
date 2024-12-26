package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Person;
import org.tommap.springmapstruct.source_package.PersonType;
import org.tommap.springmapstruct.source_package.SalaryType;
import org.tommap.springmapstruct.target_package.PersonSalaryDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonSalaryMapperTest {
    PersonSalaryMapper personSalaryMapper;
    Person person;

    @BeforeEach
    void init() {
        personSalaryMapper = Mappers.getMapper(PersonSalaryMapper.class);

        person = new Person();
        person.setId(1L);
        person.setFirstName("Tom");
        person.setLastName("Map");
        person.setPersonType(PersonType.MANAGER);
    }

    @Test
    @DisplayName("test enum mapping - different types")
    void testDifferentTypesEnumMapping() {
        //arrange

        //act
        PersonSalaryDTO personSalaryDTO = personSalaryMapper.toPersonSalaryDTO(person);

        //assert
        assertNotNull(personSalaryDTO, "personSalaryDTO is null");
        assertEquals("Tom", personSalaryDTO.getFirstName(), "firstName should be Tom");
        assertEquals("Map", personSalaryDTO.getLastName(), "lastName should be Map");
        assertEquals(SalaryType.HIGH_SALARY, personSalaryDTO.getSalaryType(), "salaryType should be HIGH_SALARY");
    }
}
