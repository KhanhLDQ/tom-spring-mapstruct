package org.tommap.springmapstruct.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.tommap.springmapstruct.source_package.Teacher;
import org.tommap.springmapstruct.target_package.TeacherDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TeacherMapperTest {
    TeacherMapper teacherMapper;
    Teacher teacher;

    @BeforeEach
    void init() throws ParseException {
        teacherMapper = Mappers.getMapper(TeacherMapper.class);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dob = dateFormat.parse("02-09-1997");

        teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirstName("Tom");
        teacher.setLastName("Map");
        teacher.setDob(dob);
        teacher.setSalary(12345.6789);
    }

    @Test
    @DisplayName("test teacher mapping")
    void testTeacherMapping() {
        //arrange

        //act
        TeacherDTO teacherDTO = teacherMapper.toTeacherDTO(teacher);
        System.out.println(teacherDTO);

        //assert
        assertNotNull(teacherDTO, "teacherDTO is null");
        assertEquals("Tom", teacherDTO.getFirstName(), "firstName should be Tom");
        assertEquals("Map", teacherDTO.getLastName(), "lastName should be Map");
        assertEquals("02-09-1997", teacherDTO.getDob(), "dob should be 02-09-1997");
        assertEquals("12345.68", teacherDTO.getSalary(), "salary should be 12345.68");
        assertEquals(27, teacherDTO.getAge(), "age should be 27");
        assertEquals(5, teacherDTO.getServiceInYears(), "serviceInYears should be 5");
        assertEquals(2, teacherDTO.getUnemployedInYears(), "unemployedInYears should be 2");
    }
}
