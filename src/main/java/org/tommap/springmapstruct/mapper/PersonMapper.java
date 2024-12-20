package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.tommap.springmapstruct.source_package.Person;
import org.tommap.springmapstruct.target_package.PersonDTO;

@Mapper
public interface PersonMapper {
    PersonDTO toPersonDTO(Person person);
}
