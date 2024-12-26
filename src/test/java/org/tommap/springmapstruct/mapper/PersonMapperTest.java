package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Person;
import org.tommap.springmapstruct.source_package.PersonType;
import org.tommap.springmapstruct.target_package.PersonDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonMapperTest {
    PersonMapper personMapper;
    Person person;

    @BeforeEach
    void init() throws ParseException {
        personMapper = Mappers.getMapper(PersonMapper.class);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dob = dateFormat.parse("02-09-1997");

        person = new Person();
        person.setId(1L);
        person.setFirstName("Tom");
        person.setLastName("Map");
        person.setDob(dob);
    }

    @Test
    @DisplayName("mapping - same data type & name")
    void testDefaultMapping() {
        //arrange

        //act
        PersonDTO personDTO = personMapper.toPersonDTO(person);

        //assert
        assertNotNull(personMapper, "personMapper is null");
        assertNotNull(personDTO, "personDTO is null");
        assertEquals("Tom", personDTO.getFirstName(), "firstName should be Tom");
        assertEquals("Map", personDTO.getLastName(), "lastName should be Map");
    }

    @Test
    @DisplayName("test enum mapping")
    void testEnumMapping() {
        //arrange
        person.setPersonType(PersonType.MANAGER);

        //act
        PersonDTO personDTO = personMapper.toPersonDTO(person);

        //assert
        assertNotNull(personDTO, "personDTO is null");
        assertEquals("Tom", personDTO.getFirstName(), "firstName should be Tom");
        assertEquals("Map", personDTO.getLastName(), "lastName should be Map");
        assertEquals(PersonType.MANAGER, personDTO.getType(), "personType should be MANAGER");
    }
}
