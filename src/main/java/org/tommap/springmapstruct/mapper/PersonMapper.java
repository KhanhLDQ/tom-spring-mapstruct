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
    /*
        - defaultValue => if the source value is null, the default value will be used
        - constant => provide a fixed & hardcoded value to the target field, regardless of the source field value
     */
    @Mapping(target = "type", source = "personType")
    @Mapping(target = "occupation", ignore = true)
    @Mapping(target = "employmentStatus", source = "workStatus", defaultValue = "Unemployed")
    @Mapping(target = "numOfChildren", constant = "5")
    PersonDTO toPersonDTO(Person person);

    List<PersonDTO> toPersonDTOs(List<Person> persons);

    Map<Long, PersonDTO> toPersonDTOMap(Map<Long, Person> personMap);

    Stream<PersonDTO> toPersonDTOStream(Stream<Person> personStream);

    void updatePersonDTO(@MappingTarget PersonDTO personDTO, Person person);
}
