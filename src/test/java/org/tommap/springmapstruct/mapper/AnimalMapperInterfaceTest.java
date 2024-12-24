package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Animal;
import org.tommap.springmapstruct.target_package.AnimalDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnimalMapperInterfaceTest {
    AnimalMapperInterface animalMapper;

    @BeforeEach
    void init() {
        animalMapper = Mappers.getMapper(AnimalMapperInterface.class);
    }

    @Test
    @DisplayName("Test from AnimalMapperInterface")
    void testFromAnimalMapperInterface() throws ParseException {
        // Arrange
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dob = dateFormat.parse("02-09-1997");

        Animal animal = new Animal();
        animal.setName("name");
        animal.setType("type");
        animal.setColor("yellow");
        animal.setDob(dob);

        // Act
        AnimalDTO animalDTO = animalMapper.toAnimalDTO(animal);

        // Assert
        assertNotNull(animalMapper, "animalMapper should not be null");
        assertNotNull(animalDTO, "animalDTO should not be null");

        assertEquals("name", animalDTO.getName(), "name should be equal");
        assertEquals("type", animalDTO.getType(), "type should be equal");
        assertEquals(27, animalDTO.getAge(), "age should be equal");
        assertEquals("yellow", animalDTO.getAnimalColor(), "color should be equal");
    }
}
