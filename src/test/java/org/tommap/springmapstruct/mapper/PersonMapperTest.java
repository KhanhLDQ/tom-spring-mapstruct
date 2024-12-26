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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
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

    @Test
    @DisplayName("test mapping - list collection")
    void testMappingListCollection() {
        //arrange
        person.setPersonType(PersonType.MANAGER);

        List<Person> persons = new ArrayList<>();
        persons.add(person);

        //act
        List<PersonDTO> personDTOs = personMapper.toPersonDTOs(persons);

        //assert
        assertFalse(personDTOs.isEmpty(), "personDTOs is empty");
        assertEquals("Tom", personDTOs.get(0).getFirstName(), "firstName should be Tom");
        assertEquals("Map", personDTOs.get(0).getLastName(), "lastName should be Map");
        assertEquals(PersonType.MANAGER, personDTOs.get(0).getType(), "personType should be MANAGER");
    }

    @Test
    @DisplayName("test mapping - map collection")
    void testMappingMapCollection() {
        //arrange
        person.setPersonType(PersonType.MANAGER);
        Map<Long, Person> personMap = Map.of(1L, person);

        //act
        Map<Long, PersonDTO> personDTOMap = personMapper.toPersonDTOMap(personMap);

        //assert
        assertInstanceOf(PersonDTO.class, personDTOMap.get(1L), "personDTO is not instance of PersonDTO");
        assertEquals("Tom", personDTOMap.get(1L).getFirstName(), "firstName should be Tom");
        assertEquals("Map", personDTOMap.get(1L).getLastName(), "lastName should be Map");
        assertEquals(PersonType.MANAGER, personDTOMap.get(1L).getType(), "personType should be MANAGER");
    }
}
