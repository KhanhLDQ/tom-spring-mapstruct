package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tommap.springmapstruct.source_package.Person;
import org.tommap.springmapstruct.target_package.PersonDTO;

@Mapper
public interface PersonMapper {
    @Mapping(target = "type", source = "personType")
    PersonDTO toPersonDTO(Person person);
}
