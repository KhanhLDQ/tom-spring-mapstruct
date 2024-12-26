package org.tommap.springmapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.tommap.springmapstruct.source_package.Person;
import org.tommap.springmapstruct.target_package.PersonDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Mapper
public interface PersonMapper {
    @Mapping(target = "type", source = "personType")
    PersonDTO toPersonDTO(Person person);

    List<PersonDTO> toPersonDTOs(List<Person> persons);

    Map<Long, PersonDTO> toPersonDTOMap(Map<Long, Person> personMap);

    Stream<PersonDTO> toPersonDTOStream(Stream<Person> personStream);

    void updatePersonDTO(@MappingTarget PersonDTO personDTO, Person person);
}
