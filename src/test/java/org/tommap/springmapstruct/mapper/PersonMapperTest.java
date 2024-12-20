package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Person;
import org.tommap.springmapstruct.target_package.PersonDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonMapperTest {
    PersonMapper personMapper;

    @BeforeEach
    void init() {
        personMapper = Mappers.getMapper(PersonMapper.class);
    }

    @Test
    @DisplayName("mapping - same data type & name")
    void testDefaultMapping() throws ParseException {
        //arrange
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dob = dateFormat.parse("02-09-1997");

        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Tom");
        person.setLastName("Map");
        person.setDob(dob);

        //act
        PersonDTO personDTO = personMapper.toPersonDTO(person);

        //assert
        assertNotNull(personMapper, "personMapper is null");
        assertNotNull(personDTO, "personDTO is null");
        assertEquals("Tom", personDTO.getFirstName(), "firstName should be Tom");
        assertEquals("Map", personDTO.getLastName(), "lastName should be Map");
    }
}
